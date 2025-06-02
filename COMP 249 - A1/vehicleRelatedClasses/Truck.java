package vehicleRelatedClasses;

public class Truck extends Vehicle {
    private int maxCarryWeight;

    // Parameterized Constructor
    public Truck(String make, String model, int yearOfProduction, String type, String category,int maxCarryWeight) {
        super(make, model, yearOfProduction,type, category);
        this.maxCarryWeight = maxCarryWeight;
    }

    // Copy Constructor
    public Truck(Vehicle vehicle) {
        super(vehicle);
    }

    // Getters and Setters
    public int getMaxCarryWeight() { return maxCarryWeight; }
    public void setMaxCarryWeight(int maxCarryWeight) { this.maxCarryWeight = maxCarryWeight; }

    @Override
    public String toString() {
        return super.toString() + " - Max Carry Weight: " + maxCarryWeight + "Kilograms";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Truck truck = (Truck) obj;
        return maxCarryWeight == truck.maxCarryWeight;
    }
} // End of Truck Class
