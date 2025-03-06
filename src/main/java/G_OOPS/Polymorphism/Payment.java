package G_OOPS.Polymorphism;

class Payment {
    public void processPayment(double amount) {
        System.out.println("Processing generic payment of $" + amount);
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}