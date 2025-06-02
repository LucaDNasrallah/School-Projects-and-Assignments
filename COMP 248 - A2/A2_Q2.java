// ---------------------------------------------------------
// Assignment 2
// Written by: Luca Nasrallah - 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------


import java.util.Scanner;


public class A2_Q2
{
	public static void main(String[] args) 
	{
		Scanner cout = new Scanner(System.in);
		System.out.println("Welcome to the Montreal Currency Exchange!\n");
		
		
		//Declaring all Strings for Choice and The type of currency going to be used
		// Declaring all Doubles storing either the expected amount, the amount selling or buying of CAD
		String choice, currencyType;
		double purchasing, amount, receive;
		
		System.out.print("Do you want to buy foreign Currency (B) or Sell sell foreign currency (S): "); // User Input  for buying or Selling
		choice = cout.nextLine(); 
		
		if(choice.equalsIgnoreCase("b")) // Start of If statement for Buying
		{
			System.out.print("Enter the Currency you want to buy (USD, EUR, GBP, JPY, AUD): ");
			currencyType = cout.nextLine();
			currencyType = currencyType.toLowerCase(); // Making LowerCase for simplicity.
			
			//All the cases and their prompts for the Purchasing of Currency.
			//Each have the buying conversion rates from CAD to the currencyType chosen by the User. 
			//Each Case has a prompts the user for how much they want to Buy in that Currency Type.
			//Finally Displays the amount of CAD needed to Buy that Currency Type. 
			switch(currencyType) 
			{
			case "usd":
				System.out.println("Please enter in the amount of USD you want to buy: ");
				purchasing = cout.nextDouble();
				amount  = purchasing * 1.30;
				System.out.println("You need to spend "+ amount + " CAD to receive " + purchasing +" USD");
				break;
			case "eur":
				System.out.println("Please enter in the amount of EUR you want to buy: ");
				purchasing = cout.nextDouble();
				amount = purchasing * 1.55;
				System.out.println("You need to spend "+ amount + " CAD to receive " + purchasing + " EUR");
				break;
			case "gbp":
				System.out.println("Please enter in the amount of GBP you want to buy: ");
				purchasing = cout.nextDouble();
				amount  = purchasing * 1.80;
				System.out.println("You need to spend "+ amount + " CAD to receive " + purchasing +" GBP");
				break;
			case "jpy":
				System.out.println("Please enter in the amount of JPY you want to buy: ");
				purchasing = cout.nextDouble();
				amount = purchasing * 0.0012;
				System.out.println("You need to spend "+ amount + " CAD to receive " + purchasing + " JPY");
				break;
			case "aud":
				System.out.println("Please enter in the amount of AUD you want to buy: ");
				purchasing = cout.nextDouble();
				amount = purchasing * 1.00;
				System.out.println("You need to spend "+ amount + " CAD to receive " + purchasing + " AUD");
				break;
			} // End of Switch Function
			System.out.println("Thank you for using the Canadian Currency Exchange Program. Feel free to come again :)"); // Ending Statement
		} // End of If function for buying 
		else if(choice.equalsIgnoreCase("s"))
		{
			//Prompting the user for how much CAD they want to receive, and giving the choice for the type of currency they want to sell into Canadian. 
			System.out.print("Enter the CAD amount you would like to receive: ");
			receive = cout.nextDouble();
			System.out.print("Enter the target currency to sell (USD,EUR,GBP,JPY,AUD)");
			currencyType = cout.next();
			currencyType = currencyType.toLowerCase();// Making LowerCase for simplicity.
			
			
			// All the cases and their prompts for the Selling for Currency 
			// Each have the Selling conversion rates from CAD to the currencyType. 
			switch(currencyType)
			{ 
			case "usd":
				amount  = receive / 1.25;
				System.out.println("You need to spend "+ amount + " USD to receive " + receive + " CAD");
				
				break;
			
			case "eur":
				amount  = receive / 1.50;
				System.out.println("You need to spend "+ amount + " EUR to receive " + receive + " CAD");
				break;
			case "gbp":
				amount  = receive / 1.75;
				System.out.println("You need to spend "+ amount + " GBP to receive " + receive + " CAD");
				break;
			
			case "jpy":
				amount  = receive / 0.01;
				System.out.println("You need to spend "+ amount + " JPY to receive " + receive + " CAD");
				break;
			
			case "aud":
				amount  = receive / 0.95;
				System.out.println("You need to spend "+ amount + " AUD to receive " + receive + " CAD");
				break;	
			} // End Of Switch Function
			System.out.println("Thank you for using the Canadian Currency Exchange Program. Feel free to come again :)"); // Ending Statement
		} // End of If Statement for Selling
		else // Start of ERROR Input
		{
			System.out.println("The Current Input is INVALID, since neither Buying (B) or Selling (S). Please restart the program. Thank You!");
		
		} // End of INVALID Input
		
		cout.close();
		
	}// End of Public Static Void Main
} // Final Closing Bracket
