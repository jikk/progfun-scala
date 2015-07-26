import math.abs

object fixedpoint {
	val tolerance = 0.00001                   //> tolerance  : Double = 1.0E-5
	def isCloseEnough(x: Double, y: Double) = abs((x-y) / x) < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean
	def fixedPoint(f: Double => Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
			val next = f(guess)
			if (isCloseEnough(guess, next)) next
			else iterate(next)
		}
	iterate(firstGuess)
	}                                         //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
}