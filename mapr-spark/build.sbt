name := "Gennai"

version := "1.0"

scalaVersion := "2.10.6"


libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.1.1"
libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.0"
libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "1.2.1"
libraryDependencies += "org.apache.hbase" % "hbase" % "0.92.1"