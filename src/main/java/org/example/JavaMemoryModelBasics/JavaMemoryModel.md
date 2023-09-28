1. Each thread has its own thread stack
2. All the threads share the same heap space
3. Which means all the threads have their own copy of local variables and reference to objects
    but since they share same heap space they will share the same objects
4. Threads can only share the data via heap, they cannot share data via thread stack.


## Java Memory Model

* The data is loaded into the Cache(L1,L2,L3) from the heap.
* Then this data is from cache is loaded into the thread registers.

* Similary when a data is changed it goes from the Register to the
Cache then to heap.

This model poses some problems when designing multithreaded applications.
One problem is **Race Condition**.

Race conditions as a result how Java threads access memory.

