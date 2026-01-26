package G_OOPS.Object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    String name;
    Integer roll_no;

    public Student(String name, int roll_no) {
        this.name = name;
        this.roll_no = roll_no;
    }

    @Override
    public String toString() {
        return name + " " + "  " + roll_no + "  ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Student student = (Student) o;
        return this.roll_no == student.roll_no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll_no);
    }

 }

public class B_EqualsAndHashCode {
    public static void main(String[] args) {
        Set<Student> s = new HashSet<>();
        Student s1 = new Student("Alice", 25) ;
        Student s2 = new Student("Bob", 30) ;
        Student s3 = new Student("Prince", 25) ;
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        s.add(s1);
        s.add(s2);
        s.add(s3);
        System.out.println(s);
    }
}
/*
- equals() method : 
- The equals() method is used to compare two objects for equality.
- Object class defined equals() method like this(default implementation):

public boolean equals(Object obj) {
        return (this == obj);
}

means compare object based on reference(Memory allocation).

- hashCode() method :
-The hashCode() method is used to generate a hash code value for an object(unique identifier for an object).
-Default hashCode generates different hash codes for different memory addresses

//=======================//=======================//

Here we implemented custom logic for equals() and hashCode method.
equals() and hashCode method uses roll_no for comparing and to create hashcode.

Internally hashSet uses hashCode method to create key(bucket).

***How it is working*** ? 


 key      ------------------> value 
(Integer/roll_no)        (LinkedList of Student)
(Forget HashFuction)

when we add 

s.add(s1);
s.add(s2);


   56  ------------------>  s1
   61  ------------------>  s2

s.add(s3); 

s3 roll_no is 56, already present in hashtable, so now s1 will compare with s3, and s1 is same as s2 , so value will not inserted(Dublicated value insertion is avoided).
   
   56  ------------------>  s1
   61  ------------------>  s2


toString() method :
- The toString() method is used to return a string representation of an object.
- Default Implementation : 

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

- Which means By default it returns a string containing the class name and the memory address of the object.   
    

hashCode() :
- By default, Object.hashCode() returns an integer that is generally derived from the object’s memory address, but Java does NOT guarantee it to be the actual memory address.
- We can customize hashCode() using Objects.hash() or our own logic
@Override
public int hashCode() {
    return Objects.hash(id, name);
}

-HashSet internally use this hashcode for hashfuction, which return the bucket index and using equals() method, we compare the object by the given field.

 */
