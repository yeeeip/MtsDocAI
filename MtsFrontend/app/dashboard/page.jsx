import Barchart from "../ui/dashboard/barchart/barchart";
import Card from "../ui/dashboard/card/card";
import Card_2 from "../ui/dashboard/card/card_2";
import Card_3 from "../ui/dashboard/card/card_3";

import Chart from "../ui/dashboard/chart/chart";
import Chart_z from "../ui/dashboard/chart_z/chart_z";
import styles from "../ui/dashboard/dashboard.module.css";
import Rightbar from "../ui/dashboard/rightbar/rightbar";
import Transactions from "../ui/dashboard/transactions/transactions";
import Barchart_f from "../ui/dashboard/barchart_f/barchart_f";

const Dashboard = () => {
  return (
    <div className={styles.wrapper}>
      <div className={styles.main}>
      <div className={styles.cards}>
      <Card/>
      <Card_2/>
      <Card_3/>

        </div>
        {/* <Barchart /> */}
        <Barchart_f />
        <Chart />
        <Chart_z />
        <Transactions />

      </div>
      <div className={styles.side}>
        {/* <Rightbar /> */}
      </div>
    </div>
  );
};

export default Dashboard;
