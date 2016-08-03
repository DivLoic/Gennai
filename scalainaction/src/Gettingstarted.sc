/**
*
*/

// scala shell command= :help, :cp, :load/:l, :replay/:r :quit/:q :type

// scala.Predef._
// import a lot of things like println,  ...

/**
* Scala the basics: Types
*/
//Byte 8-bit signed 2’s [–128;127]
val tbyte: Byte = 3
//Short Byte 16-bit signed 2’s [–32,768; 32,767]
val tshort: Short
//Int 32-bit signed 2’s [–2,147,483,648; 2,147,483,647]
val tint = 1
//Long 64-bit signed 2’s [-9,223,372,036,854,775,808; 9,223,372,036,854,775,807]
val tlong = 11235L

//Float A single-precision 32-bit IEEE 754 floating point.
val tfloat = -700.5333F
//Double A double-precision 64-bit IEEE 754 floating point.
val tdoubel = 700.5333
//Char [\u0000 - \uffff] 65,535 values
val tchar = 'e'
/**
* Scala the basics: String interpolation
**/

// e.g Int & Short have no default values
//val defaultstr: String = _
val sentence1 = "foo bar "
val sentence2 = "Hello, "
val multiline =
  """
    |The quick
    |brown fox
    |jumps over
  """.stripMargin
//stripMargin delete pipe & \t
println(s"$sentence1 ... and so on")
println(s"$sentence2 world")
println("${tfloat} + 400 = ${tfloat + 400}")
println(f"$tfloat%.2f + 400 = ${tfloat + 400}%.2f")

val document = <book>
  <title>Scala in Action</title>
  <author>Nilanjan Raychaudhuri</author>
</book>
val myclass = document.getClass()
/**
* Scala the basics: defining function
*/
def fun1 = (a: Int, b: Int) => a*b // literals
def fun2(c: Double) :String = { s"n° $c.2f"} // last exp is the return
def max(a: Int, b: Int) = if(a > b) a else b
def toList[A](value:A) = List(value) //type parameter

// no break or continue
def breakException = new RuntimeException("break exception")
def break = throw breakException
def breakable(op: => Unit) = {
  try { op
  } catch { case _: Throwable => }
}

breakable {
  val env = System.getenv("SCALA_HOME")
  if(env == null) break
  println("found scala home lets do the real work")
}
/**
* Scala the basics: Data structure
*/
// array are mutable
val array = new Array[String](3)
array(0) = "This"; array(1) = "is"; array(2) = "mutable"
array.foreach(println)
// list are immutable
val myList = List("This", "is", "immutable")

val listone = List(1, 2)
val listtwo =  3 :: listone
val lastlist= listtwo :+ 7

// list est une abst, étendu par deux types Nil & ::
//scala.collection.immutable.:: ($colon.$colon)

/**
* Scala the basics: control stucture
*/

val files = new java.io.File(".").listFiles()
//imperative form loop
for {
  file <- files;
  fileName = file.getName
  if fileName.endsWith("lib")
} println(file)

val aList = List("foo", "bar")
val bList = List("X", "Y", "Z")
//functional form loop
val funcloop = for {a <- aList; b <- bList} yield s"$a : $b"
for{fl <- funcloop} println(fl)


/**
* Scala the basics: pattern matching
* see external script -> Patternexamples
*/