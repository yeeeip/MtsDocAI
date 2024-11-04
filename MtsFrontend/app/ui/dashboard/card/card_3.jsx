import { MdSupervisedUserCircle } from "react-icons/md";
import styles from "./card.module.css";

const Card = () => {
  return (
    <div className={styles.container}>
      <MdSupervisedUserCircle size={24} />
      <div className={styles.texts}>
        <span className={styles.title}>Чистый долг. 2024г. (млрд.руб)</span>
        <span className={styles.number}>423.4</span>
        <span className={styles.detail}>
          <span className={styles.negative}>1.85%</span>
        </span>
      </div>
    </div>
  );
};

export default Card;
