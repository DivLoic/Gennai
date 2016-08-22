import math._
import scala.util._

/**
  * The while loop represents the game.
  * Each iteration represents a turn of the game
  * where you are given inputs (the heights of the mountains)
  * and where you have to print an output (the index of the moutain to fire on)
  * The inputs you are given are automatically updated according to your last actions.
  **/
object Player extends App {

  // game loop
  while(true) {
    val heights = for(i <- 0 until 8) yield {
      val mountainh = readInt // represents the height of one mountain.
      mountainh
    }

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    println(heights indexOf heights.max ) // The index of the mountain to fire on.
  }
}