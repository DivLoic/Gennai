import math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Temp extends App {

  val n = 6 // readInt the number of temperatures to analyse
  val temps = "42 -5 12 21 5 24" // readLine the n temperatures expressed as integers ranging from -273 to 5526

  Console.err.println(n)
  Console.err.println(temps)

  // Write an action using println
  // To debug: Console.err.println("Debug messages...")

  val values = temps split " "

  if(n == 0)
    println(0)
  else if(n == 1)
    println(values(0))
  else {
    val mins = values
      .map(_.trim)
      .map(t => if(t equals "") "0" else t)
      .map(_.toInt)
      .sortBy(abs)
      .take(2)

    (mins(0), mins(1)) match {
      case (a, b) if a == -1 * b => println(abs(a))
      case (a, b) => println(a)
    }
  }

}
