# 🟥 Ways Singleton Can Be Broken


There are **4 major ways** a Singleton class can be broken:

---

## 1️⃣ **Using Reflection**

Reflection can access the private constructor and create new objects.

Example:

```java
Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
c.setAccessible(true);
Singleton obj2 = c.newInstance();
```

This creates a **second object**, breaking singleton.

### ✅ **Solution**

Add a check inside constructor:

```java
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance()!");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```

Now if reflection tries to create a second object → you throw exception.

---

## 2️⃣ **Using Cloning**

If class implements `Cloneable`, clone() creates a new object → breaks singleton.

### Solution:

Override clone() and prevent cloning:

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}
```

---

## 3️⃣ **Using Serialization / Deserialization**

When you serialize → deserialize a Singleton, it creates a **new object**.

### Solution:

Implement `readResolve()`:

```java
protected Object readResolve() {
    return getInstance();
}
```

This makes sure deserialization returns existing object.

---

## 4️⃣ **Multithreading Issue**

If Singleton uses lazy initialization but is **not thread-safe**, two threads can create two instances.

Example broken version:

```java
public static Singleton getInstance() {
    if (instance == null) {       // Two threads can enter here
        instance = new Singleton();
    }
    return instance;
}
```

### Solution (Thread-safe Singleton)

Use **double-checked locking**:

```java
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

---

# 🟢 Summary for Interview (Very Important)

### **Ways Singleton breaks:**

1. Reflection
2. Serialization
3. Cloning
4. Multithreading

### **Fixes:**

* Throw exception in constructor
* Override `readResolve()`
* Override clone()
* Use **double-checked locking** with `volatile`

If you say this in interview, it is **impressive**.

---
