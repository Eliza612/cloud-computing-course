/*
In class, we used combineByKey to calculate the average processing
time for each agency in the NYC 311 data set. Modify the various
functions involved so that we get both the average as well as the
variance by each agency. Your code should return the result in the
form of an Array of 
(String, Double, Double).
Use the one pass method for calculating the mean and the variance
(i.e., you should make only one call to combineByKey). Use the
following formula to calculate variance1
*/

val text = sc.textFile("nyc_data.csv")
val data_noh = text.mapPartitionsWithIndex{ (idx,iter) => if (idx == 0) iter.drop(1) else iter }
val data = data_noh.map(l => l.split(","))
val agency_proc = data.map(f => (f(4),f(7).toDouble))
val pairs = sc.parallelize(agency_proc.collect())

val combiner = (x: Double) => (1,x,x)
val merger = (x: (Int, Double,Double),y: Double) => {
	val (c,acc,d) = x
	(c+1, acc+y,d+y*y)
}

val mergeAndCombiner = (x:(Int, Double, Double), y:(Int, Double, Double)) => {
	val (c1, acc1, sq1) = x
	val (c2, acc2, sq2) = y
	(c1+c2,acc1+acc2,sq1+sq2)
 }
	
val proc_times = pairs.combineByKey(combiner,merger,mergeAndCombiner)

val getAvgVarFunction = (x: (String, (Int, Double, Double))) => {
	val (identifier, (count, total, sq)) = x
	(identifier,total/count, (sq- total * total/count)/(count-1))
}

val averages = proc_times.collectAsMap().map(getAvgVarFunction)

