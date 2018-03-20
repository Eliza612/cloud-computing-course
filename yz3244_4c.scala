def inventory(msg: String): Map[String, Double] = {
	val s = msg.split(",")
	val m = s map {i => i.split(" ")}
	val n = m map {case Array(f1,f2) => (f1,f2.toDouble)}
	val g = n.sortWith(_._1 < _._1)
	val gp = g groupBy(_._1)
	val inventory = gp mapValues (x => x.map(_._2).sum)
	inventory
}

val msg = "widgets 103.24,eggs 345.22,milk 231.25,widgets 123.11,milk 14.2"
// To use the function, just type   inventory(msg)