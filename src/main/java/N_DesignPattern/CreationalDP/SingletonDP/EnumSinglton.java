package N_DesignPattern.CreationalDP.SingletonDP;

public class EnumSinglton {
}

 enum DatabaseConnection {
    INSTANCE;

    public void connect() {
        System.out.println("Connecting to DB...");
    }
}

/*
Enum Singleton is considered the best, simplest, and safest way to create Singleton in Java.

Why Enum is perfect?

- JVM guarantees one instance only
-Prevents:
    Reflection attacks
    Serialization attacks
    Cloning attacks

Thread-safe by default
Very small clean code


Note :
Enum auto-serialize and auto-deserialize when we run the program

How Enum Serialization Actually Works
-When you serialize an enum:
    -Java does NOT save its fields.
    -Java does NOT save the entire object structure.
    -Java only saves the enum constant name.(e.g.INSTANCE)



Enum Serialization Thread-Safe :
- Enum creation is handled by the JVM class loader.
- JVM guarantees thread safety for enum initialization.
- Enum instances are immutable → safe to share across threads.

So enums are:
    ✔ Thread-safe
    ✔ Singleton by nature
    ✔ Safe during serialization/deserialization
  */