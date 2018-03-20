/*
val text = "able was i ere i saw elba and that was before i was able and could see elba"
val a = text.split("")
val m = a map { i => (i,1) }
val f = m filter (_._1.length() < 5)
val g = f.sortWith(_._1 < _._1)
val gp = g groupBy(_._1)
val result = gp map(w => (w._1,w._2.map(_=>1).reduce(_+_)))

val text = "able was i ere i saw elba and that was before i was able and could see elba"
val a = text.toArray
val m = a map { i => (i,1) }
val f = m filter (_.isLetter)
val g = f.sortWith(_._1 < _._1)
val gp = g groupBy(_._1)
val result = gp map(w => (w._1,w._2.map(_=>1).reduce(_+_)))*/

//Final answer
def Count (msg: String): Map[Char,Int] = {
	val a = msg.toList
	val m = a filter(_.isLetter)
	val f = m map {i => (i.toLower,1)}
	val g = f.sortWith(_._1 < _._1)
	val gp = g groupBy(_._1)
	val count = gp map(w => (w._1, w._2.map(_=>1).reduce(_+_)))
	count
}