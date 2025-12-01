package K_IO_Stream.ByteStream.ObjectInput_OutputSteam.serialization;

import java.io.Serializable;


public class Student implements Serializable {
     private String name ;
     transient private String email ;
     private String address ;
     private int age ;

	public Student(String name, String email, String address, int age) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
	}
	
	public Student() {

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public  void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void showSkills() {
		System.out.println("Best Java Full Stack Developer in the world...");
	}
	
     
}
// transient - Particular state(variable) will not take not in serialization and deserialization . We can use only for variables(object). static marked field doesnt take part serialization process.

/*
Serializable interface- 
-The Serializable interface serves as a contract between the class and the Java serialization mechanism. It indicates that the class is designed to be serializable and specifies that the class's fields should be included in the serialization process.
-When a class implements the Serializable interface, it is essentially informing the Java runtime that objects of that class can be converted into a byte stream and then be saved to a file, transferred over a network, or stored in a database. This process is known as serialization.
*/