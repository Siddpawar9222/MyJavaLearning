package J_Multithreading._05_Locks;

public class _10_StampedLockBasic {
}
/*
- If there are 90% reader operation and 10% write operation, Still for read we are unnecessary lock and unlock the object which is waste of resource. Hence, stampedLock came. It provides optimistic read feature.
When we apply locks on read and write operation, then its gives use stamp(noting but id) and at the time of release we need to pass this id.
Vehicle parking example : When we enter the parking lot, we get a ticket (stamp) and when we leave the parking lot, we need to return the ticket (stamp) to exit.
* */