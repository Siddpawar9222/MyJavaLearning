package J_Multithreading._09_Synchronizers;

public class _01_SemaphoreBasic {
}
/*
How many threads can access a resource simultaneously(Including Read and Write Thread).
It is different from Locks
We can use in
   - Database connection pool
   - API rate limiting
   - Download manager
   - Printer pool
   - Parking lot
   - Thread throttling
Types :
   - counting Based
   - Binary Bases (only one thread)
* */