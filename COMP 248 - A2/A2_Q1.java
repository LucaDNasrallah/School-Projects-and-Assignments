// ---------------------------------------------------------
// Assignment 2
// Written by: Luca Nasrallah - 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;

public class A2_Q1 {

	public static void main(String[] args) 
	{
		int temp; // Temperature outside 
		String storedString; // Stored String Relates to if its Snowy, Raining or Sunny 
		Scanner cout = new Scanner(System.in);
		System.out.println("Welcome to the Fall Adventure Weather Planner. Lets get started!");
		System.out.print("Please input a Value for the temperature outside: ");
		temp = cout.nextInt(); //User Input for the Temperature of the environment  
		System.out.print("Please input whether or not it is Sunny, rainy or Snowy outside: ");
		storedString = cout.next(); // User Input for whether it is Sunny, Raining or Snowing. 
		
		if(storedString.equalsIgnoreCase("snowy"))
		{
			System.out.println("Recomneded Clothing: Heavy Winter Clothing."); // The recommended clothing for when it is Snowing and the Tips. 
			System.out.println("Stay warm and watch out for Icy Conditions.");
			System.out.print("Thank you for using the Fall Weather Planner Program, have yourself a great day :)");
		}

		else if(storedString.equalsIgnoreCase("rainy"))
		{
			System.out.println("Recomeneded Clothing: Water Proof Clothing. "); // The recommended clothing for when it is Raining and the Tips. 
			System.out.println("Safety tip: Be cautious of puddles and slippery patches!");
			System.out.print("Thank you for using the Fall Weather Planner Program, have yourself a great day :)");
		}
		else if(storedString.equalsIgnoreCase("sunny")) // The Recommended Clothing for when it is sunny and the different conditions Depending the temperature. 
		{
			if(temp > 20) // Temperature when above 20 degrees.
			{
				System.out.println("Recomended clothing: Light Clothing (exmaple: shorts, T-shirt, tanktops.");
			}
			else if (temp >= 10 && temp <= 20) // The Temperature when between 10 and 20 degrees.
			{
				System.out.println("Recomended Clothing: Light Jacket or Hoodie");
			}
			else if(temp  < 10 ) // The temperature when below 10 degrees. 
			{
				System.out.println("Recommeded Clothing: Warm and thicker clothing with a Jacket.");
			}
			// When its Sunny Tip // 
			System.out.println("Safety tip: Don't forget to wear sunscreen and stay hydrated!");
			System.out.print("Thank you for using the Fall Weather Planner Program, have yourself a great day :)");
		
		}// End of if statement for Sunny
		else
		{
			System.out.println("The Input is INVALID, please restart the program and try again. Thank you!");
		}
		
		cout.close();
	}

}
