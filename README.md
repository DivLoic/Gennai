# Gennai
###### Scala trick &amp; tips modules    

This project is a place for me to put a few projects & code examples in Scala.

#### Tools:
- SBT
- Scala 
- ScalaTest
- IntelliJ
 
#### A Few projects:
- [X] codingame
- [X] Streamer
- [ ] Rico


#### Multi-modules configuration

- define a `commonSetting`
- define each module like `lazy val module = project`
- Add all the settings 

```{scala}
lazy val commonSettings = Seq(
  organization := "org.ldivad",
  version := "1.0",
  scalaVersion := "2.11.8"
)

lazy val moduleA = project.
  settings(commonSettings: _*)

lazy val moduleB = project.
  settings(commonSettings: _*).
  settings(libraryDependencies ++= Seq(
      // list of deps
    )
  )
```

#### About the project name
>...
