package G_OOPS.Encapsulation;


class Employee {
	private String name;
	private int id;

	public Employee(){
	}

	public Employee(String name, int id){
		 this.name=name;
		 this.id=id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

}

public class Introduction {

	public static void main(String[] args) {

		Employee eg = new Employee();

		// eg.name ="Siddhesh" ; //I cant do this because name is private

		eg.setName("Siddhesh Pawar");
		System.out.println(eg.getName());

		eg.setId(22);
		System.out.println(eg.getId());
	}

}
/*
Encapsulation in Java is a process of wrapping code and data together into a single unit, for example, a capsule which is mixed of several medicines.

The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
	-declare class variables/attributes as private
	-provide public get and set methods to access and update the value of a private variable
	-Use constructors to initialize object data.
    -Optionally, use validation in setter methods to restrict invalid data.

private variables can only be accessed within the same class (an outside class has no access to it). However, it is possible to access them if we provide public get and set methods.
The get method returns the variable value, and the set method sets the value.

Note:
Syntax for both is that they start with either get or set, followed by the name of the variable, with the first letter in upper case:
*/