package clientRelatedClasses;

import vehicleRelatedClasses.Vehicle;
import vehicleRelatedClasses.LeasedVehicle;

public class ClientsInformation {
    private String name;
    private int age;
    private int creditScore;
    private String email;
    private Vehicle[] leasedVehicles;  // Array to store leased vehicles

    // Default Constructor
    public ClientsInformation() {
        this.name = null;
        this.age = 0;
        this.creditScore = 0;
        this.email = null;
        this.leasedVehicles = new Vehicle[0];  // Default empty array
    }

    // Parameterized Constructor
    public ClientsInformation(String name, int age, int creditScore, String email, Vehicle[] leasedVehicles) {
        this.name = name;
        this.age = age;
        this.creditScore = creditScore;
        this.email = email;
        this.leasedVehicles = leasedVehicles;
    }

    // COPY Constructor
    public ClientsInformation(ClientsInformation ci) {
        this.name = ci.name;
        this.age = ci.age;
        this.creditScore = ci.creditScore;
        this.email = ci.email;
        this.leasedVehicles = ci.leasedVehicles;  // Copy leased vehicles array
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Vehicle[] getLeasedVehicles() { return leasedVehicles; }
    public void setLeasedVehicles(Vehicle[] leasedVehicles) { this.leasedVehicles = leasedVehicles; }

    // toString method
    public String toString() {
        return "| " + name + " | " + age + " | " + creditScore + " | " + email + " |";
    }
}
