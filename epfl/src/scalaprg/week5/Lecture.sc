object Lecture{

  /**
   * lecture 5.2 pair and tuple
   */
  val p = ("answer", 42)
  val (var1, var2) = p
  println(var2)

  /**
   * merge sort with Implicite types and
   * appropriate coparaison function
   * @param xs
   * @return
   */
  def mergeSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0 )xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match{
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xss, y :: yss) =>
          if (ord.lt(x, y)) x :: merge(xss, ys)
          else y :: merge(xs, yss)
      }

      val (left, right) = xs splitAt n
      merge(mergeSort(left), mergeSort(right))
    }
  }

  val l1: List[Int] = List(3,7,1,5,8,9,18)
  val l2: List[String] = List("Swift","Scala","Java","Clojure","Python")

  val sl1 = mergeSort(l1)
  val sl2 = mergeSort(l2)

  l1

  // First look at Higher-Order List Functions
  val l: List[Int] = List(2,9,4,8,3,7)
  l map (x => x * x)
  l filter (x => x <= 4)
  l span (x => x == 8)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
      val (left, right) = xs span (y => y == x)
      left :: pack(right)
  }

  pack(List("a", "a", "a", "b", "c", "c", "a"))

  def encode[T](l: List[T]): List[(T, Int)] = {
    val sum = pack(l)
    sum map (e => (e.head, e.length))
  }

  encode(List("a", "a", "a", "b", "c", "c", "a"))

}