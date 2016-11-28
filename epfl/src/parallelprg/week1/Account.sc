private var uniqueId = 0L

def getUniqueUid(): Long = {
  uniqueId = uniqueId + 1
  uniqueId
}

class Account(var amount: Int = 0) {
  val uid = getUniqueUid()

  def getAmount = amount

  private def lockAndTransfer(target: Account, n: Int): Unit = {
    this.synchronized{
      target.synchronized{
        this.amount -= n
        target.amount += n
      }
    }
  }

  def transfer(target: Account, n: Int): Unit = {
    if(this.uid < target.uid) this.lockAndTransfer(target, n)
    else target.lockAndTransfer(this, -n)
  }

}

val a = new Account(amount=50000)
val b = new Account(amount=80000)

a.transfer(b, 20000)
a.getAmount
b.getAmount

b.transfer(a, 20000)
a.getAmount
b.getAmount

// Pi wiht montecarlo
// lambda = pi / 4
import scala.util.Random
def mcCount(iter: Int): Int = {
  val randomX = new Random
  val randomY = new Random
  var hits = 0
  for(i <- 0 until iter){
    val x = randomX.nextDouble()
    val y = randomY.nextDouble()
    if(x*x + y*y < 1) hits = hits + 1
  }
  hits
}

4.0 * mcCount(500) / 500
