import scala.annotation.tailrec/** * lecture 2.2 Coursera */object exe {  /**   *   * @param f   * @param a   * @param b   * @return   */  def product(f: Int => Int)(a: Int, b: Int): Int = {    if (a <= b) f(a) * product(f)(a + 1, b)    else 1  }  product((x: Int) => x * x)(2, 4)  def fact(n: Int) = product(x => x)(1, n)  fact(3)  // -- Generic functions -- //  def ops(mapper: Int => Int, reducer: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {    if(a > b) zero    else reducer(mapper(a),  ops(mapper, reducer, zero)(a + 1, b))  }  def sumOfSqrt(y1: Int, y2: Int) = ops(x => x * x, (a ,b) => a + b, 0)(y1,y2)  sumOfSqrt(2,4)  4 + 9 + 16}