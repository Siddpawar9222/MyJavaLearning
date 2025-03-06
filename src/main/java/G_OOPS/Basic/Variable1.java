package G_OOPS.Basic;

public class Variable1 {
	static String address; // Global variable

	public static void main(String[] args) {

		String name; // local variable
		// System.out.println(name); //compiler error- initialize variable

		String name1 = null;
		System.out.println(name1);
//		System.out.println(name1.charAt(0));  //null pointer exception

		System.out.println(address);

	}

}
