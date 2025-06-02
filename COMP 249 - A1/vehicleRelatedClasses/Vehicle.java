package vehicleRelatedClasses;

public class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int yearOfProduction;
    private String type;
    private String category;

    // Default Constructor
    public Vehicle() {
        this.plateNumber = "";
        this.make = "";
        this.model = "";
        this.yearOfProduction = 0;
        this.type = "";
        this.category="";
    }

    // Parameterized Constructor
    public Vehicle(String make, String model, int yearOfProduction, String type, String category) {
        this.plateNumber = "";
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.type = type;
        this.category = category;
    }

    // Copy Constructor
    public Vehicle(Vehicle vehicle) {
        this.plateNumber = "";
        this.make = vehicle.make;
        this.model = vehicle.model;
        this.yearOfProduction = vehicle.yearOfProduction;
        this.type = vehicle.type;
        this.category = vehicle.category;

    }

    // Getters
    public String getPlateNumber() { return plateNumber; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYearOfProduction() { return yearOfProduction; }
    public String getType() { return type; }
    public String getCategory() { return category; }

    // Setters
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYearOfProduction(int yearOfProduction) { this.yearOfProduction = yearOfProduction; }
    public void setType(String type) { this.type = type; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "| Plate Number: [ " + plateNumber + " ] - " +yearOfProduction+ " - "+  make +" - " + model;
    }

    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;
        Vehicle vehicle = (Vehicle)obj;
        return yearOfProduction == vehicle.yearOfProduction &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model);
    }
} // End of Vehicle Class

