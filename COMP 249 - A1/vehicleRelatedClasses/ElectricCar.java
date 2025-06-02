package vehicleRelatedClasses;

public class ElectricCar extends Car{
    private int autonomyRange;
    private static int plateCounter = 1000;
    private int plateNumber;

    public ElectricCar(String make, String model, int yearOfProduction, String type,String category, int numberOfPassengers, int autonomyRange) {
        super(make, model, yearOfProduction,type, category, numberOfPassengers);
        this.autonomyRange = autonomyRange;
        this.plateNumber = plateCounter++;
    }

    // COPY Constructor //
    public ElectricCar(Vehicle vehicle) {
        super(vehicle);
    }

    //Getters and Setters //
    public int getAutonomyRange() {return autonomyRange;}
    public void setAutonomyRange(int autonomyRange) {this.autonomyRange = autonomyRange;}

}
