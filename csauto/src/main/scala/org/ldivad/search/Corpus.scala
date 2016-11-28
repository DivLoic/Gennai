package org.ldivad.search

/**
  * Created by loicmdivad on 26/09/2016.
  * @tparam T type of the inner documents
  */
trait Corpus[T]{

  /**
    * @return the length of the corpus
    */
  def length(): Int

  /**
    * @return return a sequence of inner documents
    */
  def extract(): Seq[T]

  /**
    * execute a given query
    * @param query exemple of document
    * @param limit number of matchs to return
    * @return The n documents in the corpus that match the query
    */
  def execute(query: T, limit: Int): Corpus[T]

}
