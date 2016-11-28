/**
 * Created by LoicMDIVAD on 19/08/15.
 */

trait Expr{

  def isNumber: Boolean
  def isSum: Boolean
  def numValues: Int
  def leftOp: Expr
  def rightOp: Expr

  def eval: Int
}

class Number(n: Int) extends Expr{

  def isNumber: Boolean = true
  def numValues: Int = n
  def isSum: Boolean = false
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOP")

  def eval: Int = n
}

class Sum(e1: Expr, e2: Expr) extends Expr{

  def isNumber: Boolean = false
  def isSum: Boolean = true
  def leftOp: Expr = e1
  def rightOp: Expr = e2
  def numValues: Int = throw new Error("Sum.numValues")

  def eval: Int = e1.eval + e2.eval

}

/**
 * First alternative to the decomposition
 * test and cast of types
 * @param e
 * @return
 */
def show(e: Expr): String = {

  if(e.isInstanceOf[Number]) e.asInstanceOf[Number].numValues.toString()
  else if (e.isInstanceOf[Sum]) e.leftOp.toString()  + " + " + e.rightOp.toString()
  else throw new Error("Unknow expression " + e)
}
