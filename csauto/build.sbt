name := "Csauto"

version := "1.0"

scalaVersion := "2.11.8"

parallelExecution in Test := false

mainClass in (Compile, run) := Some("org.ldivad.search.Main")

libraryDependencies ++= Seq(

  // config deps
  "com.typesafe" % "config" % "1.2.1",

  // unit test deps
  "org.scalactic" % "scalactic_2.11" % "3.0.0",
  "org.scalatest" % "scalatest_2.11" % "3.0.0",

  // logging deps
  "ch.qos.logback" %  "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.4.0"

)