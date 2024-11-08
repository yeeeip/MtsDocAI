"use client";

import { useState } from 'react';
import MessageList from '../messageList/messageList';
import InputBox from '../inputBox/inputBox';
import styles from './chatPage.module.css';

const ChatPage = () => {
  const [messages, setMessages] = useState([
    { text: 'Привет! Чем могу помочь?', sender: 'bot' },
  ]);

  const handleSendMessage = async (message) => {
    setMessages([...messages, { text: message, sender: 'user' }]);

    try {
      const response = await fetch('http://localhost:8080/api/v1/ask', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({text: message}),
      });

      if (response.ok) {
        const botMessage = await response.text();
        setMessages(prevMessages => [
          ...prevMessages,
          { text: botMessage, sender: 'bot' }
        ]);
      } else {
        console.error('Ошибка при получении ответа от бота');
      }
    } catch (error) {
      console.error('Ошибка сети:', error);
    }
  };

  return (
    <div className={styles.chatContainer}>
      <MessageList messages={messages} />
      <InputBox onSend={handleSendMessage} />
    </div>
  );
};

export default ChatPage;
