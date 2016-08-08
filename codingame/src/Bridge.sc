import math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {
  val road = readInt // the length of the road before the gap.
  val gap = readInt // the length of the gap.
  val platform = readInt // the length of the landing platform.

  var cmd = new String()
  // game loop
  while(true) {
    val speed = readInt // the motorbike's speed.
    val coordx = readInt // the position on the road of the motorbike.

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    // TODO: Find a better syntax
    if(speed <= gap) cmd = "SPEED" else cmd = "WAIT"
    if(coordx + speed >= road + gap) cmd = "JUMP"
    if(road - coordx < 0 || speed > gap+1) cmd  = "SLOW"

    // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
    println(s"$cmd")
  }
}