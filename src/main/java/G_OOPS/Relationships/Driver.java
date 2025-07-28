package G_OOPS.Relationships;

// Driver class (for Association - uses Car temporarily)
class Driver {
    private String name;
    private String licenseNumber;

    public Driver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    // Association: Driver uses Car (temporary relationship)
    public void driveCar(Car car) {
        System.out.println("\n" + name + " is driving " + car.getModel());
        car.startCar();
        car.drive();
        car.playMusic("Highway to Hell");
        car.drive();
        car.stopMusic();
        car.stopCar();
        System.out.println(name + " finished driving\n");
    }

    public String getName() {
        return name;
    }
}