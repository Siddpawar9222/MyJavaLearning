package M_Java8.B_MCR;

//constructor reference
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

@FunctionalInterface
interface ProductFactory {
    Product createProduct(String name, double price);
}

public class Basic1 {
    public static void main(String[] args) {

        // Without constructor reference
        ProductFactory pf = (name,price)-> new Product(name,price);

        Product mobile = pf.createProduct("Mobile", 2152.54154);

        // Using a constructor reference to create instances of Product
         ProductFactory factory = Product::new;
        
         // Create a new product using the factory
         Product laptop = factory.createProduct("Laptop", 999.99);
         
         // Display product details
         System.out.println("Product Name: " + laptop.getName());
         System.out.println("Product Price: $" + laptop.getPrice());

    }
}
