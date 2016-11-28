object Recursion{

  /**
   * Exercise 1: Pascal’s Triangle
   * Take a row and a column and return the coefficient
   * of Pascal’s Triangle corresponding. return 0 if
   * axis are outside of the triangle
   * @param r row (int)
   * @param c column (int)
   * @return coeff (int)
   */
  def pascal(r: Int, c: Int): Int ={
    if(c > r) 0
    else if (c == 0 || c == r) 1
    else pascal(r - 1, c - 1) + pascal(r - 1, c)
  }

  pascal(4, 1)
  pascal(3, 2)
  pascal(8, 5)

  /**
   *
   * Exercise 2: Parentheses Balancing
   * @param chars
   * @return
   */
  def balance(chars: List[Char]): Boolean = {

    /**
     * Match the next closing parenthese,
     * skip n if  n opening parentheses are found
     * @param n number to skip (Int)
     * @param q tail to analyse (List[Char])
     * @return tail after the closing bracket (List[Char])
     */
    def bind(n: Int, q: List[Char]): List[Char] = {
      if(q.isEmpty) List[Char](')')
      else if(q.head.equals('(')) bind(n + 1, q.tail)
      else if(q.head.equals(')') && n != 0) bind(n - 1, q.tail)
      else if(q.head.equals(')') && n == 0) q.tail
      else bind(n, q.tail)
    }

    if(chars.isEmpty) true
    else if(chars.head.equals(')')) false
    else if(chars.head.equals('(')) balance(bind(0, chars.tail))
    else balance(chars.tail)
  }


  balance("(if (zero? x) max (/ 1 x))".toList)
  balance("(that it’s not (yet) done). (But he wasn’t listening)".toList)
  balance(":-)".toList)
  balance("())(".toList)

  /**
   * Exercise 3: Counting Change
   * @param money
   * @param coins
   * @return
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    return 0
  }

  // ------------------------------------------------------------
  // -- WEEK TWO
  // ------------------------------------------------------------

}