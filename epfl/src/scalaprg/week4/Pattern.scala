/**
 * Created by LoicMDIVAD on 19/08/15.
 */

trait Expr{

  def isNumber: Boolean
  def isSum: Boolean
  def numValues: Int
  def leftOp: Expr
  def rightOp: Expr

}

case class Number(n: Int) extends Expr{

  def isNumber: Boolean = true
  def numValues: Int = n
  def isSum: Boolean = false
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOP")

}

case class Sum(e1: Expr, e2: Expr) extends Expr{

 def isNumber: Boolean = false
 def numValues: Int = eval(e1) + eval(e2)
 def isSum: Boolean = true
 def leftOp: Expr = e1
  def rightOp: Expr = e2

}

/**
 * Deuxième alternative à la décoposition
 * Pattern Matching
 * @param e
 * @return
 */
def eval(e: Expr): Int = e match {
    case Number(n) => e.numValues
    case Sum(e1, e2) => e.leftOp + e.rightOp
}

/**
 * Différents types de pattterns
 * Number(n) with variable
 * Number(_) with wildcards
 * 1, "abc", true with primitives types
 * N upper case for constantes
 * "a variable appears once in a pattern"
 */