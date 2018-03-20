/*
Problem 1: Write a tail recursive scala function that returns the nth Fibonacci number. 

Problem 2: Write a scala program that contains a function that returns the square root of a number (positive square root only). Add a function to format the output. 
You'll need to find the scala function for square roots and how to format and declare decimal numbers. 
'''

  


// Problem 1 
object fib{
	def Myfib(n: Int): Int = {
		def tail_fib(n: Int, a: Int, b: Int): Int = {
 			if (n == 0) a
 			else tail_fib(n-1, b, a+b) 
		}
	tail_fib(5, 0, 1)
 	}  
}*/ 

def Myfib(n: Int): Int = {
	@annotation.tailrec
	def tail_fib(n: Int, a: Int, b: Int): Int = {
 		if (n == 0) a
 		else tail_fib(n-1, b, a+b) 
	}
	tail_fib(n, 0, 1)
}



//Problem 2
import scala.math
object SquareRoot{
	def root(n: Int): Double = 
		scala.math.sqrt(n)
	
	private def formatSquareRoot(x: Int) = {
		val msg = "The square root of %d is %.2f"
		msg.format(x,root(x))
	}
/*
 	def main(args: Array[String]): Unit = 
		println(formatSquareRoot(5))
*/ 
	def main(a: Int): Unit = 
		println(formatSquareRoot(a))
}



