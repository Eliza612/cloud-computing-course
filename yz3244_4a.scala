//4a
sealed trait LinkedList[+A]
	case object Nil extends LinkedList[Nothing]
	case class Cons[+A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object LinkedList {
	def sum(ints: LinkedList[Int]): Int = ints match {
		case Nil => 0
		case Cons(x,xs) => x + sum(xs)
}
	def product(ds: LinkedList[Double]): Double = ds match {
		case Nil => 0
		case Cons(0.0,_) => 0.0
		case Cons(x,xs) => x* product(xs)
	}
	def apply[A](as: A*): LinkedList[A] =
		if (as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*))
		
	//4a.1
	def drop[A](ll: LinkedList[A], n:Int): LinkedList[A]= {
		if (n <= 0) ll
		else
			ll match{
				case Nil => Nil
				case Cons(x, xs) => drop(xs, n-1)
			}
	}

	//4a.2
	def dropWhile[A](ll: LinkedList[A], f: A => Boolean): LinkedList[A] = ll match {
		case Cons(x, xs) if (f(x))=> dropWhile(xs, f)
		case _ => ll
	}

}