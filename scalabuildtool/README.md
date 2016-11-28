# SBT: Scala Build Tool

### this report is taken from the followin blog post:
- [X] [Un premier pas vers SBT](http://blog.xebia.fr/2015/09/23/un-premier-pas-vers-sbt-part-i/)
- [X] [keys & settings ](http://blog.xebia.fr/2015/12/04/sbt-keys-settings/)
- [ ] [...](#)

intro
==========

convention & syntaxe
==========

```{scala}
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0"
```

basic command
==========

command     | description 
------------|-------------------------------
`clean`     | Deletes all generated files
`compile`   | Compiles the main sources.
`run`       | (argument) find all source for compiling & the main class
`...`       | ...
`test`      | Compiles and runs all tests.
`reload`    | Reloads the build definition.
`inspect`   | Show keys definitions.

REPL
==========
The REPL *(Read Eval Print Loop)* let you type 3 kinds of instructions:
- settingKey: *eval once when the projet is loaded*
- taskKey: *eval at each call*, ex: `test` , `compile`
- inputKey: *taskKey with parameters* like: `testOnly`


Syntax
==========

- `:=` declare a setting from a SettingKey
- `+=`
- `%`
- `%%`

Plugins
==========

Multi Project Settings

Examples
==========

- [ ] ScalaSpec
- [ ] ???
