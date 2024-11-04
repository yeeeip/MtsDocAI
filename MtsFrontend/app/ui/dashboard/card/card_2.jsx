import { MdSupervisedUserCircle } from "react-icons/md";
import styles from "./card.module.css";

const Card = () => {
  return (
    <div className={styles.container}>
      <MdSupervisedUserCircle size={24} />
      <div className={styles.texts}>
        <span className={styles.title}>Рентабельность по OIBDA (2024)</span>
        <span className={styles.number}>37.5%</span>
        <span className={styles.detail}>
          <span className={styles.negative}>-11.1%</span>
        </span>
      </div>
    </div>
  );
};

export default Card;
