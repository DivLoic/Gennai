# Csauto
###### Content Square auto-complete exercise - Loïc DIVAD (@DivLoic)

### Prerequisites

- jdk: 1.7 
- scala: 2.11
- sbt: 0.13.8 

### The subject

>You are given a list of keywords below. Write code that will offer up to 4 suggested “auto­complete”
>based on the letters typed (not case sensitive). Similar to Google Autocomplete (example below), 
>except that results must be in order vs. Google ranked keywords.

### The answer

Here we solve the question by defining a `Corpus`. It contains multiple elements of the type `[T]`
(here a string to make it simple, but we can also try document retrial). Finally, the functionality 
demanded are implemented in the `KeywordSet` class that **extends** the corpus.        
Then his version of execute is define as follow:
- filter all elements that begin by `query`
- sort the elements 
- get 4 first elements
- return a new `Corpus` composed only by the query result

Once done, the new corpus can be printed, send on the network or whatever ...

### Installation & Running

```{bash}
$ git clone https://github.com/DivLoic/Csauto.git
$ cd Csauto/
$ sbt compile 
```

Then the command `sbt run` launch de program and ask you to type a first something.     
Just type a few letter and hit **enter**. 
![running log](https://github.com/DivLoic/Csauto/raw/master/src/main/resources/img/ScreenOne.png)
Then it ask you to type something else, again and again ...  (Ctrl + C to stop)

### Test

Hit `sbt test` to see all unit tests that validate search functionality. You should see the following:
![test stack](https://github.com/DivLoic/Csauto/raw/master/src/main/resources/img/ScreenTwo.png)


### Questions

> 1) What would you change if the list of keywords was large (several millions)?

Parallel computation may be the trick. With a distributed dataset (like the rdd from *Spark* :wink:)
the filter step will go faster. Here is a little sketch: 

```
                                        
rdd_1 ─ ├── partition_1 ── filter ── sort ── limit ──┤ ─ rdd_2 ── sort ── limit ── rdd_3 
        ├── partition_2 ── filter ── sort ── limit ──┤
        ├── partition_3 ── filter ── sort ── limit ──┤ 
        └── partition_4 ── filter ── sort ── limit ──┘

```

> 2) What would you change if the requirements were to match any portion of the keywords 
(example: for string “pro”, code would possibly return “re**pro**be”)

Most programming language provide a *contain* method with the String support.
Replace `startWith` by `contains` in the execute pipeline could be a solution.