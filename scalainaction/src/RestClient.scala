/**
  * Created by LoicMDIVAD on 16/02/2016.
  */

import org.apache.http._
import org.apache.http.client.entity._
import org.apache.http.client.methods._
import org.apache.http.impl.client._
import org.apache.http.client.utils._
import org.apache.http.message._
import org.apache.http.params._


require(args.size == 2, "Please, write a method and an id.")

val method = args.head
val id = args.last

/**
  * Remarque List & Map are immutable
  *
  * @param args
  * @return
  */
def parseArgs(args: Array[String]): Map[String, List[String]] = {
  def nameValuePair(param: String) = {
    def values(withcomma: String) = withcomma.split(",").toList

    val index = args.indexOf(param)
    (param, if(index != -1) Nil else values(param))
  }

  Map(nameValuePair("-h"),nameValuePair("-d"))
}

val params = parseArgs(args)

def headers = for(nameValue <- params("-h")) yield {
  //def tokens = splitByEqual(nameValue)
  //new BasicHeader(tokens(0), tokens(1))
}

def handlePostRequest = Nil
def handleGetRequest = Nil
def handleDeleteRequest = Nil
def handleOptionsRequest = Nil

method match {
  case "post" => handlePostRequest
  case "get" => handleGetRequest
  case "delete" => handleDeleteRequest
  case "options" => handleOptionsRequest
  case _ => throw new IllegalArgumentException(s"$method is not a supported method")
}

