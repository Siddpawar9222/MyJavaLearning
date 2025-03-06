package G_OOPS.AccessModifiers.Protected;

//In Java, the protected access modifier is used to declare a member (a field, method or inner class) of a class, that can be accessed by the class itself, its subclasses, and other classes in the same package as the declaring class.

//A protected member is not accessible outside the package where it is declared, except through inheritance.(VIMP)
//A protected member can be accessed in a subclass using the super keyword.

class ProtectedClass{
	protected String name;
    protected int age;
  

    protected void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class ProtectedClass1 extends ProtectedClass{
	private String company;

    public ProtectedClass1(String name, int age, String company) {
        this.name = name; // accessible from subclass due to protected access modifier
        this.age = age; // accessible from subclass due to protected access modifier
        this.company = company;
    }
    public void printEmployeeDetails() {
        printDetails(); // accessible from subclass due to protected access modifier
        System.out.println("Company: " + company);
    }
}


public class ProtectedAM {

	public static void main(String[] args) {
		ProtectedClass pc1 = new ProtectedClass();
		 System.out.println(pc1.age);
		ProtectedClass1 pc = new ProtectedClass1("Siddhesh", 23, "Google") ;
		pc.printEmployeeDetails();

	}

}
