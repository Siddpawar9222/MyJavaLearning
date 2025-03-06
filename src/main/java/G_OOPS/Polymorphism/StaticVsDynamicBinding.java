package G_OOPS.Polymorphism;


public class StaticVsDynamicBinding {

	public static void main(String[] args) {

        // Static binding
        // Calling static authentication method
        boolean isAuthenticated = BankSecurity.authenticateUser("admin", "securePass123");

        if (isAuthenticated) {
            System.out.println("✅ User authenticated. Access granted.");
        } else {
            System.out.println("❌ Authentication failed! Access denied.");
        }



        // Dynamic binding
		String paymentType =  "CreditCardPayment" ; // Your-payment-type-coming-from-client-side
        double amount = 0.0;                       // Your-amount-type-coming-from-client-side;

        Payment payment ;

        if(paymentType.equalsIgnoreCase("CreditCardPayment")){
             payment = new CreditCardPayment();    // dynamic binding
        }else if(paymentType.equalsIgnoreCase("PayPalPayment")) {
             payment = new PayPalPayment();
        }else {
             payment = new Payment() ;           // default payment
        }

        payment.processPayment(amount);
	}

}
/*
1}Static/compile/early binding :
When type of the object is determined at compiled time(by the compiler), it is known as static binding.
Properties :
-If there is any private, final or static method in a class, there is static binding.
-Faster execution because method calls are resolved during compilation.
-Does not support polymorphism (method overriding works with dynamic binding instead).



//2}Dynamic/runtime/late binding :
When type of the object is determined at run-time, it is known as dynamic binding.
In the above example object type cannot be determined by the compiler, because the instance of payment is also an instance of CreditCardPayment or PayPalPayment. So compiler doesn't know its type, only its base type.
Properties :
-  Used with Non-Static and Non-Final Methods
- Slower execution because method calls are resolved during runtime.
- supports polymorphism(method overriding).
- Enables Code Flexibility
*/
