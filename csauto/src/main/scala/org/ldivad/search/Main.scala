package org.ldivad.search

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.io.StdIn

/**
  * Created by loicmdivad on 26/09/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val conf = ConfigFactory.load("dev")
    val logger = Logger(LoggerFactory.getLogger(conf.getString("logger")))

    logger info "Define the corpus to use."

    val corpus = new KeywordSet(
      conf.getString("dir") +
      conf.getString("ref")
    )

    while(true){

      logger info "Now waiting for input ..."

      val query = StdIn.readLine() // you need to type

      logger debug s"Get the following input $query"

      val result = corpus execute query

      result.extract().foreach(r => println(s" ----- $r"))

    }

    logger info "End of the program."
  }
}
