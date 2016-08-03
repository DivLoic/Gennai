/**
*
**/

val arg = Array("5")
ordinal(arg(0).toInt)
def ordinal(number:Int) = number match {
  case 1 => println("1st")
  case 2 => println("2nd")
  case 3 => println("3rd")
  case 4 => println("4th")
  case 5 => println("5th")
  case 6 => println("6th")
  case 7 => println("7th")
  case 8 => println("8th")
  case 9 => println("9th")
  case 10 => println("10th")
  case _ => println("Cannot do beyond 10")
}

def printType(obj: AnyRef) = obj match {
  case s: String => println("This is string")
  case l: List[_] => println("This is List")
  case a: Array[_] => println("This is an array")
  case d: java.util.Date => println("This is a date")
}

printType("Helo")
printType(List(1,2,3))
printType(new Array[String](2))


/**
*
**/

// in scala catch blocl <=> match block

def underThirty(num: Int) = num match{
  case ten if num <= 10 => println("under 10")
  case twenty if num <= 20 => println("under 20")
  case thirty if num <= 30 => println("under 30")
  case thirty if num > 30 =>
    throw new IllegalArgumentException("num is too big")
}

underThirty(20)
underThirty(25)
underThirty(30)

try {
  underThirty(35)
} catch {
  case e: IllegalAccessException => e.getMessage()
  case e: IndexOutOfBoundsException => e.getCause()
  case e: IllegalAccessException => println("don't be rude")
}

