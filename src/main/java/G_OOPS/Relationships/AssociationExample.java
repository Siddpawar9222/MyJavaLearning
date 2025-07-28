package G_OOPS.Relationships;

public class AssociationExample {
    public static void main(String[] args) {
        // Create MusicPlayer first (exists independently)
        MusicPlayer player = new MusicPlayer("Sony");

        // Create Car with MusicPlayer (Aggregation)
        Car car = new Car("Toyota Camry", "Red", player);

        // Create Driver independently (Association)
        Driver driver = new Driver("John", "DL12345");

        System.out.println("\n=== ASSOCIATION EXAMPLE ===");
        System.out.println("Driver uses Car temporarily:");
        driver.driveCar(car);
    }
}
