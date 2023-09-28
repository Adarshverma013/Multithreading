### Thread.join()

`thread.join();` 
when it is called other threads will wait for this thread to
finish its execution first.

### OS level threads VS User level threads

OS level threads are visible to kernel <br>
User threads are managed by user and are not visible to OS <br>
OS level threads are heavy and slow <br>
User threads are fast and take less memory

<hr>

## Virtual Threads in Java

It is a preview feature of Java 19

Virtual threads are executed by User/Platform threads and user/platform threads 
are executed by OS threads.

<hr>
