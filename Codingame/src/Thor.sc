import math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  * ---
  * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
  **/
object Player extends App {
  // lightx: the X position of the light of power
  // lighty: the Y position of the light of power
  // initialtx: Thor's starting X position
  // initialty: Thor's starting Y position
  val Array(lightx, lighty, initialtx, initialty) = for(i <- readLine split " ") yield i.toInt

  var x = initialtx
  var y = initialty

  // game loop
  while(true) {
    val remainingturns = readInt // The remaining amount of turns Thor can move. Do not remove this line.

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")
    val (cardx, dirx) = lightx - x match {
      case a if a > 0 => ("E",  1)
      case a if a < 0 => ("W", -1)
      case _ => ("", 0)
    }

    val (cardy, diry) = lighty - y match {
      case a if a > 0 => ("S",  1)
      case a if a < 0 => ("N", -1)
      case _ => ("", 0)
    }

    x = x + dirx
    y = y + diry

    // A single line providing the move to be made: N NE E SE S SW W or NW
    println(s"$cardy$cardx")
  }
}