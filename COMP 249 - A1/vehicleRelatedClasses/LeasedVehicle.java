package vehicleRelatedClasses;

public class LeasedVehicle extends Vehicle {
    private String leaseStartDate;
    private String leaseEndDate;

    // Constructor
    public LeasedVehicle(String make, String model, int year, String type, String category, String leaseStartDate, String leaseEndDate) {
        super(model,make, year, type, category);
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
    }

    // Getters and Setters for leased vehicle attributes
    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public String getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(String leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    // Overriding toString method to include lease details
    @Override
    public String toString() {
        return super.toString() + ", Lease Start: " + leaseStartDate + ", Lease End: " + leaseEndDate;
    }
}
