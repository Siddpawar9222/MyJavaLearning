package G_OOPS.Relationships;

// Car class demonstrating Composition and Aggregation
public class Car {
    private final String model;
    private final String color;
    private final Engine engine;           // Composition - Car owns Engine
    private MusicPlayer musicPlayer; // Aggregation - Car has MusicPlayer

    public  Car(String model, String color, MusicPlayer musicPlayer){
         this.model = model;
         this.color = color;
         this.engine = new Engine("V6", 300);
         this.musicPlayer = musicPlayer;
    }

    // Car controls its engine (Composition)
    public void startCar() {
        System.out.println("Starting " + color + " " + model + "...");
        engine.start();  // Car cannot work without engine
        System.out.println("Car is ready to drive!");
    }

    public void stopCar() {
        System.out.println("Stopping " + color + " " + model + "...");
        engine.stop();
        System.out.println("Car stopped!");
    }

    // Car uses music player (Aggregation)
    public void playMusic(String song) {
        if (musicPlayer != null) {
            musicPlayer.play(song);
        } else {
            System.out.println("No music player installed in this car");
        }
    }

    public void stopMusic() {
        if (musicPlayer != null) {
            musicPlayer.stop();
        } else {
            System.out.println("No music player installed in this car");
        }
    }

    // Car can work without music player
    public void drive() {
        if (engine.isRunning()) {
            System.out.println("Driving the " + model + " smoothly...");
        } else {
            System.out.println("Cannot drive! Engine is not running.");
        }
    }

    public String getModel() {
        return color + " " + model;
    }

    // When Car is destroyed, Engine is also destroyed (Composition)
    // But MusicPlayer continues to exist (Aggregation)
}
