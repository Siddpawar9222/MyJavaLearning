package G_OOPS.ReferenceVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee implements Cloneable {
    private int id;
    private String name;
    private List<String> skills;

    // Constructor
    public Employee(int id, String name, List<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = new ArrayList<>(skills); // IMP ---> i did mistake here
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(String skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", skills=" + skills + "]";
    }
     
    //  For Shallow copy
    // @Override
    // public Object clone() throws CloneNotSupportedException {
    //     return super.clone();
    // }
    
   //// Deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee emp = (Employee)super.clone(); 
        emp.skills=new ArrayList<>(this.skills);
        return emp;
    }



}

public class C_TypesOfCopy {
    public static void main(String[] args) throws CloneNotSupportedException {

        Employee e1 = new Employee(111, "Joe Doe", Arrays.asList("UI/UX", "JavaScript"));
        
        System.out.println("Shallow copy...");
        //Shallow copy
        Employee e2 = (Employee) e1.clone();

        System.out.println("Before Changes...");
        System.out.println("e1 " + e1);
        System.out.println("e2 " + e2);

        e1.setSkills("React-Js");
        // e2.setSkills("React-Js");
        e1.setName("Joo");

        System.out.println("After Changes...");
        System.out.println("e1 " + e1);
        System.out.println("e2 " + e2);
         
        System.out.println("Deep Copy...");
        //Deep Copy
        Employee e3 = new Employee(1555, "Alis Parry", Arrays.asList("Python","MogoDB"));
        Employee e4 = (Employee)e3.clone();

        e3.setSkills("MySQL");
        
        System.out.println("After Changes...");
        System.out.println("e3 " + e3);
        System.out.println("e4 " + e4);


    }
}

/*
***IMP***
 * If class contains mutable objects (objects whose state can be changed , eg.. Collection, Custom Object), those  mutable objects' references will be shared between the original and copied
 objects.

 * If class only contains primitive types or immutable objects (objects whose state cannot be changed once created e.g.. String , int), then changes to the original object won't affect the copied object and vice versa.
   
  In = operator 
    Employee e1 = new Employee();
    Employee e2 = e1;

    Here e1 and e2 are reference and pointing to same object new Employee() . Hence It doesnt matter immutable or mutable state of object(field of object) .


 * Types of Copy :
Shallow copy : 
-Shallow copy refers to the copying of an object where the fields of the new object contain  references to the same objects as the fields in the original object.
-Only mutable object
- Using  default implementation of clone method and with above condition 


Deep Copy :
 Deep copy refers to creating a new object with a new set of fields, such that the new object is a complete and independent copy of the original object, including all nested objects within it.
 Need to write custom logic in clone method .
 Logic might be : 
    emp.skills=new ArrayList<>(this.skills);
      Here we create new instance of ArrayList and add all existing elements inside it. So list independent to old one.

Lazy Copy : 
Lazy Copy is used when you might generally need Deep Copy, but are not sure whether it is really necessary. Deep Copy is generally an expensive operation. If you do it unconditionally in 100% of cases and then discover that you only needed it in 10% of objects, then the efforts spent on Deep-Copying the other 90% of objects were wasted.

This is when Lazy Copy comes in. Lazy Copy is a postponed, delayed, on-demand version of Deep Copy. With Lazy Copy you don't perform Deep Copy right away. Instead, you prepare (or schedule) a Deep Copy by storing all pertinent information in the recipient object (which most of the time boils down to a mere Shallow Copy) and wait till it becomes known whether the Deep Copy is really necessary for that specific object. If it turns out to be necessary, you perform the actual Deep Copy. If the need for Deep Copy never arises, then it doesn't happen, thus saving you the effort.
 */