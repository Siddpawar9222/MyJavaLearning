package K_IO_Stream.serialVersionUID.problem;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;
    // add email field later after creating student.ser file and again run Deserialize class you will see InvalidClassException
    String email;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

/*
Where does serialVersionUID come in ?
When Java serializes and deserializes objects, it must check:

"Is the class structure (fields, methods) the same as when it was serialized?"

To check this, Java uses serialVersionUID.
  If serialVersionUID of the saved object matches with the class, deserialization works fine.
  If it does not match, you get an InvalidClassException.


1. If you don’t specify serialVersionUID
-Java will automatically generate one at compile time.
-It is not random, but calculated using the class’s details:
   class name
   implemented interfaces
   method signatures
   fields
   modifiers (public/private/static etc.)

-So, something like a hash of the class structure.

2. What is the “default value”?
-The generated number is a long (like -1234567891234567890L).
-Different compilers (javac, Eclipse, IntelliJ) may generate different values for the same class.
-If you change the class (add/remove a field, change a method, even reorder fields sometimes), the compiler will generate a different number.
-This is why relying on default is risky → because even a small class change can break deserialization.
* */