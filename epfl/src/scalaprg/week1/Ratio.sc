object rational{

  /**
   * Firts look at POO in coursera classes
   * scala lecture 2.5
   * @param x
   * @param y
   */
  class Rational(x: Int, y: Int){
    require(y != 0, "Deno need to be a nonzero.")

    private def gcd(a: Int, b: Int) :Int = if(b == 0) a else gcd(b, a % b)
    val nume = x
    val deno = y

    def this(x: Int) = this(x, 1)

    def add(r: Rational): Rational =
      new Rational(
        nume * r.deno + r.nume * deno,
        deno * r.deno
      )

    /** same with operator **/
    def + (r: Rational): Rational = {
      new Rational(
        nume * r.deno + r.nume * deno,
        deno * r.deno
      )
    }

    def neg: Rational =
      new Rational(-1 * nume, deno)

    def sub(r: Rational): Rational =
      add(r.neg)

    /** same with operator **/
    def - (r: Rational): Rational =
      this + r.neg

    override def toString(): String ={
      val g = gcd(nume, deno)
      nume / g  + "/" + deno / g
    }

  }

  val r = new Rational(12, 18)
  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)
  r.toString()
  x.sub(y).sub(z)

  x.sub(y).toString()
    .equals((x - y).toString())

  val bad = new Rational(1, 0)

}
