package G_OOPS.ReferenceVariable;

class TV {
    private String name;
    private String mode;

    public TV(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "TV [name=" + name + ", mode=" + mode + "]";
    }

}

public class A_Basic {

    public static void modifyTv(TV remote3) {
        remote3.setName("LG");
    }

    public static void assignTv(TV remote3) {
        remote3 = new TV("Sony", "OLCD andriod tv");
    }

    public static void main(String[] args) {
        
        //Creating an object
        System.out.println("Creating an object...");
        TV remote1 = new TV("samsung", "smart tv");
        TV remote2 = remote1;
        System.out.println("remote1 " + remote1);
        System.out.println("remote2 " + remote2);
        
        //Changing an object
        System.out.println("Changing an object...");
        remote2.setMode("antroid tv");
        System.out.println("remote1 " + remote1);
        System.out.println("remote2 " + remote2);
        
        //Assigning an object
         System.out.println("Assigning an object...");
        remote2 = new TV("Toshiba", "Traditional tv");
        System.out.println("remote1 " + remote1);
        System.out.println("remote2 " + remote2);

        // Passing object In modifyTv method
        System.out.println("Passing object In modifyTv method...");
        A_Basic.modifyTv(remote2);
        System.out.println("remote1 " + remote1);
        System.out.println("remote2 " + remote2);

        // Passing object In assignTv method
        System.out.println("Passing object In assignTv method...");
        A_Basic.assignTv(remote2);
        System.out.println("remote1 " + remote1);
        System.out.println("remote2 " + remote2);

    }
}
/*
https://youtu.be/9pR0iLjHbYI?si=ihbS2buMvCXGsaWS

TV remote1 = new TV("samsung", "smart tv");
   Here 
   Tv --> Object type
   remote1--> Object reference
   new TV("samsung", "smart tv")--> Object

Think  Object reference like remote1  which used to access Tv Object

Draw stack and heap diagram, you will understand how remote1, remote2, remote3 are created.
Internally use the concepts of stack frame and heap for method creation.
       
 */