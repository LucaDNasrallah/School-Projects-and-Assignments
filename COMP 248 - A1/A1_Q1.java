// ---------------------------------------------------------
// Assignment 1_ Question 1
// Written by: Luca Nasrallah ID: 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------



import java.util.Scanner;

public class A1_Q1 {

	public static void main(String[] args)
	{
		//Scanner Implementation
		Scanner myKey = new Scanner(System.in);
	
		
		// Printing a salutations header for The program
		System.out.println("Welcome to Algorithm 1: Solar Roof Energy Calculator");
		
		// Declaration for inputed int for the number of solar panels.
		System.out.print("Input the number of whole digit Solar Panels: ");
		int numPanels = myKey.nextInt();
		
		// Declaration for inputed int of wattage ratings.
		System.out.print("Input the number of whole digit Wattage Rating of each solar panel: ");
		int panelWattage = myKey.nextInt();
		
		//Declaration for inputed double for the number of sunlight hours per day.
		System.out.print("Input the average number of sunlight hours per day: ");
		double sunLightHours = myKey.nextDouble();
		
		//Declaration for inputed double for the percentage efficiency as a whole number of the solar panels. 
		System.out.print("Input the effiency of the solar Panels as a percentage: ");
		double efficiency = myKey.nextDouble();
		
		// Declaring calculation variables.
		double dailyEnergy, annualEnergy;
		
		//Calculation of Daily Energy from inputed Values.
		dailyEnergy = (numPanels*panelWattage*sunLightHours*efficiency)/ (100000);
		
		//Calculation for Annual Energy from the value of Daily Energy.
		annualEnergy = 365*dailyEnergy;
		
		//Console Output Information about Daily and Annual Energy
		System.out.println("\nDaily Energy Production Amount is: "+ dailyEnergy + " kWh");
		System.out.println("Annual Energy Production Amount is: "+ annualEnergy+ " kWh");
		
		//Exiting Message
		System.out.println("\nThank you for using the Solar Panel Roof Energy Calculator. Come back soon! ");
		myKey.close(); // Closing Scanner
		//:)
	} 

}
