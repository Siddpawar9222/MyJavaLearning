package G_OOPS.Relationships;

// Engine class (for Composition - cannot exist without Car)
public class Engine {
    private final String type;
    private final Integer horsePower;
    private Boolean isRunning;

    public Engine(String type, Integer horsePower) {
        this.type = type;
        this.horsePower = horsePower;
        this.isRunning = false;
    }

    public void start() {
        isRunning = true;
        System.out.println(type + " engine started! (" + horsePower + " HP)");
    }

    public void stop() {
        isRunning = false;
        System.out.println(type + " engine stopped!");
    }

    public boolean isRunning() {
        return isRunning;
    }
}
