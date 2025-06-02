package vehicleRelatedClasses;

public class DieselTruck extends Truck {
    private int fuelCapacity;
    private static int plateCounter = 1000;
    private int plateNumber;
    // Parameterized Constructor
    public DieselTruck(String make, String model, int yearOfProduction,String type,String category, int maxCarryWeight, int fuelCapacity) {
        super(make, model, yearOfProduction,type, category, maxCarryWeight);
        this.fuelCapacity = fuelCapacity;
        this.plateNumber = plateCounter++;
    }

    // Copy Constructor
    public DieselTruck(Vehicle vehicle) {
        super(vehicle);
    }

    // Getters and Setters
    public int getFuelCapacity() { return fuelCapacity; }
    public void setFuelCapacity(int fuelCapacity) { this.fuelCapacity = fuelCapacity; }

    @Override
    public String toString() {
        return super.toString() + " - Fuel Capacity: " + fuelCapacity + " Liters";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        DieselTruck dieselTruck = (DieselTruck) obj;
        return fuelCapacity == dieselTruck.fuelCapacity;
    }
} // End of Diesel Truck Class
