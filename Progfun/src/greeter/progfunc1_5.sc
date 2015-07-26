package greeter
import math.abs

object progfunc1_5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def improve(guess: Double, x: Double) = (guess + x / guess) / 2
                                                  //> improve: (guess: Double, x: Double)Double
  def isGoodEnough(guess: Double, x: Double) = abs(guess*guess - x) / x < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
  def SqrtIter(guess: Double, x: Double): Double = if (isGoodEnough(guess, x)) guess else SqrtIter(improve(guess, x), x)
                                                  //> SqrtIter: (guess: Double, x: Double)Double
  SqrtIter(1, 0.0001)                             //> res0: Double = 0.010000000025490743
}