package G_OOPS.Polymorphism.DynamicMethodDispatch;

interface Grandparent1 {
	void dance();

	void singer();
}

interface Parent1 extends Grandparent1 {
	void actor();

	void producer();
}

class Children implements Parent1 {
	@Override
	public void dance() {
		System.out.println("Children Dance");
    }

	@Override
	public void singer() {
		System.out.println("Children Singer");
	}

	@Override
	public void actor() {
		System.out.println("Children Actor");
	}

	@Override
	public void producer() {
       System.out.println("Children Producer");
  }


	void director() {
		System.out.println("Children Director");
	}

}

public class DMD1 {
	public static void main(String[] args) {

		 Grandparent1 c = new Children();
         c.dance();
         c.singer();
        // c.director() ;       //* 
         
        ((Parent1) c ).actor(); //casting
	     ((Parent1)c).producer();
		 ((Children) c).director();
	}
}
/*
//* -->
  Grandparent1 c = new Children(); 
  Parent class ref = instance

  Here always keep in mind that Here i created reference of Grandparent1 type and assigned instance of Children class. So through c i can only access method of Grandparent1 type(with implementation if Children class) . 
  To access children method we need to use typecasting .
 */