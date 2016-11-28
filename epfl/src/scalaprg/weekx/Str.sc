object str{

  /**
   * first look at strategy
   * Design pattern
   */

  trait Obs{
    def callback(obj: Any)
  }

  trait Broadcaster{
    val listBr: List[Obs]
    def addObs()
    def shiftObs()
    def trigger() = {
      for(o <- this.listBr) {
        o.callback()
      }
    }
  }

  abstract class Clock extends Broadcaster{

  }

  abstract class digimon extends Obs{

  }




}