package org.nuzhd.service;

import org.nuzhd.model.LlamaPrompt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LlamaPromptService {

    private final RestTemplate restTemplate;
    @Value("${llama.root-uri}")
    private String llamaUri;

    public LlamaPromptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendPrompt(String question, String context) {

        LlamaPrompt llamaPrompt = new LlamaPrompt("%s question:%s".formatted(context, question),
                """
                        Imagine you are financial analyst. Your task is to analyze the context information you will be provided and answer the user's question corresponding to the provided info.
                        User question will follow after 'question:' keyword. If context contains some another questions, don't answer them and concentrate only on user question.
                        Present numerical information in human readable format, for example 33%, 143 млрд, 15млн etc.
                        Context and user question will be given in Russian language""",
                0.3,
                150,
                1,
                true,
                30,
                5);

        HttpEntity<LlamaPrompt> prompt = new HttpEntity<>(llamaPrompt);
        ResponseEntity<String> resp = restTemplate.exchange(llamaUri, HttpMethod.POST, prompt, String.class);
        String response = clearText(resp.getBody());

        return response;
    }

    private String clearText(String input) {
        Pattern p = Pattern.compile("question:");
        Matcher m = p.matcher(input);

        if (m.find()) {
            int start = m.start();
            input = input.substring(0, start);
        }

        return input.replace("answer:", "")
                .replace("\n", "")
                .replace("?", "")
                .replace("Ответ:", "")
                .trim();
    }
}
