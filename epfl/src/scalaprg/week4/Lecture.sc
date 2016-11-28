import scala.annotation.tailrec

object Lecture{
  /**
   * lecture 4.7 List the insert/sort
   * @param xs
   * @return
   */
  def insertSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, insertSort(ys))
  }
  def insert(y: Int, ys: List[Int]): List[Int] = ys match {
    case List() => List(y)
    case x :: xs => if(y <= x) y :: ys else x :: insert(y, xs)
  }

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0 )xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match{
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xss, y :: yss) =>
          if (x < y) x :: merge(xss, ys)
          else y :: merge(xs, yss)
      }

      val (left, right) = xs splitAt n
      merge(mergeSort(left), mergeSort(right))
    }
  }

  val one: List[Int] = List(9, 3, 8, 7, 0, 4)
  val sorted = insertSort(one)
  val sorted2 = mergeSort(one)
  val two: List[Int] = one updated(4, 12)
  one drop 2
  one take 2

  /**
   *
   * @param n
   * @param l
   * @tparam T
   * @return
   */
  def removeAt[T](n: Int, l: List[T]): List[T] = l match {
    case List() => throw new Error("Remove on Empty list")
    case y :: ys => if (n >= l.length){
      throw new Error("No such index")
    } else {
      (l take n) ++ (l drop n+1)
    }
  }
  removeAt(1, one)
}