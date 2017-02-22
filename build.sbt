name := "Gennai"

version := "1.0"

scalaVersion := "2.11.8"

lazy val commonSettings = Seq(
  organization := "org.ldivad",
  version := "1.0",
  scalaVersion := "2.11.8"
)

lazy val craftSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.1",
    "org.scalactic" % "scalactic_2.11" % "3.0.0",
    "org.scalatest" % "scalatest_2.11" % "3.0.0",
    "org.scalacheck" %% "scalacheck" % "1.13.4",
    "ch.qos.logback" %  "logback-classic" % "1.1.7",
    "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.4.0"
  )
)

lazy val codingame = project.
  settings(commonSettings: _*)

lazy val actorgen = project.
  settings(commonSettings: _*).
  settings(craftSettings: _*)

lazy val rico = project.
  settings(commonSettings: _*).
  settings(
    name := "Rico",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "1.4.1",
      "org.apache.spark" %% "spark-sql" % "1.4.1",
      "org.apache.spark" %% "spark-mllib" % "1.4.1"
    )
  )

lazy val mowitnow = project.
  settings(commonSettings: _*).
  settings(craftSettings: _*).
  settings(
    logLevel in run := Level.Error,
    parallelExecution in Test := false,
    mainClass in (Compile, run) := Some("org.ldivad.Main")
  )

lazy val csauto = project.
  settings(commonSettings: _*).
  settings(craftSettings: _*).
  settings(
    parallelExecution in Test := false,
    mainClass in (Compile, run) := Some("org.ldivad.search.Main")
  )


