package J_Multithreading.concurrency.ThreadLocal;

public class Main {
    private static final ThreadLocal<String> userThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        userThreadLocal.set("user1");
        System.out.println(userThreadLocal.get());

        // override current user
        userThreadLocal.set("user2");
        System.out.println(userThreadLocal.get());

        // Will clear the context avoid memory leaks(usually write in finally block)
        userThreadLocal.remove();
    }
}
/*
Why not ?
*Map<Thread, UserInfo> userContext = new ConcurrentHashMap<>();
OR
Map<userId, UserInfo> userContext = new ConcurrentHashMap<>();

You need to pass userId everywhere
    Every method that wants user info must accept userId (or fetch it from JWT again).
    This makes code messy.
    In a layered backend (Controller → Service → Repository), passing userId manually everywhere pollutes method signatures.


Not really thread-safe for request scope
    Suppose two requests from the same user hit the backend at the same time → same userId, but different data (like two transactions).
    Both requests would overwrite each other in the map.
    ThreadLocal avoids this by isolating data per thread.


Not the right abstraction
    The user info is not global shared data, it’s per request/per thread data.
    That matches ThreadLocal’s job perfectly.
 * */