### Parallel Programming - week 1


>*Definition Process*
>

>*Definition Thread*
>

>*Definition Atomicity*
>

>*Definition DeadLocks:*
>*DeadLocks occurs when two threads get mutually blocked on each other's resources.* 

>*Definition Memory Model*
>*A memory model is a set of rules that describes how threads interact when accessing shared memory*

Exemple of rules from the JVM:

- Two threads writing to separate locations in memory do not need synchronization. 
- If thread X calls join on thread Y is guaranteed to observe all the writes by thread Y after join returns. 