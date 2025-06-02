package vehicleRelatedClasses;

public class Car extends Vehicle {
    private int numberOfPassengers;

    // Parameterized Constructor
    public Car(String make, String model, int yearOfProduction, String type,String category, int numberOfPassengers) {
        super(make, model, yearOfProduction, type, category);
        this.numberOfPassengers = numberOfPassengers;
    }

    // Copy Constructor
    public Car(Vehicle vehicle) {
        super(vehicle);
    }

    // Getters and Setters
    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    @Override
    public String toString() {
        return super.toString() + " - Number of passengers: " + numberOfPassengers;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return numberOfPassengers == car.numberOfPassengers;
    }
} // End of Car Class
