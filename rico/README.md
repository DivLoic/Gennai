# Rico
###### Final project 2016 from @ISEP

### Subject
>The isep lab has been working on a generic recommender system, able to recommend
>things like food, journey or training. The main concern of this project is to design a scalable version of it.

### Technologies
- [X] Apache Spark
- [X] Apache Cassandra
- [ ] Apache Zeppelin
- [ ] Spark jobServer

### Prerequisites
Here is the tools & versions used for the project.
- git
- jdk   : 1.7.0_80
- sbt   : 0.13.9
- scala : 2.10.6
- spark (1.4.1), cassandra (2.2.5), zeppelin, mysql or
[The gowalla VM demo](https://github.com/natalinobusa/gowalla-spark-demo)


### Configuration
I. Environment      
Add to your `~/.bashrc` the following lines:
```sh
export SPARK_PKGS="com.datastax.spark:spark-cassandra-connector_2.10:1.4.1"
export SPARK_PKGS="org.apache.lucene:lucene-analyzers:3.6.2,${SPARK_PKGS}"
export SPARK_PKGS="mysql:mysql-connector-java:5.1.38,"${SPARK_PKGS}
export SPARK_PKGS="org.scalanlp:breeze_2.10:0.11.2,${SPARK_PKGS}"
```
II. Configuration file      
Before compiling the sources copy & edit the configuration file.
```bash
$ cp src/main/resources/rico.conf.template src/main/resources/rico.conf
$ vi src/main/resources/rico.conf
```
Your will find pre-fill options like connection, language or the name of the distance function. To get into the confi file
syntax see [scala-config](https://github.com/typesafehub/config).

### Setup

```bash
$ git clone https://github.com/DivLoic/Rico
$ cd Rico
```

You will first need to edit the conf file rico.conf as show in the previous part: **Configuration**.
```bash
$ cp src/main/resources/rico.conf.template src/main/resources/rico.conf
$ vi src/main/resources/rico.conf
```

Now compile the project and run the prejob to fill the cassandra db.
```bash
$ sbt package
$ cqlsh -f src/main/resources/rico.cql
$ spark-submit --packages $SPARK_PKGS --class org.rico.etl.Restore --master <your-master> /path/to/jar
$ spark-submit --packages $SPARK_PKGS --class org.rico.etl.Tfidf --master <your-master> /path/to/jar
```
### Usage       
Once the project is configured, use the following command to run it:
```bash
$ sbt package
$ spark-submit --packages $SPARK_PKGS --class org.rico.app.ItemView --master <your-master> /path/to/jar <id item>
$ spark-submit --packages $SPARK_PKGS --class org.rico.app.UserView --master <your-master> /path/to/jar <id user>
```

### Optionals

#### Logging
In order to have understandable logging system you can use the following configuration. First, copy the template of
*log4j file* in your spark home. This template set all logger at **ERROR**. Inside the *Rico* folder:
`cp src/main/resources/log4j.properties ${SPARK_HOME}/conf/log4j.properties`.

```properties
log4j.logger.rico = INFO
log4j.appender.rico.Threshold=INFO
log4j.appender.rico=org.apache.log4j.ConsoleAppender
log4j.appender.rico.target=System.out
log4j.appender.rico.layout=org.apache.log4j.PatternLayout
log4j.appender.rico.layout.ConversionPattern=%d{yy/MM/dd HH:mm:ss} %5p (%F:%L): %m%n
```

#### Test
During the all project we used unit test to tackle api like *snowball* or *breeze*. This helping us also to test purly functionnal
statement when we was unfamiliar with. Here is a simple exemple using *scalatest*. We firts difine de behavior of the function 
in a test case that extends **FunSuite**. To run the test just hit `$ sbt test`
```{scala}
test("Should stem the words with a Function from the Transformer"){
    val func = trf.doStem()
    assertResult ("mang") (func("mangé"))
    assertResult ("nécessit") (func("nécessiteront"))
    assertResult ("envoi") (func("envoyées"))
    assertResult (func("finance")) (func("financement"))
  }
```
Then we get the things done.
```{scala}
def doStem(p):(String => String) = {
  val func = p match = {
    case a => //...
    case b => //...
    case c => //...
  }
    func
}
```

#### Service with *SparkJobServer*
Once we are able to recommend items, the application has to interact with real a information
systems. This can be done with a *REST* service and a standard format like **JSON**. This part
is a test using [Spark-JobServer](https://github.com/spark-jobserver/spark-jobserver) (Apache2.0).
```bash
$ git clone https://github.com/spark-jobserver/spark-jobserver.git
$ cd spark-jobserver
$ git checkout v0.6.0 # bcz spark 1.4.1
$ export JBS_HOME=`pwd`
```
Then edit the file `vi project/Dependencies.scala` and the following for the rico project:
```{scala}
  val excludeCh = ExclusionRule(organization = "com.chuusai")
  // ... find sparkDeps ...
  lazy val sparkDeps = Seq(
      // ...
      "com.datastax.spark" % "spark-cassandra-connector_2.10" % "1.4.1",
      "org.scalanlp" %% "breeze" % "0.12" excludeAll(excludeCh, excludeQQ)
    )
```
Finally edit the configuration file:
```bash
$ cp config/local.conf.template config/dev.conf
$ vi config/dev.conf
# under context-settings add
# spark.cassandra.connection.host = "..."
# spark.cassandra.connection.port = "..."
```
HERE WE ARE, hit the `sbt` command, then `job-server/reStart config/dev.conf`. Load the jar and enjoy the
only job adapted to this mode: ItemViewService.
```bash
$ cd /path/to/Rico
$ curl --data-binary @target/scala-2.10/rico_2.10-1.0.jar localhost:8090/jars/rico
$ curl -d "param.itemid=37" "localhost:8090/jobs?appName=rico&classPath=org.rico.app.ItemViewService&sync=true&timeout=999"
```
*result:*
```json
{ "success": true,
  "result": [
    ["id1", "title1", "score1"],
    ["id2", "title2", "score2"]
  ]
}
```

### Project
Here is a tree of the project folder architecture. It present all files under the
*main* folder. The *resources* folder contains the config files example and the **cql**
script which initialise the cassandra keyspace. The package `org.rico.etl` refers to all
code dealing with data acquisition and `org.rico.app` refers to the recommmender itself.
```
.
├── resources
│   ├── log4j.properties
│   ├── rico.conf.template
│   ├── rico.cql
│   └── test.conf
└── scala
    ├── Functions.sc
    └── org
        └── rico
            ├── app
            │   ├── ItemView.scala
            │   ├── ItemViewService.scala
            │   ├── Rico.scala
            │   └── UserView.scala
            └── etl
                ├── Extractor.scala
                ├── Restore.scala
                ├── Tfidf.scala
                └── Transformer.scala
```

### Coding Style

```{scala}
val sparkConf = new SparkConf()
  .setAppName("[rico] - some task")
  .set("spark.cassandra.connection.host", conf.getString("cassandra.host"))
  .set("spark.cassandra.connection.port", conf.getString("cassandra.port"))
  // ...
  var obj = new Obj(/*some config*/)
  val someFunction = obj.ReturFunction
  // ...
  val rdd2 = rdd1.map { x => someFunction x }
```

### Our Team
- [@jordansportes](https://github.com/jordansportes8355)
- [@nrasolom](https://github.com/nrasolom)
- [@DivLoic](https://github.com/DivLoic)

See also, our engineering school : [isep.fr](http://www.isep.fr)
