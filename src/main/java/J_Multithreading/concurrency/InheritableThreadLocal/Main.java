package J_Multithreading.concurrency.InheritableThreadLocal;

public class Main {
    private final static InheritableThreadLocal<String> userContext = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        userContext.set("Parent User");

        Thread child = new Thread(() -> {
            System.out.println("Child thread: " + userContext.get());
        });
        child.start();
    }
}
/*

Where is this useful ?

Logging Context (MDC in SLF4J/Logback)
    Often we store requestId, correlationId, or userId in a ThreadLocal.
    If the request handling spawns new threads (child threads), we still want the context available in those threads for logging.
    InheritableThreadLocal makes this automatic.

Security Context
    If a parent thread stores UserInfo (from JWT), and a child thread processes some async task for the same request, the child should also “know” about the user.

Transaction Context
    When you start a DB transaction in the main thread, the same transaction metadata may be required in child threads.


* */