## Race Condition
A race condition is a concurrency problem that may occur inside a critical section.
A critical section is a section of code that is executed by multiple threads and where the sequence
of execution for the threads makes a difference in the result of the concurrent execution of the critical section.

When the result of multiple threads executing a critical section may differ depending on the sequence in which the threads execute,
the critical section is said to contain a race condition.
The term race condition stems from the metaphor that the threads are racing through the critical section,
and that the result of that race impacts the result of executing the critical section.

## Prevention
To prevent race conditions from occurring you must make sure that the critical section is executed as an atomic instruction.
That means that once a single thread is executing it,
no other threads can execute it until the first thread has left the critical section.

Race conditions can be avoided by proper thread synchronization in critical sections.
Thread synchronization can be achieved using a synchronized block of Java code.
Thread synchronization can also be achieved using other synchronization constructs like
locks or atomic variables like java.util.concurrent.atomic.AtomicInteger.

## Concurrency VS Parallelism
Concurrency means that an application is making progress on more than one task - at the same time or
at least seemingly at the same time (concurrently).

Parallel execution is when a computer has more than one CPU or CPU core, and makes progress on more than one task simultaneously.

## Parallel Concurrent execution
It is possible to have parallel concurrent execution, where threads are distributed among multiple CPUs.
Thus, the threads executed on the same CPU are executed concurrently,
whereas threads executed on different CPUs are executed in parallel.

## Parallelism
The term parallelism means that an application splits its tasks up into smaller subtasks which can be processed in parallel,
for instance on multiple CPUs at the exact same time.
Thus, parallelism does not refer to the same execution model as parallel concurrent execution -
even if they may look similar on the surface.