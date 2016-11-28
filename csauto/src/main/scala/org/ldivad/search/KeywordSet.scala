package org.ldivad.search

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Created by loicmdivad on 26/09/2016.
  * @param items stand for the inner documents of the corpus
  */
class KeywordSet(items: Seq[String] = Seq()) extends Corpus[String] {

  /**
    * Read a full path to build a KeywordSet <br/>
    * The file format is a list of names delimited by \n
    * @param path /path/to/the/file.txt
    */
  def this(path: String) {
    this(Try(Source.fromFile(path).getLines()) match {
      case Failure(error) => Seq[String]()
      case Success(lines) => lines.toSeq
    })
  }

  /**
    * Filter - Sort - Limit
    * @param query exemple of document
    * @param limit number of matchs to return
    * @return The n documents in the corpus that match the query
    */
  override def execute(query: String, limit: Int = 4): Corpus[String] = new KeywordSet(
    items
      .filter {
        _.toLowerCase startsWith query.toLowerCase
      }
      .sortWith(_ < _).take(limit)
  )

  override def length(): Int = items.length

  override def extract(): Seq[String] = items

}
