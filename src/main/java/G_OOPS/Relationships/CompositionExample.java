package G_OOPS.Relationships;

public class CompositionExample {
    public static void main(String[] args) {
        // Create MusicPlayer first (exists independently)
        MusicPlayer player = new MusicPlayer("Sony");

        // Create Car with MusicPlayer (Aggregation)
        Car car = new Car("Toyota Camry", "Red", player);

        System.out.println("=== COMPOSITION EXAMPLE ===");
        System.out.println("Car MUST have engine to work:");
        car.startCar();
    }
}
