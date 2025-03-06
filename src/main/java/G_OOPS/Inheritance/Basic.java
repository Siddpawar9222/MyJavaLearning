package G_OOPS.Inheritance;

class Company{
	String  comName="google" ;
	int comCode=10122 ;
	public void companyInfo() {
		System.out.println("Comapny name is " +comName + " code is "+comCode);
	}
}
class Employee extends Company{
	String comName="Amazone" ;          //* 
	String emp="Siddhesh" ;
	int id =45 ;
	String designation="Night Manager";
    
	public void employeeInfo(){       //**
       System.out.println("Company Name is " + comName);
	}
    
    // @Override
	public void companyInfo(int a) {
		System.out.println("Comapny name is " +comName + " code is "+comCode);
	}   
}
public class Basic {

	public static void main(String[] args) {
	  Employee e1 = new Employee()	;
	  e1.employeeInfo();
	  System.out.println(e1.comCode);
	  e1.companyInfo();
	  e1.companyInfo(45);
	}

}

/*
Inheritance :  one class (called the child class or subclass) inherits the properties and methods of another class (called the parent class or superclass). This allows the child class to reuse the code and extend the functionality of the parent class.

A real-world example of inheritance : 
 The relationship between animals and their offspring. In this scenario, the offspring inherit certain traits, characteristics, and behaviors from their parents. For instance, a dog may inherit the coat color, size, and certain behavioral traits from its parents.
 */

/*
//*-->Here comName is variable for Employee instance which is  different variable than  Company instance .
//**-->since i changed companyInfo parameter, Company class CompanyInfo() will call.

Conclusion: 
 I can Override field and methods in inheritance(Learn Method Overriding first)
 */