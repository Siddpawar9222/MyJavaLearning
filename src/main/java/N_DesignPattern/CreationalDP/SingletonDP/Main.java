package N_DesignPattern.CreationalDP.SingletonDP;

public class Main {
     public static void main(String[] args) {
       GovernmentOffice go1 = GovernmentOffice.getgovernmentOffice();
       GovernmentOffice go2 = GovernmentOffice.getgovernmentOffice();
       System.out.println(go1==go2);
     }
}

/*
Singleton :
- Only one object of the class should exist in the entire application.
- And everyone should use that same object.

Where do we use it?
We use Singleton when a single shared resource is needed in the entire application — e.g., logging, configuration, DB connection pool.

How Spring Boot uses Singleton?
Spring’s default bean scope is Singleton.
Annotations like @Service, @Controller, @Repository create Singleton beans.
Internally Spring maintains them in the ApplicationContext and reuses the same instance everywhere.


How to create Singleton class ? 
-Private constructor to restrict instantiation of the class from other classes.(If we create public then a person can create multiple object )
-Private static variable of the same class that is the only instance of the class.
-Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.
 */