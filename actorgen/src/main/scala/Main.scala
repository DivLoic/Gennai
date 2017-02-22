import org.scalacheck.Gen

/**
  * Created by loicmdivad on 21/02/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {

    val generator = Gen.frequency((8, Tag.Data), (2, Tag.Mobile))

    for(i <- 0 to 10){
      println(
        generator.sample.get
      )
    }
  }
}


object Tag extends Enumeration {
  type Tag = Value
  val Data, Mobile, Back, Front = Value
}