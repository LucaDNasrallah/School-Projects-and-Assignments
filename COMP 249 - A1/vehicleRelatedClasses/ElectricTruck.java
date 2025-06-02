package vehicleRelatedClasses;

public class ElectricTruck extends Truck {
    private int autonomyRange;
    private static int plateCounter = 1000;
    private int plateNumber;

    // Parameterized Constructor
    public ElectricTruck(String make, String model, int yearOfProduction, String type, String category, int maxCarryWeight, int autonomyRange) {
        super(make, model, yearOfProduction, type, category, maxCarryWeight);
        this.autonomyRange = autonomyRange;
        this.plateNumber = plateCounter++;
    }

    // Copy Constructor
    public ElectricTruck(Vehicle vehicle) {
        super(vehicle);
    }

    // Getters and Setters
    public int getAutonomyRange() { return autonomyRange; }
    public void setAutonomyRange(int autonomyRange) { this.autonomyRange = autonomyRange; }

    @Override
    public String toString() {
        return super.toString() + " - Maximum Autonomy Range: " + autonomyRange + " Kilometers";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        ElectricTruck electricTruckCar = (ElectricTruck) obj;
        return autonomyRange == electricTruckCar.autonomyRange;
    }

} // End of Electric Truck Class
