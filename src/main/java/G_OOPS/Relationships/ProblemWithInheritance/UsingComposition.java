package G_OOPS.Relationships.ProblemWithInheritance;

interface PaymentProcessor {
    void processPayment(double amount);
}
class CreditCardProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        // Logger logger = new Logger();        // Created temporarily   // dependency relationship
         // logger.log("Payment started");       // Used briefly
        // logger goes out of scope - dependency ends
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class UpiProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class PaymentService {
    private PaymentProcessor processor;   // We haven't created concrete object here, instance going to decide at runtime

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void makePayment(double amount) {
        processor.processPayment(amount);
        sendEmailNotification(amount);
    }

    private void sendEmailNotification(double amount) {
        System.out.println("Email sent for payment of ₹" + amount);
    }
}
public class UsingComposition {
    // Using composition
    public static void main(String[] args) {
        PaymentService creditPayment = new PaymentService(new CreditCardProcessor());
        creditPayment.makePayment(500);

        PaymentService upiPayment = new PaymentService(new UpiProcessor());
        upiPayment.makePayment(300);
    }
}

/*
Note: Concrete class or object always create tight coupling

Here we made Composition Loosely coupled using interface
Benefits  achieved:
Flexibility: Easy to add new payment methods (PayPal, Cash, etc.)
Testability: You can inject mock processors for testing
Maintainability: Changes to one processor don't affect others
Single Responsibility: Each processor handles one payment type
* */