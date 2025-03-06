package G_OOPS.AccessModifiers.Protected;

public class Person {
	protected String name;
    protected int age;

    protected void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
