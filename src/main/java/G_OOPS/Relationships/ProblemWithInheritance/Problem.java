package G_OOPS.Relationships.ProblemWithInheritance;


// Parent class
class Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using generic payment.");
    }
}

// Child classes
class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class UpiPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }

    // What if you need to extend Logger too?
    // What if you need to extend FraudDetector too?
    // JAVA DOESN'T ALLOW MULTIPLE INHERITANCE!
    // I must have to add this parent class or in PaymentServiceClass you need to use if_else
}


class PaymentServiceClass {
     private Payment payment;
    PaymentServiceClass(Payment payment){
         this.payment = payment;
    }

    public void makePayment(double amount) {
        payment.pay(amount);
        sendEmailNotification(amount);
    }

    private void sendEmailNotification(double amount) {
        System.out.println("Email sent for payment of ₹" + amount);
    }
}

public class Problem {
    public static void main(String[] args) {

    }
}
/*

| Problem with Inheritance      | How Composition Solves It                 |
| ----------------------------- | ----------------------------------------- |
| Repeated code in subclasses   | Common logic in one class (no repetition) |
| Difficult to add new behavior | Easy to plug new behavior (plug-and-play) |
| Tight coupling                | Loose coupling through interfaces         |
| Inflexible to changes         | Easy to change or swap components         |

Conclusion:
Use inheritance only when there is a clear IS-A relationship.
Use composition when you want flexibility and better code reuse.
* */