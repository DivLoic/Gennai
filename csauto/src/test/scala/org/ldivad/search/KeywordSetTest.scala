package org.ldivad.search

import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by loicmdivad on 26/09/2016.
  */
class KeywordSetTest extends FunSuite with BeforeAndAfter{

  val conf = ConfigFactory.load("test")

  test("Should pass any way"){
    assert(1 !== 2)
  }

  test("Should load a KeywordSet."){

    val k0 = new KeywordSet() // empty
    val k1 = new KeywordSet(wiki) // load a sequence
    val k2 = new KeywordSet(conf.getString("dir") + "keywords.txt") // load a file

    assertResult(0)(k0.length())
    assertResult(10)(k1.length())
    assertResult(25)(k2.length())

  }

  test("Should match the query."){
    val q = "obj"

    val k = new KeywordSet(wiki)

    val result = k.execute(q)

    val lines = result.extract()

    assertResult(4)(result.length())  // return 4 suggestions
    assert(lines.forall(_.toLowerCase().startsWith(q))) // all suggestions match q
  }

  test("Should return a sorted result."){
    val q = "prog"

    val k = new KeywordSet(conf.getString("dir") + "keywords.txt")

    val result = k.execute(q)

    val lines = result.extract()

    assert(result.length() <= 4) // return 4 suggestions
    assert(lines.forall(_.toLowerCase().startsWith(q))) // all suggestions match q
    assert((lines, lines.tail).zipped.forall(_ < _)) // all suggestions are sorted
  }

  // this stand for an other list of keywords
  val wiki = Seq(
    "Object Lisp",
    "ObjectLOGO",
    "Objective-C",
    "Objective-J",
    "Obliq",
    "Obol",
    "occam",
    "occam-p",
    "OmniMark",
    "Onyx"
  )
}
