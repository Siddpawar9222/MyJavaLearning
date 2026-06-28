package J_Multithreading._05_Locks._003_StampedLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class _03_StampedLockConfigCache {

    private final Map<String, String> cache =
            new HashMap<>();

    private final StampedLock lock =
            new StampedLock();

    public String getConfig(String key) {

        long stamp = lock.readLock();

        try {

            String value = cache.get(key);

            if (value != null) {
                return value;
            }

            // Cache Miss

            long writeStamp =
                    lock.tryConvertToWriteLock(stamp);

            if (writeStamp != 0L) {

                stamp = writeStamp;

                value = loadFromDatabase(key);

                cache.put(key, value);

                return value;
            }

        } finally {

            lock.unlock(stamp);
        }

        return null;
    }

    private String loadFromDatabase(String key) {

        System.out.println(
                "Loading from DB : " + key);

        return "VALUE_" + key;
    }
}
/*
 Upgrade Problem :
 In ReadWriteLock we had to  apply double check to for upgrade
 * */
