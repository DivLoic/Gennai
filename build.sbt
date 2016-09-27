name := "Gennai"

version := "1.0"

scalaVersion := "2.11.8"

lazy val commonSettings = Seq(
  organization := "org.ldivad",
  version := "1.0",
  scalaVersion := "2.11.8"
)

lazy val algoSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.1",

    "org.scalactic" % "scalactic_2.11" % "3.0.0",
    "org.scalatest" % "scalatest_2.11" % "3.0.0",

    "ch.qos.logback" %  "logback-classic" % "1.1.7",
    "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.4.0"
  )
)

lazy val codingame = project.
  settings(commonSettings: _*)

lazy val mapr = project.
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.httpcomponents" % "httpclient" % "4.1.1",
      "org.apache.spark" % "spark-core_2.10" % "1.6.0",
      "org.apache.spark" % "spark-streaming_2.10" % "1.6.0",
      "org.apache.hadoop" % "hadoop-core" % "1.2.1",
      "org.apache.hbase" % "hbase" % "0.92.1"
    )
  )

lazy val mowitnow = project.
  settings(commonSettings: _*).
  settings(algoSettings: _*).
  settings(
    logLevel in run := Level.Error,
    parallelExecution in Test := false,
    mainClass in (Compile, run) := Some("org.ldivad.Main")
  )

lazy val csauto = project.
  settings(commonSettings: _*).
  settings(algoSettings: _*).
  settings(
    parallelExecution in Test := false,
    mainClass in (Compile, run) := Some("org.ldivad.search.Main")
  )
