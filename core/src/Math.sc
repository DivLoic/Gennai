import scala.math._

val t = 0.1
val foo = for(i <- 0 until 10 by 2) yield {
  pow(t, i)*exp(-t)
}