## Monitor Object
### Normal methods
A synchronized block in java is a block of code which can be accessed
by only one thread at a time.<br>
Synchrinized blocks are marked using `synchronized` keyword.

Also there can be synchrinized block inside a method if we do not want to mark whole method synchronized.
```java
class SynchrinozedEx {
    public void setObj(Object obj) {
        synchrinozed(this){
            // code goes here
        }
    }
}
```
`this` keyword refers to monitor object which in this case is the instance of the class in which this function is.

### Static methods

Synchronized keywords can be used similarly with static methods.<br>
Only change in this case is the monitor object will be class.

```java
class SynchrinozedEx {
    public void setObj(Object obj) {
        synchrinozed(SynchrinozedEx.class){
            // code goes here
        }
    }
}
```
A monitor object cannot be null.

### Multiple monitor objects
There can be multiple monitor objects explicitly created inside a class for synchronization.
Also Monitor object can be shared and set at Runtime via Constructor.



In case of shared monitor objects -
* If two methods of different classes share same monitor object then two threads one having lock on each methods will block each other.
* This happens because even the methods are different but the monitor object is same.

![Multiple monitor objects](../../../../resources/images/Multiple%20monitor%20object.png)

In case of shared monitor object thread accessing Synchronized block 1 will block all the threads from entering synchronized block 1 and synchronized block 2.

> You should not use String literals as monitor objects.
> As we don't know how java compiler will handle the Strings.

### Synchronized block Reentrance rule

If a thread have a lock on a monitor object then it can put another lock on same monitor object.
<br> i.e. it will not block itself.

```java
public class Reentrance {
    private int count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized int incAndGet() {
        inc();
        return this.count;
    }
}
```
In above case Java will allow the thread to access inc() method that is accessing incAndGet() as monitor object on both is same.

> Synchronized blocks also provides visibility gurantee and happens before gurantee.

## Limitations

1. Only one thread access at a time.
2. There is no gurantee in which the waiting threads will get access to synchronized block.
3. Performance overhead as thread have to wait for other thread to finish executing.

> Threads cannot block each other across VMs.

