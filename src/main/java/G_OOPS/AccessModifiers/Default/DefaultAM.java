package G_OOPS.AccessModifiers.Default;

//The default access modifier is used when no access modifier is specified for a class, method, or field. It means that the class, method, or field is accessible only within the same package . Outside method we cannot access class

//The default access modifier is useful for hiding implementation details from other packages and ensuring that classes, methods, and fields are only accessible by classes within the same package. However, it is important to note that default access should be used judiciously and should not be relied upon as a security mechanism.


 class DefaultAMClass {
   int a =10;
   void defaultMethod() {
	   System.out.println("Default Method.....");
   }
}
 class DefaultAMClass1 extends DefaultAMClass{   //subclass
	 int  b = 10 ;
 }
	 
 

public class DefaultAM{

	public static void main(String[] args) {
		DefaultAMClass am = new DefaultAMClass();
		System.out.println(am.a);
		DefaultAMClass1 am1 = new DefaultAMClass1();
		System.out.println(am1.a);
		am1.defaultMethod();
	}
}