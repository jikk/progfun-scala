import math.abs

object progfun2_4 {
  val tolerance = 0.0001
	def isCloseEnough(x: Double, y: Double) =
		abs((x-y) / x) < tolerance
	
	def fixedPoint(f: Double => Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
		  // println("guess = " + guess)
			val next = f(guess)
			if (isCloseEnough(guess, next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	}

	fixedPoint(x => 1 + x/2)(3)
	def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
	
	def sqrt(x: Double) = fixedPoint(y=> y+ x / y)(1)
	averageDamp(y => y + x/y)
}