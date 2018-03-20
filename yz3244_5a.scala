//Assignment 5a
/*
You are given a dataset in a scala Array. Each element in the array
corresponds to one row of the dataset and is in the form of a comma
separated string. You know the number of columns but not the number of
rows in the data set. Write the scala code that computes the mean and
variance of each column.
Your code should take into account the possibility that not every data
item is convertible into a Double and should remove each nonconvertible
value from the calculations. You should also account for
the possibility that the mean is indeterminate (i.e., an array has 0
elements).
For this assignment, you can use scala’s iteration capabilities. See
http://tutorials.jenkov.com/scala/for.html for help
NOTES:
1. To initialize a multidimensional array of m rows and n cols use the
ofDim function
var x = Array.ofDim[A](m,n)
2. If x is an Array, x.transpose, transposes the array
3. Write a function that calculates the mean of an array and another
function that calculates the variance. If the array is empty, these
functions should return None
Example:
Array("1.2,3.1,2.4",",1.4,2.1","8.1,2.6,bc","7.1,3.2,9.4")
should return:
means: Array(5.466666666666666, 2.575, 4.633333333333334)
variances: Array(9.268888888888888, 0.5118750000000001,
11.375555555555556)
*/

/*写一个function
input是一个array，其实是dataframe 每个元素是一个string，逗号隔开
计算每一列的mean variance
输出

Array("1.2,3.1,2.4",",1.4,2.1","8.1,2.6,bc","7.1,3.2,9.4")
1.2  3.1  2.4
     1.4  2.1
8.1  2.6  bc
7.1. 3.2  9.4
建一个空的array往里面填数字
*/

/*

READ ME:

Procedure to Run This File

:load yz3244_5a.scala
var y = Array("1.2,3.1,2.4",",1.4,2.1","8.1,2.6,bc","7.1,3.2,9.4")
calculate(y, "mean")
calculate(y, "var")

*/

//Here4 Var
def calculate(arr: Array[String], str: String): Array[Double] = {
	
	def trans(arr: Array[String]): Array[Array[String]] = {
		var arr1 = arr.map(x => x.split(","))
		var arr2 = arr1.transpose
		arr2
   	}

	def parseDouble(s: String): Option[Double] =  
		try { 
			Some(s.toDouble) 
		} catch { 
			case e: Exception => None 
	}

 	def Vari(arr: Array[Array[Double]], col: Int): Array[Double] = {	
 		var avg = Avg(arr)
 		var v = new Array[Double](col) //Attention!! not dim!!

 		for (i <- 0 until arr.length){	
 			v(i) = arr(i).map(a => math.pow(a - avg(i), 2)).sum/arr(i).size
 		}
 		v		
 	}

 	def Avg(arr: Array[Array[Double]]): Array[Double] = {
 		var avg = arr.map(l => l.sum/l.length)
 		avg
 	}


 	if (arr.length == 0) { 
		Array(0.0)
	}
	else{
		var m = arr.length   // num of original lines
 		//if m == 0 None
 		var arr1 = trans(arr)
 		var n = arr1.length  //num of origin cols
 		var x = Array.ofDim[Double](n,m)

 		for (i <- 0 until n){
 			x(i) = arr1(i).map(x => parseDouble(x)).collect{_ match {case Some(m) => m}}
 			}

 		//if (str == "mean") Avg(x). ??? why no?
		//if (str == "var")  Vari(x,n)	
		str match{
			case "mean" => Avg(x)
			case "var"	=> Vari(x,n)
 		}
	
	 } 
}
 









