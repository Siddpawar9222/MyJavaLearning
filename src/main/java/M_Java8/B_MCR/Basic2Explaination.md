## ✅ Example 1 – `sorted(String::compareToIgnoreCase)`

### Your explanation: **Correct ✅**

### Why it works

* `sorted()` expects a **Comparator**
* Comparator method:

```java
int compare(T o1, T o2);
```

* `String.compareToIgnoreCase` internally compares:

```java
o1.compareToIgnoreCase(o2);
```

### Lambda form

```java
(o1, o2) -> o1.compareToIgnoreCase(o2)
```

### Method reference form

```java
String::compareToIgnoreCase
```

### Why this is valid

* **Number of parameters match** → 2
* **Return type matches** → `int`

✅ Your conclusion here is **100% correct**.

---

## ❌ Example 2 – `filter(e -> e.startsWith("A"))`

#### Predicate functional interface

```java
boolean test(T t);
```

#### `startsWith` method

```java
boolean startsWith(String prefix)
```

⚠️ **Important point**
`startsWith(String prefix)` takes **ONE parameter**, not two.

So parameter count **is NOT the problem**.

---

## ❓ Then why method reference is NOT possible here?

### Because `"A"` is a **fixed value**

Method reference **cannot pass extra values**.

### Lambda (works)

```java
e -> e.startsWith("A")
```

Here:

* `e` comes from stream
* `"A"` is **extra data**

### Method reference (NOT possible)

```java
String::startsWith   ❌
```

Why?

* `startsWith` needs a **String prefix**
* Method reference has **no place to pass "A"**

---

## ✅ When method reference WOULD work

If both values come from stream:

```java
BiPredicate<String, String> bp = String::startsWith;
```

Or:

```java
list.stream().filter(str -> str.startsWith(prefix));
```

➡️ Lambda is required when **external data** is involved.

---

## 🧠 Simple Real-World Analogy

### Comparator example

> “Compare **this word** with **that word**”

Both values are supplied → method reference works ✅

---

### Predicate example

> “Check if **this word** starts with **'A'**”

* Word comes from stream
* `'A'` comes from outside
  ➡️ Method reference cannot inject `'A'` ❌

---

## ✅ Corrected Conclusion

### ✔ Example 1

* Parameter count matches
* Return type matches
  **Method reference possible**

### ✔ Example 2

* Parameter count is fine
* ❌ But **extra fixed value ("A")**
* ❌ Method reference cannot pass constants
  **Lambda is required**

---
