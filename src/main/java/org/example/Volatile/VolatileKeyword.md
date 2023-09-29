If a variable is marked volatile then it will be written/read directly from the main memory

---- Java Volatile visibility Gurantee ----
whenever we WRITE to a volatile variable then
that variable and all other variables visible to that thread
are directly written to main memory.

Similarly when a thread READS a volatile variable then the value of
that variable has to be read directly from main memory at this
moment all other variables after this variable are also read
from main memory.
-----------------------------------------------------------------

Instruction reordering could break the Java volatile visibility gurantee

Volatile variables causes memory overhead and reduces performance and read/write is
directly from main memory.

Volatile keyword is not always enough.