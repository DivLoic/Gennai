
private val x = new AnyRef {}
var uidCount = 0L

class HelloThread extends Thread{
  override def run(): Unit = {
    println("Hello,")
    println("world!")
  }
}

val t = new HelloThread()
val s = new HelloThread()

t.start()
s.start()
t.join()
s.join()

def getId: Long = {
  uidCount = uidCount + 1
  uidCount
}

def getUniqueId: Long = AnyRef.synchronized {
  uidCount = uidCount + 1
  uidCount
}

def startNewThread() = {
  val t = new Thread {
    override def run() {
      val uids = for(i <- 0 until 10) yield getUniqueId
      println(uids)
    }
  }
  t.start()
}


startNewThread()
startNewThread()

uidCount
