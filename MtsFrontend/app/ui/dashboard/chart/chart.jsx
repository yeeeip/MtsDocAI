"use client"

import styles from './chart.module.css'
import { LineChart, Line, XAxis, YAxis, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const data = [
  {
    "Год": 2009,
    "Валовая": 111213691,
    "От продаж": 66657912,
    "Чистая": 33480015,
    "kom_r": 25121442,
    "upr_r": 19434337
  },
  {
    "Год": 2010,
    "Валовая": 118167565,
    "От продаж": 65945486,
    "Чистая": 27428577,
    "kom_r": 33089665,
    "upr_r": 19132414
  },
  {
    "Год": 2011,
    "Валовая": 122456796,
    "От продаж": 64595493,
    "Чистая": 54129288,
    "kom_r": 36569705,
    "upr_r": 21300598
  },
  {
    "Год": 2012,
    "Валовая": 127934453,
    "От продаж": 70190971,
    "Чистая": 42949463,
    "kom_r": 33241387,
    "upr_r": 24502095
  },
  {
    "Год": 2013,
    "Валовая": 145256787,
    "От продаж": 73478290,
    "Чистая": 55999090,
    "kom_r": 44177545,
    "upr_r": 27609952
  },
  {
    "Год": 2014,
    "Валовая": 150368668,
    "От продаж": 74377911,
    "Чистая": 28372745,
    "kom_r": 47474858,
    "upr_r": 28515899
  },
  {
    "Год": 2015,
    "Валовая": 148330805,
    "От продаж": 72827733,
    "Чистая": 6590503,
    "kom_r": 46845936,
    "upr_r": 28657136
  },
  {
    "Год": 2016,
    "Валовая": 148855198,
    "От продаж": 70778305,
    "Чистая": 50658752,
    "kom_r": 48182276,
    "upr_r": 29894617
  }
];

const Chart = () => {
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>Прибыль</h2>
      <ResponsiveContainer width="100%" height="90%">
        <LineChart
          width={500}
          height={300}
          data={data}
          margin={{
            top: 5,
            right: 30,
            left: 20,
            bottom: 5,
          }}
        >
          <XAxis dataKey="Год" />
          <YAxis />
          <Tooltip contentStyle={{background:"#151c2c", border:"none"}}/>
          <Legend />
          <Line type="monotone" dataKey="Валовая" stroke="#8884d8" strokeDasharray="5 5" />
          <Line type="monotone" dataKey="От продаж" stroke="#82ca9d" strokeDasharray="3 4 5 2" />
          <Line type="monotone" dataKey="Чистая" stroke="#ef4dbf" strokeDasharray="5 8 5" />

        </LineChart>
      </ResponsiveContainer>
    </div>
  )
}

export default Chart