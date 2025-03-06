package G_OOPS.AccessModifiers.Private;

//In Java, the private access modifier is used to restrict access to a member (a field, method, or nested class) of a class to only that class itself. A private member cannot be accessed from outside the class, not even from its subclasses.

 class Private1{
   private int  a1 = 10 ; 
   private String  name = "Siddhesh" ; 
}

public class Private {
   private int a =151 ;
   public static void main(String[] args) {
	   Private p = new Private();
	   System.out.println(p.a);    //We can do it with with private
	   
	   Private1 p1 = new Private1();
	   //System.out.println(p1.name);  //We cant do this
}    
}
