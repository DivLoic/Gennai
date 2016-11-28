/**
 * Created by LoicMDIVAD on 13/08/15.
 */

package week3

trait List[T]{
  def isEmpty: Boolean
  def Head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
  def isEmpty: false
}

class Nil[T] extends List[T]{
  def isEmpty: Boolean = true
  def Head: T = throw new NoSuchElementException("Nil.head")
  def tail: List[T] = throw new NoSuchElementException("Nil.tail")
}