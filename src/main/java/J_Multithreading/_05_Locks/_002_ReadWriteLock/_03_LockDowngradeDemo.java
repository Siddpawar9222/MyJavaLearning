package J_Multithreading._05_Locks._002_ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class CacheRefresh {

    private final Map<String, String> cache = new HashMap<>();

    private final ReentrantReadWriteLock rwLock =
            new ReentrantReadWriteLock();

    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public String refreshAndRead(String key) {

        writeLock.lock();

        try {

            System.out.println("Loading latest value from DB");

            String value = loadFromDB(key);

            cache.put(key, value);

            // Downgrade starts here
            readLock.lock();

        } finally {

            // Release write lock
            writeLock.unlock();
        }

        try {

            System.out.println("Reading after downgrade");

            return cache.get(key);

        } finally {

            readLock.unlock();
        }
    }

    private String loadFromDB(String key) {
        return "jdbc:mysql://localhost:3306/production";
    }
}


public class _03_LockDowngradeDemo {

    public static void main(String[] args) {

        CacheRefresh cache =
                new CacheRefresh();

        String value =
                cache.refreshAndRead("DB_URL");

        System.out.println(value);
    }
}