Java compiler/VM reorders instructions to improve parallelism
for e.g.<br>
```
a = b+c //1
d = a+e //2

f = g+h //3
i = f+j //4
```
Here compiler gets to know that instruction 2 depends on 1 and
instruction 4 depends on 3 but 1 and 3 are independent.<br>
So instructions are reordered and 1 and 3 are run parallel and
2 and 4 in parallel.<br>
<hr>

**This instruction reordering may affect multithreaded applications where
threads communicate via shared objects.**

### Volatile variable solution
1. Let's say two threads are there.
2. Each thread will have their own copy of local variables.
3. And it's not guranteed that write from one thread will be flushed to main memory.
4. Also it's not guranteed that other thread will read from main memory it may read from its local cache.
5. So in Java a `volatile` variable gurantees that it will be read and written directly to and from tha main memory.
6. And we do not need to mark all the vairables volatile as all the variables whose write is before volatile variable are also written to main memory and read from main memory.
7. But if there is instruction reordering then volatile variable may move up and breaks our visibility gurantee.
8. Here comes in rescue Java Happens Before Gurantee.
9. All the writes before volatile variable will remain before even after instruction reordering.

### Synchronized block solution
* The above happens before voalite variable gurantee follows with Synchronized blocks also.
* All reads and writes before Syncronized block are guranteed to be before it even after instruction reordering.
* And all fields inside the block will remain inside it.

> Note: Its happen before gurantee for write operation and happens
> after gurantee for read operation. As all reads after synchrnized block or volatile
> variables will be after it even after instruction reordering so that they are also read
> from main memory.

