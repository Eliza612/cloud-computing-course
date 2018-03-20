//upload the file
//cloud:
hadoop fs -put /home/yz3244/nyc_data.csv
//spark-shell —-master=local


//Local:
//spark-shell
val text = sc.textFile("nyc_data.csv")
val data_noh = text.mapPartitionsWithIndex{ (idx,iter) => if (idx == 0) iter.drop(1) else iter }
val data = data_noh.map(l => l.split(","))
val rel_lines = data.filter(l => (l.contains("NYPD") && l.contains("MANHATTAN")))
val time = rel_lines.map(l => l(7).toDouble)
val x = sc.parallelize(time.collect)
x.mean
//Result: avg: Double = 0.14236386284109004

//Use Collect

