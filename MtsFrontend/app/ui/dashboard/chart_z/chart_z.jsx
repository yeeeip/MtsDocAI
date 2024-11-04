"use client"

import styles from './chart_z.module.css'
import { LineChart, Line, XAxis, YAxis, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const data = [
  {
    "Год": 2009,
    "Валовая": 111.213691,
    "От продаж": 66.657912,
    "Чистая": 33.480015,
    "Коммерческие": 25.121442,
    "Управленческие": 19.434337
  },
  {
    "Год": 2010,
    "Валовая": 118.167565,
    "От продаж": 65.945486,
    "Чистая": 27.428577,
    "Коммерческие": 33.089665,
    "Управленческие": 19.132414
  },
  {
    "Год": 2011,
    "Валовая": 122.456796,
    "От продаж": 64.595493,
    "Чистая": 54.129288,
    "Коммерческие": 36.569705,
    "Управленческие": 21.300598
  },
  {
    "Год": 2012,
    "Валовая": 127.934453,
    "От продаж": 70.190971,
    "Чистая": 42.949463,
    "Коммерческие": 33.241387,
    "Управленческие": 24.502095
  },
  {
    "Год": 2013,
    "Валовая": 145.256787,
    "От продаж": 73.478290,
    "Чистая": 55.999090,
    "Коммерческие": 44.177545,
    "Управленческие": 27.609952
  },
  {
    "Год": 2014,
    "Валовая": 150.368668,
    "От продаж": 74.377911,
    "Чистая": 28.372745,
    "Коммерческие": 47.474858,
    "Управленческие": 28.515899
  },
  {
    "Год": 2015,
    "Валовая": 148.330805,
    "От продаж": 72.827733,
    "Чистая": 6.590503,
    "Коммерческие": 46.845936,
    "Управленческие": 28.657136
  },
  {
    "Год": 2016,
    "Валовая": 148.855198,
    "От продаж": 70.778305,
    "Чистая": 50.658752,
    "Коммерческие": 48.182276,
    "Управленческие": 29.894617
  }
];

const Chart_z = () => {
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>Затраты (млрд.руб)</h2>
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
          <Line type="monotone" dataKey="Коммерческие" stroke="#8884d8" strokeDasharray="5 5" />
          <Line type="monotone" dataKey="Управленческие" stroke="#82ca9d" strokeDasharray="3 4 5 2" />

        </LineChart>
      </ResponsiveContainer>
    </div>
  )
}

export default Chart_z