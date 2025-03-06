package G_OOPS.Basic;



public class Bike {
	String name;          
	String color;

	public void info() {
		System.out.println("The name bike is " + name);
		System.out.println("The color of bike is " + color);
	}

	public void mileage(int a) {
		System.out.println("The mileage of bike is " + a);
	}

	public static void main(String[] args) {

		Bike cd = new Bike();
		cd.name = "Cd delux";
		cd.color = "black";
		cd.info();
		cd.mileage(60);

		// --------------------------------------------------------------
		System.out.println();
		Bike shine = new Bike();
		shine.name = "Shine";
		shine.color = "red";
		shine.info();
		shine.mileage(0);
		
         

	}

}
