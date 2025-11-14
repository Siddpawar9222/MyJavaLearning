package L_CollectionFramework.Synchrorization;

import java.util.*;

public class A_Basic {
    public static void main(String[] args) {
        /*
        # Why some collections are NOT synchronized ?

        Because:
        They are faster
        They avoid unnecessary locking
        Most applications don’t always need thread safety
        Example:
        ArrayList, HashMap, LinkedList, HashSet → not synchronized

        # How to make them synchronized?
        Java gives a special utility class
         Collections.synchronizedXXX()
        This wraps your normal collection into a thread-safe version.
        * */

        List<Integer> list = new ArrayList<>();

        List<Integer> syncList = Collections.synchronizedList(list);

        syncList.add(10);
        syncList.add(20);


        // Now syncList is thread-safe.
        //When iterating, you must lock manually:
        synchronized (syncList) {
            for (Integer n : syncList) {
                System.out.println(n);
            }
        }

       // Synchronized Set
        Set<String> set = new HashSet<>();
        Set<String> syncSet = Collections.synchronizedSet(set);

       /*
            Better modern alternative (recommended in interviews)

            Instead of using synchronized collections,
            Java gives concurrent collections which are much faster:

            Examples:
            ConcurrentHashMap
            CopyOnWriteArrayList
            CopyOnWriteArraySet
            ConcurrentLinkedQueue
            ConcurrentSkipListMap
            These are designed for concurrency, not just locked wrappers.
        */

    }
}
