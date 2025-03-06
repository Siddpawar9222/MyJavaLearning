package G_OOPS.Inheritance;

class Father {
	void m1() {
		System.out.println("Im father method");
	}

	@Override
	public int hashCode() {
		return 254358728;
	}

}

class Son extends Father {
	void m1() {
		super.m1();
		System.out.println("Im Son Method");
	}

	// @Override
	// public int hashCode() {
	// 	return 55354634;
	// }

}

class Mother {
      
}

class Daugher extends Mother {

}

public class InheritanceWithMethods {

	public static void main(String[] args) {

		// Son s1 = new Son();
		// s1.m1();
		// System.out.println(s1.hashCode());

		// Father f = new Father();
		// System.out.println(f.hashCode());

		Mother m = new Mother();
		System.out.println(m.hashCode()); //**

		Daugher d = new Daugher();
		System.out.println(d.hashCode());  //*

	}

}

/*
Note:  In Java, every class implicitly extends the Object class, and the Object class provides a default implementation of the hashCode() method. 
 //*--> Here jvm wil find is there any hashCode() method in daugher , in our case there is not , so it will search in Mother class , Mother also doesnt have ,But Mother extends Object class implicity . Hence Object class hasCode method will excute based on the memory addresses of the daugher object .
 //*--> same for Mother class 
 */