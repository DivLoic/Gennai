/**
 * Created by LoicMDIVAD on 18/08/15.
 * Coursera lecture 4. Peanos Numbers.
 */

abstract class Nat{
  /**
   *
   */
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(n)
  def + (that: Nat): Nat
  def - (that: Nat): Nat

}

object Zero extends Nat{
  /**
   *
   */
  def isZero: Boolean = true

  def predecessor: Nat = throw new Error("0.predecessor")

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if (that.isZero) this else throw new Error("Negative number")

}

class Succ(n: Nat) extends Nat{
  /**
   *
   */
  def isZero: Boolean = false

  def predecessor: Nat = n

  def +(that: Nat): Nat = new Succ(n + that)

  def -(that: Nat): Nat = if(that.isZero) this else new Succ(n - that.predecessor)

}
