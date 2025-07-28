package G_OOPS.Relationships;

public class AggregationExample {
    public static void main(String[] args) {
        // Create MusicPlayer first (exists independently)
        MusicPlayer player = new MusicPlayer("Sony");

        System.out.println("\n=== TESTING CAR WITHOUT MUSIC PLAYER :: Aggregation ===");
        Car basicCar = new Car("Honda Civic", "Blue", null);
        basicCar.startCar();
        basicCar.playMusic("levitating");  // Will show no music player message
        basicCar.drive();  // Car still works!
        basicCar.stopCar();
    }
}
