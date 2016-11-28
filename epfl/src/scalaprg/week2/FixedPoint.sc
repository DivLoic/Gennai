import math.abs

object obj{

  val tolerence = 0.001

  /**
   * compare x and y
   * @param x (Double)
   * @param y (Double)
   * @return true if x < y && false otherwise
   */
  def isCloseEnough(x: Double, y: Double): Boolean =
    abs((x - y) / x) * x < tolerence

  /**
   * find the "point invariant" of  a function f
   * @param f function we need to find a fp
   * @param firstGuess (Double) possible fixed point
   * @return
   */
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {

    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isCloseEnough(next, guess)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x/2)(1)

  // -- this doesn't converge
  //def sqrt(x: Double) =
    //fixedPoint(y => x/y)(1.0)
  // ---> Average Damping
  def sqr(x: Double) =
    fixedPoint(y => (y + x / y ) / 2 )(1)

  sqr(2)

  def averageDamp(f: Double => Double)(x: Double) =
    (x + f(x)) / 2

  def newSqr(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1)

  newSqr(2)

}