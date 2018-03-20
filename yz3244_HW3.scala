def isThreeSorted[A] (array: Array[A], p: (A, A, A) => Boolean): Boolean = {
	@annotation.tailrec
	def loop(n: Int): Boolean = 
		if (array.length < 3) false
		else if (n >= array.length) true
		else if (!p(array(n-2), array(n-1), array(n))) false
		else loop(n+1)
	loop(2)
}

/*
def fib(A: Int, B:Int, C:Int): Boolean = {
	if (C == A + B) true
	else false
}

//isThreeSorted(Array(1,1,2),(a:Int, b:Int, c:Int) => fib(a,b,c))
*/

isThreeSorted(Array(1, 1), (a:Int,b:Int,c:Int) => a + b == c)
isThreeSorted(Array(1, 1, 2, 3, 5, 9, 13), (a: Int,b: Int,c: Int) => a + b == c)
isThreeSorted(Array(1, 1, 2, 3, 5, 8, 13), (a: Int,b: Int,c: Int) => a + b == c)