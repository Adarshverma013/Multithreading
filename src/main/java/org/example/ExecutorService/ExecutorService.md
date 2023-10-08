Executor service is a builtin thread pool in java.

ExecutorService is an Interface, we can create one executor service by
calling one of the static factory methods present in Executors class.

Also there are two builtin implementations of ExecutorService interface
ThreadPoolExecutor and ScheduledThreadPoolExecutor.

ScheduledThreadPoolExecutor implements ScheduledExecutorService which extends ExecutorService.

```
ExecutorService threadPoolExecutor = 
        new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(128)
            );
```

The main difference between ThreadPoolExecutor and ScheduledThreadPoolExecutor is that in first it starts executing
tasks as quickly as we submit it but in 2nd we can schedule a task as when to execute.

## Methods of ThreadPoolExecutor

#### _execute()_ method
This method accepts an implementation of Runnable interface and executes it.

#### _submit()_ method
This method also accepts an implementation of Runnable interface but it returns _Future_ which gives some information about the execution of the task.

Future has a methods called `isDone()` which tells that task is complete or not.
Another method `get()` returns a result from the task however `run()` method of Runnable does not returns anything so we get nothing.

`get()` methods blocks main thread until a result is returned by the task or in runnable case when task is complete.

#### Callable
Callable is an Interface simlar to Runnable and it has a single call method.
`call` method can return an Object.

We can pass Callable to `submit()` method of threadPool.

#### invokeAny()
This method takes a list of callable implementations and invokes any one of the tasks.

#### invokeAll()
This method takes a list of callable implementations and invokes all of them.