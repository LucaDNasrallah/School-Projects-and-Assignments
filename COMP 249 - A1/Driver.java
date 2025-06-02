//--------------------------------------------------------------
// Assignment 1
// Part II - Driver Class
// Written by: Luca D. Nasrallah - 40316548
// -------------------------------------------------------------
import java.util.Arrays;
import java.util.Scanner;
import vehicleRelatedClasses.*;
import clientRelatedClasses.*;

public class Driver {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int clientListCount = 4;
        int vehicleListCount = 100;
        boolean exit = false, mainExit = false;

        System.out.println("Welcome to the RoyalRentals Car rental service Admin Page. ");
        System.out.println("There are two options for using this program. The Testing interface (1), and the main interface (2).");
        System.out.print("Enter your choice here: ");
        int menuChoice = cin.nextInt();
        if(menuChoice == 1) {
            // Creating vehicle objects
            Vehicle[] vehicles = new Vehicle[vehicleListCount];
            ElectricCar[] eCar = new ElectricCar[vehicleListCount];
            GasolineCars[]  gCars = new GasolineCars[vehicleListCount];
            DieselTruck[] dTruck = new DieselTruck[vehicleListCount];
            ElectricTruck[] eTruck = new ElectricTruck[vehicleListCount];


            vehicles[0] = dTruck[0] = new DieselTruck("TruckMake1", "TruckModel1", 2022, "Truck", "Diesel", 5000, 128);
            vehicles[1] = dTruck[1] = new DieselTruck("TruckMake2", "TruckModel2", 2023, "Truck", "Diesel", 6000, 165);
            vehicles[2] = dTruck[2] = new DieselTruck("TruckMake3", "TruckModel3", 2021, "Truck", "Diesel", 4500, 200);
            vehicles[3] = dTruck[3] = new DieselTruck("TruckMake3", "TruckModel3", 2021, "Truck", "Diesel", 4500, 200);

            vehicles[4] = eTruck[0] = new ElectricTruck("ElectricTruckMake1", "ElectricTruckModel1", 2023, "Truck", "Electric", 7000, 1000);
            vehicles[5] = eTruck[1] = new ElectricTruck("ElectricTruckMake2", "ElectricTruckModel2", 2024, "Truck", "Electric", 6500, 2000);
            vehicles[6] = eTruck[2] = new ElectricTruck("ElectricTruckMake3", "ElectricTruckModel3", 2022, "Truck", "Electric", 7200, 2000);

            vehicles[7] = eCar[0] = new ElectricCar("ElectricCarMake1", "ElectricCarModel1", 2022, "Car", "Electric", 150, 1000);
            vehicles[8] = eCar[1] = new ElectricCar("ElectricCarMake2", "ElectricCarModel2", 2023, "Car", "Electric", 180, 2000);
            vehicles[9] = eCar[2] = new ElectricCar("ElectricCarMake3", "ElectricCarModel3", 2021, "Car", "Electric", 200,3000);

            vehicles[10] = gCars[0] = new GasolineCars("GasolineCarMake1", "GasolineCarModel1", 2022, "Car", "Gasoline", 120);
            vehicles[11] = gCars[1] = new GasolineCars("GasolineCarMake2", "GasolineCarModel2", 2023, "Car", "Gasoline", 140);
            vehicles[12] = gCars[2] = new GasolineCars("GasolineCarMake3", "GasolineCarModel3", 2021, "Car", "Gasoline", 160);


            LeasedVehicle vehicle1 = new LeasedVehicle("Toyota", "Camry", 2020, "Truck", "Electric", "2023-01-01", "2025-01-01");
            LeasedVehicle vehicle2 = new LeasedVehicle("Ford", "F-150", 2022, "Truck", "Diesel", "2023-06-01", "2025-06-01");
            LeasedVehicle vehicle3 = new LeasedVehicle("Tesla", "Model 3", 2021, "Car", "Electric", "2022-05-01", "2024-05-01");
            // Creating clients
            ClientsInformation[] clientList = new ClientsInformation[clientListCount];
            clientList[0] = new ClientsInformation("Luca Nasrallah", 20, 550, "l_nasa@gmail.com", new Vehicle[]{vehicle1});
            clientList[1] = new ClientsInformation("Georges ", 25, 850, "Georges@gmail.com", new Vehicle[]{vehicle2});
            clientList[2] = new ClientsInformation("Lia ", 50, 900, "Lia@gmail.com", new Vehicle[]{vehicle3});

            System.out.println("Comparing Two Objects from Different Classes");
            System.out.println("Comparing Vehicles 1 diesel trucks and 1 gasoline cars");
            System.out.println("Results: " + dTruck[0].equals(gCars[0]));


            System.out.println("Comparing Two objects of the same class");
            System.out.println("Comparing Vehicles 2 and 3");
            System.out.println("Results: " + dTruck[1].equals(dTruck[2]));

            System.out.println("Comparing two objects of teh same class with identical ");
            System.out.println("Comparing Vehicles 3 and 4 of Diesel Trucks");
            System.out.println("Results: " + dTruck[2].equals(dTruck[3]));

            getLargestTruck(vehicles);
            copyElectricTrucks(vehicles);

        }else if(menuChoice == 2) {


            Vehicle[] vehicles = new Vehicle[vehicleListCount];
            vehicles[0] = new DieselTruck("Ford", "F-250", 2023, "Truck", "Diesel", 1936, 128);
            vehicles[1] = new ElectricTruck("Tesla", "Cyber Truck", 2024, "Truck", "Electric", 1134, 5);
            vehicles[2] = new GasolineCars("Ferrari", "F8 Tributo", 2023, "Car", "Gasoline", 2);
            vehicles[3] = new ElectricCar("Porsche", "Taycan Turbo S", 2023, "Car", "Electric", 5, 357);

            // Create Leased Vehicle objects
            LeasedVehicle vehicle1 = new LeasedVehicle("Toyota", "Camry", 2020, "Truck", "Electric", "2023-01-01", "2025-01-01");
            LeasedVehicle vehicle2 = new LeasedVehicle("Ford", "F-150", 2022, "Truck", "Diesel", "2023-06-01", "2025-06-01");
            LeasedVehicle vehicle3 = new LeasedVehicle("Tesla", "Model 3", 2021, "Car", "Electric", "2022-05-01", "2024-05-01");
            LeasedVehicle vehicle4 = new LeasedVehicle("Chevrolet", "Tahoe", 2023, "Car", "Gasoline", "2023-02-15", "2025-02-15");

            // Create ClientsInformation and assign leased vehicles
            ClientsInformation[] clientList = new ClientsInformation[clientListCount];
            clientList[0] = new ClientsInformation("Luca Nasrallah", 20, 550, "l_nasa@gmail.com", new Vehicle[]{vehicle1});
            clientList[1] = new ClientsInformation("Georges ", 25, 850, "Georges@gmail.com", new Vehicle[]{vehicle2});
            clientList[2] = new ClientsInformation("Lia ", 50, 900, "Lia@gmail.com", new Vehicle[]{vehicle3});
            clientList[3] = new ClientsInformation("Paul ", 55, 899, "Paul@gmail.com", new Vehicle[]{vehicle4});


            do {
                displayMenu();
                int choice = cin.nextInt();
                switch (choice) {
                    case 1: {
                        do {
                            exit = false;
                            System.out.print("""
                                    Vehicle Management System
                                    ----------------------------------------------------------------------------
                                    1. Add a Vehicle
                                    2. Delete a Vehicle
                                    3. Update Vehicle Information
                                    4. List all Vehicles by category (Electric trucks, diesels trucks, etc...)
                                    5. Return to main menu
                                    ---------------------------------------------------------------------------
                                    Enter Choice here:\s""");
                            choice = cin.nextInt();
                            switch (choice) {
                                case 1: {
                                    vehicles = addVehicle(vehicles, cin);
                                    break;
                                }
                                case 2: {
                                    vehicles = deleteVehicle(vehicles, cin);
                                    break;
                                }
                                case 3: {
                                    editVehicle(vehicles, cin);
                                    break;
                                }
                                case 4: {
                                    listAllVehiclesByCategory(vehicles);
                                    break;
                                }
                                case 5: {
                                    exit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Please enter a valid option!");
                                }
                            }
                        } while (!exit);
                        break;
                    }
                    case 2: {
                        do {
                            exit = false;
                            System.out.print("""
                                    Client Management System
                                    ---------------------------------
                                    1. Add a Client
                                    2. Edit a Client
                                    3. Delete a Client
                                    4. Return to Main Menu
                                    ---------------------------------
                                    Enter Choice here:\s""");
                            choice = cin.nextInt();
                            switch (choice) {
                                case 1: {
                                    clientList = addClient(clientList, cin);
                                    break;
                                }
                                case 2: {
                                    editClient(clientList, cin);
                                    break;
                                }
                                case 3: {
                                    clientList = deleteClient(clientList, cin);
                                    break;
                                }
                                case 4: {
                                    exit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Please enter a valid option!");
                                }
                            }
                        } while (!exit);
                        break;
                    }
                    case 3: {
                        do {
                            exit = false;
                            System.out.print("""
                                    Leasing Operations
                                    ---------------------------------
                                    1. Lease a Vehicle to a client
                                    2. Return a vehicle from a client
                                    3. Show all vehicles leased by a client
                                    4. Show all leased vehicles (by all clients)
                                    5. Return to main menu
                                    ---------------------------------
                                    Enter Choice here:\s""");
                            choice = cin.nextInt();
                            switch (choice) {
                                case 1: {
                                    leaseAVehicle(clientList, vehicles, cin);
                                    break;
                                }
                                case 2: {
                                    returnAVehicle(clientList, vehicles, cin);
                                    break;
                                }
                                case 3: {
                                    showLeasedByClient(clientList, cin);
                                    break;
                                }
                                case 4: {
                                    showLeasedByAll(clientList);
                                    break;
                                }
                                case 5: {
                                    exit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Please enter a valid option!");
                                }
                            }
                        } while (!exit);
                        break;
                    }
                    case 4: {
                        do {
                            exit = false;
                            System.out.print("""
                                    Additional Operations
                                    ---------------------------------
                                    1. Display the truck with the largest capacity
                                    2. Create a copy of the electric trucks array.
                                    3. Return to main menu
                                    ---------------------------------
                                    Enter Choice here:\s""");
                            choice = cin.nextInt();
                            switch (choice) {
                                case 1: {
                                    getLargestTruck(vehicles);
                                    break;
                                }
                                case 2: {
                                    copyElectricTrucks(vehicles);
                                    break;
                                }
                                case 3: {
                                    exit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Please enter a valid option!");
                                }
                            }
                        } while (!exit);
                        break;
                    }
                    case 5: {
                        System.out.println("Thank you for using the Royal Rental Program. Hope you enjoyed your time :)");
                        mainExit = true;
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice. Try again.");
                        break;
                    }
                }
            } while (!mainExit);
        }
    }// END of Main Method //


    public static void displayMenu() {
        System.out.print("""
                1. Vehicle Management System
                2. Client Management System
                3. Leasing Operations
                4. Additional Operations
                5. Quit
                -----------------------------
                Please Enter a choice here:\s""");
    }// End of Display Method //

    public static Vehicle[] addVehicle(Vehicle[] vehicles, Scanner cin) {
        boolean isFull = true;
        for (Vehicle vh : vehicles) {
            if (vh == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            Vehicle[] extendedVehicles = new Vehicle[vehicles.length + 1]; // Extend array
            for(int i = 0; i < vehicles.length; i++) {
                extendedVehicles[i] = vehicles[i];
            }
            vehicles = extendedVehicles;
        }
        vehicles = inputForVehicle(vehicles, cin);
        System.out.println("Vehicle has been added successfully");
        return vehicles;
    }

    public static Vehicle[] deleteVehicle(Vehicle[] vehicles, Scanner cin){
        boolean isFull = true;
        for (Vehicle v : vehicles) {
            if (v == null) {
                isFull = false;
                break;
            }
        }
        if (isFull) {
            System.out.print("Which Vehicle from 1 - " + (vehicles.length) + " will be deleted? ");
            int vehicleID = cin.nextInt();
            Vehicle[] decendedVehicle = new Vehicle[vehicles.length - 1];

            // Swap selected vehicle with the last vehicle before deletion
            Vehicle temp = vehicles[vehicles.length - 1];
            vehicles[vehicles.length - 1] = vehicles[vehicleID - 1];
            vehicles[vehicleID - 1] = temp;
            vehicles[vehicles.length - 1] = null;

            for(int i = 0; i < decendedVehicle.length; i++){
                decendedVehicle[i] = vehicles[i];
            }
            vehicles = decendedVehicle;
        }
        System.out.println("Vehicle has been deleted successfully");
        return vehicles;
    }

    public static void editVehicle(Vehicle[] vehicles, Scanner cin) {
        System.out.print("Which Vehicle from 1 - " + vehicles.length + " will be edited? ");
        int vehicleID = cin.nextInt();

        if (vehicleID < 1 || vehicleID > vehicles.length || vehicles[vehicleID - 1] == null) {
            System.out.println("Invalid vehicle selection.");
            return;
        }

        Vehicle vehicle = vehicles[vehicleID - 1];
        System.out.println("This is the current Vehicle's Information:\n\t" + vehicle + "\n");

        // Display edit options based on vehicle type
        System.out.print("""
                   Which Part of Information would you like to Edit:
                   1. Make
                   2. Model
                   3. Year
                   4. Vehicle Type -- (Truck or Car)
                   5. Fuel -- (Gasoline/Diesel or Electric)
                  """);

        if (vehicle instanceof Truck) {
            if (vehicle instanceof ElectricTruck) {
                System.out.print("""
                6. Maximum Carry Weight in Kilograms
                7. Autonomy Range in Kilometers
               """);
            } else if (vehicle instanceof DieselTruck) {
                System.out.print("""
                6. Maximum Carry Weight in Kilograms
                7. Fuel Capacity in Liters
               """);
            }
        } else if (vehicle instanceof Car) {
            if (vehicle instanceof ElectricCar) {
                System.out.print("""
                6. Maximum Number of Passengers
                7. Autonomy Range in Kilometers
               """);
            } else if (vehicle instanceof GasolineCars) {
                System.out.print("""
                6. Maximum Number of Passengers
               """);
            }
        }

        System.out.print("\nEnter your choice: ");
        int choice = cin.nextInt();
        cin.nextLine();

        // Handle user input for editing fields
        switch (choice) {
            case 1 -> {
                System.out.print("Enter new Make: ");
                vehicle.setMake(cin.nextLine());
            }
            case 2 -> {
                System.out.print("Enter new Model: ");
                vehicle.setModel(cin.nextLine());
            }
            case 3 -> {
                System.out.print("Enter new Year: ");
                vehicle.setYearOfProduction(cin.nextInt());
            }
            case 4 -> {
                System.out.print("Enter new Vehicle Type (Truck/Car): ");
                vehicle.setType(cin.nextLine());
            }
            case 5 -> {
                System.out.print("Enter new Fuel Type (Gasoline/Diesel/Electric): ");
                vehicle.setCategory(cin.nextLine());
            }
            case 6 -> {
                if (vehicle instanceof Truck truck) {
                    System.out.print("Enter new Maximum Carry Weight (kg): ");
                    truck.setMaxCarryWeight(cin.nextInt());
                } else if (vehicle instanceof Car car) {
                    System.out.print("Enter new Maximum Number of Passengers: ");
                    car.setNumberOfPassengers(cin.nextInt());
                }
            }
            case 7 -> {
                if (vehicle instanceof ElectricTruck eTruck) {
                    System.out.print("Enter new Autonomy Range (km): ");
                    eTruck.setAutonomyRange(cin.nextInt());
                } else if (vehicle instanceof DieselTruck dTruck) {
                    System.out.print("Enter new Fuel Capacity (liters): ");
                    dTruck.setFuelCapacity(cin.nextInt());
                } else if (vehicle instanceof ElectricCar eCar) {
                    System.out.print("Enter new Autonomy Range (km): ");
                    eCar.setAutonomyRange(cin.nextInt());
                }
            }
            default -> System.out.println("Invalid choice.");
        }
        System.out.println("Updated Vehicle Information:\n\t" + vehicle);
    }

    public static void listAllVehiclesByCategory(Vehicle[] vehicles) {
        System.out.println("Listing Vehicles by Category:");

        // Group vehicles by category
        System.out.println("Electric Trucks:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricTruck) {
                System.out.println(vehicle + "\n");
            }
        }

        System.out.println("Diesel Trucks:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof DieselTruck) {
                System.out.println(vehicle + "\n");
            }
        }

        System.out.println("Electric Cars:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricCar) {
                System.out.println(vehicle + "\n");
            }
        }

        System.out.println("Gasoline Cars:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof GasolineCars) {
                System.out.println(vehicle + "\n");
            }
        }
    }

    public static ClientsInformation[] addClient(ClientsInformation[] clientList, Scanner cin) {
        // Check if array needs expansion
        boolean isFull = true;
        for (ClientsInformation cl : clientList) {
            if (cl == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            ClientsInformation[] newClientList = new ClientsInformation[clientList.length + 1];
            for (int i = 0; i < clientList.length; i++) {
                newClientList[i] = clientList[i];
            }
            clientList = newClientList;
        }
        clientList = inputClientInfo(clientList, cin);
        System.out.println("Client has been added successfully");
        return clientList;
    }


    public static void editClient(ClientsInformation[] clientsList, Scanner cin) {
        boolean exit = false;
        System.out.print("Which Clients Information from 1 - " + clientsList.length + " will be edited? ");
        int clientID = cin.nextInt();

        if (clientID < 1 || clientID > clientsList.length || clientsList[clientID - 1] == null) {
            System.out.println("Invalid vehicle selection.");
            return;
        }

        ClientsInformation clientList = clientsList[clientID - 1];
        System.out.println("This is the current Vehicle's Information:\n\t" + Arrays.toString(clientsList) + "\n");

        System.out.print("""
                 Which Part of Information would you like to Edit:
                 1. Full Name
                 2. Age
                 3. Credit Score
                 4. Email
                 5. Return to Main Menu
                """);
        int choice = cin.nextInt();
        do {
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new Full Name: ");
                    clientList.setName(cin.nextLine());
                    break;
                }
                case 2 -> {
                    System.out.print("Enter new Age: ");
                    clientList.setAge(cin.nextInt());
                    break;
                }
                case 3 -> {
                    System.out.print("Enter new Credit Score: ");
                    clientList.setCreditScore(cin.nextInt());
                    break;
                }
                case 4 -> {
                    System.out.print("Enter new Email: ");
                    clientList.setEmail(cin.nextLine());
                    break;
                }
                case 5->{
                    exit = true;
                    break;
                }
                default -> System.out.println("Invalid choice.");
            }
        }while(!exit);
        System.out.println("Client has been edited successfully");
    } // END of Editing Client //

    public static ClientsInformation[] deleteClient(ClientsInformation[] clientList, Scanner cin) {
        boolean isFull = true;
        for (ClientsInformation cl : clientList) {
            if (cl == null) {
                isFull = false;
                break;
            }
        }
        if (isFull) {
            System.out.print("Which Client in the list from 1 - "+ (clientList.length)+ " will be deleted? ");
            int clientID = cin.nextInt();
            ClientsInformation[] newClientList = new ClientsInformation[clientList.length - 1];
            for (int i = 0; i < clientList. length; i++) {
                if(i+1 != clientID) {
                    newClientList[i] = clientList[i];
                }
                else{
                    newClientList[clientID] = null;
                }
            }
            clientList = newClientList;
            System.out.println("Vehicle has been deleted from the database.");
        }
        return clientList;
    }// END

    public static void leaseAVehicle(ClientsInformation[] clientList, Vehicle[] vehicles, Scanner cin){
        System.out.print("Enter the client's name: ");
        String clientName = cin.nextLine();
        System.out.print("Enter the vehicle's plate number: ");
        String plateNumber = cin.nextLine();

        ClientsInformation client = null;
        for (ClientsInformation cl : clientList) {
            if (cl != null && cl.getName().equalsIgnoreCase(clientName)) {
                client = cl;
                break;
            }
        }

        Vehicle vehicle = null;
        for (Vehicle vh : vehicles) {
            if (vh != null && vh.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                vehicle = vh;
                break;
            }
        }

        if (client != null && vehicle != null) {
            System.out.println("Vehicle leased to client successfully.");
        } else {
            System.out.println("Client or vehicle not found.");
        }
    } // END of leaseAVehicle

    public static void returnAVehicle(ClientsInformation[] clientList, Vehicle[] vehicles, Scanner cin){
        System.out.print("Enter the client's name: ");
        String clientName = cin.nextLine();
        System.out.print("Enter the vehicle's plate number: ");
        String plateNumber = cin.nextLine();

        ClientsInformation client = null;
        for (ClientsInformation cl : clientList) {
            if (cl != null && cl.getName().equalsIgnoreCase(clientName)) {
                client = cl;
                break;
            }
        }

        Vehicle vehicle = null;
        for (Vehicle vh : vehicles) {
            if (vh != null && vh.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                vehicle = vh;
                break;
            }
        }

        if (client != null && vehicle != null) {
            System.out.println("Vehicle returned from client successfully.");
        } else {
            System.out.println("Client or vehicle not found.");
        }
    } // END of Return a Vehicle //

    // Assuming ClientsInformation class has getLeasedVehicles() and getName() methods
    public static void showLeasedByClient(ClientsInformation[] clientList, Scanner cin) {
        System.out.print("Enter the client's name: ");
        String clientName = cin.nextLine();
        ClientsInformation client = null;

        for (ClientsInformation cl : clientList) {
            if (cl != null && cl.getName().equalsIgnoreCase(clientName)) {
                client = cl;
                break;
            }
        }

        if (client != null) {
            System.out.println("Vehicles leased by " + client.getName() + ":");
            Vehicle[] leasedVehicles = client.getLeasedVehicles();
            if (leasedVehicles != null && leasedVehicles.length > 0) {
                for (Vehicle vehicle : leasedVehicles) {
                    System.out.println(vehicle + "\n");
                }
            } else {
                System.out.println("No vehicles leased.");
            }
        } else {
            System.out.println("Client not found.");
        }
    }

    public static void showLeasedByAll(ClientsInformation[] clientList) {
        System.out.println("All leased vehicles:");

        for (ClientsInformation client : clientList) {
            if (client != null) {
                Vehicle[] leasedVehicles = client.getLeasedVehicles();
                if (leasedVehicles != null && leasedVehicles.length > 0) {
                    System.out.println("Client: " + client.getName());
                    for (Vehicle vehicle : leasedVehicles) {
                        System.out.println(vehicle + "\n");
                    }
                }
            }
        }
    }



    public static void getLargestTruck(Vehicle[] vehicles){
        Truck largestTruck = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (largestTruck == null || truck.getMaxCarryWeight() > largestTruck.getMaxCarryWeight()) {
                    largestTruck = truck;
                }
            }
        }
        if (largestTruck != null) {
            System.out.println("The truck with the largest capacity is: " + largestTruck);
        } else {
            System.out.println("No trucks found in the database.");
        }
    } // END of getLargestTruck

    public static void copyElectricTrucks(Vehicle[] vehicles) {
        int electricTruckCount = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricTruck) {
                electricTruckCount++;
            }
        }

        ElectricTruck[] electricTrucks = new ElectricTruck[electricTruckCount];
        int index = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricTruck) {
                electricTrucks[index++] = (ElectricTruck) vehicle;
            }
        }

        System.out.println("Copied Electric Trucks:");
        for (ElectricTruck truck : electricTrucks) {
            System.out.println(truck);
        }
    } // END of copyElectricTrucks

    public static Vehicle[] inputForVehicle(Vehicle[] vehicles, Scanner cin) {
        System.out.print("Is The Vehicle a Car or Truck: "); // Determine vehicle type
        String vehicleType = cin.next();
        cin.nextLine();
        System.out.print("Does the vehicle use Electric or Gas/Diesel: "); // Determine fuel type
        String vehicleCategory = cin.next();
        cin.nextLine();
        System.out.print("What is the make of the Vehicle: ");
        String make = cin.nextLine();

        System.out.print("What is the model of the Vehicle: ");
        String model = cin.nextLine();

        System.out.print("What is the year of the Vehicle: ");
        int year = cin.nextInt();
        if (vehicleType.equalsIgnoreCase("truck") && vehicleCategory.equalsIgnoreCase("electric")) { // Electric Truck //
            System.out.print("What is the Maximum Carry load of the Truck in Kilograms: ");
            int maximumCarryLoad = cin.nextInt();

            System.out.print("What is the Autonomy Range in Kilometers of the Truck: ");
            int autonomyRange = cin.nextInt();

            vehicles[vehicles.length - 1] = new ElectricTruck(make, model, year, vehicleType, vehicleCategory, maximumCarryLoad, autonomyRange);
        } else if (vehicleType.equalsIgnoreCase("truck") && vehicleCategory.equalsIgnoreCase("diesel")) { // Diesel Truck //
            System.out.print("What is the Maximum Carry load of the Truck in Kilograms: ");
            int maximumCarryLoad = cin.nextInt();

            System.out.print("What is the Fuel Capacity in Liters: ");
            int fuelCapacity = cin.nextInt();

            vehicles[vehicles.length - 1] = new DieselTruck(make, model, year, vehicleType, vehicleCategory, maximumCarryLoad, fuelCapacity);
        } else if (vehicleType.equalsIgnoreCase("car") && vehicleCategory.equalsIgnoreCase("electric")) { // Electric Car //
            System.out.print("What is the maximum number of passengers of the Car: ");
            int maximumNumberOfPassengers = cin.nextInt();

            System.out.print("What is the Max Autonomy Range in Kilometers of the Car: ");
            int autonomyRange = cin.nextInt();

            vehicles[vehicles.length - 1] = new ElectricCar(make, model, year, vehicleType, vehicleCategory, maximumNumberOfPassengers, autonomyRange);
        } else if (vehicleType.equalsIgnoreCase("car") &&
                (vehicleCategory.equalsIgnoreCase("gas") || vehicleCategory.equalsIgnoreCase("diesel"))) { // Gasoline Car //
            System.out.print("What is the maximum number of passengers of the Car: ");
            int maximumNumberOfPassengers = cin.nextInt();
            vehicles[vehicles.length - 1] = new GasolineCars(make, model, year, vehicleType, vehicleCategory, maximumNumberOfPassengers);
        }
        return vehicles;
    } // END of input Vehicle Method //

    public static ClientsInformation[] inputClientInfo(ClientsInformation[] clientsList, Scanner cin) {
        // Check for available slot in the clientsList or resize if needed
        int index = -1;
        for (int i = 0; i < clientsList.length; i++) {
            if (clientsList[i] == null) {
                index = i;
                break;
            }
        }

        // If no space is available, resize the array
        if (index == -1) {
            clientsList = resizeArray(clientsList);
            index = clientsList.length - 1; // The last index of the resized array
        }

        // Collect client information
        System.out.println("Enter First and Last Name of Client");
        String fullName = cin.nextLine();
        cin.nextLine();
        System.out.println("Enter the age of the Client");
        int age = cin.nextInt();

        System.out.println("Enter the credit score of the Client");
        int creditScore = cin.nextInt();

        cin.nextLine(); // Consume the newline left by nextInt()

        System.out.println("Enter the email of the Client");
        String email = cin.nextLine();

        // Collect leased vehicle information (if needed)
        System.out.println("Does the client have any leased vehicles? (yes/no)");
        String hasLeasedVehicles = cin.nextLine();
        LeasedVehicle[] leasedVehicles = new LeasedVehicle[0]; // Default no leased vehicles

        if (hasLeasedVehicles.equalsIgnoreCase("yes")) {
            // Handle leased vehicles input
            System.out.println("How many leased vehicles?");
            int leasedCount = cin.nextInt();
            cin.nextLine(); // Consume newline after number input

            leasedVehicles = new LeasedVehicle[leasedCount];

            for (int i = 0; i < leasedCount; i++) {
                System.out.println("Enter leased vehicle " + (i + 1) + " details:");

                System.out.println("Enter make of the leased vehicle:");
                String make = cin.nextLine();
                cin.nextLine();
                System.out.println("Enter model of the leased vehicle:");
                String model = cin.nextLine();
                cin.nextLine();
                System.out.println("Enter year of production of the leased vehicle:");
                int year = cin.nextInt();
                cin.nextLine(); // Consume newline after integer input

                System.out.println("Enter the type of the leased vehicle:");
                String type = cin.nextLine();
                System.out.println("Enter the category of the leased vehicle:");
                String category = cin.nextLine();
                System.out.println("Enter the lease start date:");
                String leaseStartDate = cin.nextLine();
                System.out.println("Enter the lease end date:");
                String leaseEndDate = cin.nextLine();

                leasedVehicles[i] = new LeasedVehicle(make, model, year, type, category, leaseStartDate, leaseEndDate);
            }
        }

        // Create and assign the new client with their leased vehicles
        clientsList[index] = new ClientsInformation(fullName, age, creditScore, email, leasedVehicles);

        // Return the updated list
        return clientsList;
    }

    // Helper method to resize the array when it's full
    public static ClientsInformation[] resizeArray(ClientsInformation[] originalArray) {
        ClientsInformation[] newArray = new ClientsInformation[originalArray.length + 1]; // Increase size by 1
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        return newArray;
    }



}// END OF Driver Class //