package greeter

object Sheet {
	def product(a: Int, b: Int): Int = {
		if (a > b) 1 else a * product(a + 1, b)
	}                                         //> product: (a: Int, b: Int)Int
	product(1, 5)                             //> res0: Int = 120
	def factorial(a: Int): Int = product(1, a)//> factorial: (a: Int)Int
	factorial(5)                              //> res1: Int = 120
	
	def MapReduce(f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
	  if (a > b) zero else g(f(a), MapReduce(f, g, zero)(a+1, b))
	}                                         //> MapReduce: (f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int)I
                                                  //| nt
	def id(x: Int) = x                        //> id: (x: Int)Int
	def sum(a: Int, b: Int) = a + b           //> sum: (a: Int, b: Int)Int
	
  MapReduce(id, sum, 0)(1, 10)                    //> res2: Int = 55
  def prod(f: Int => Int)(a: Int, b: Int): Int = MapReduce(f, (a: Int, b: Int) => a * b, 1)(a, b)
                                                  //> prod: (f: Int => Int)(a: Int, b: Int)Int
  prod(x=>x+x)(1,5)                               //> res3: Int = 3840
}