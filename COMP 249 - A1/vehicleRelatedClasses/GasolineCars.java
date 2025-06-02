package vehicleRelatedClasses;

public class GasolineCars extends Car {
    private static int plateCounter = 1000;
    private int plateNumber;

    public GasolineCars(String make, String model, int yearOfProduction, String type, String category,int numberOfPassengers) {
        super(make, model, yearOfProduction, type, category, numberOfPassengers);
        this.plateNumber = plateCounter++;
    }

    public GasolineCars(Vehicle vehicle) {
        super(vehicle);
    }

}
