// ---------------------------------------------------------
// Assignment 3
// Written by: Luca Nasrallah - 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;

public class A3_Q1 
{
	public static void main(String[] args)
	{
		// Declaring variables 
		Scanner cin = new Scanner(System.in);
		int displayMenuChoice = 0; 
		double storedBalance = 0; 
		final double MAX_DEPOSIT = 100000, MIN_VALUE = 5, MAX_WITHDRAWAL = 1000;
		double inputAmount;
		boolean exit = false; 		
		
		/* The purpose of this program is to allow a user to deposit, withdraw money and check	
		the current balance of their account of a ATM machine. There is going to be a constant loop for the user
		to cycle through allowing them to deposit, withdrawal and check the balance of their account as may times
		as they want too until they are ready to exit. Once they're ready to exit.*/
		
		
		System.out.println("Welcome to Concordia Virtual ATM service.");
		do
		{	
			System.out.println("-----------------------------------------");
			System.out.print("Please Choose and option:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit\nEnter your choice: "); // Printing Display menu
			displayMenuChoice = cin.nextInt();
			
			if(displayMenuChoice >= 1 && displayMenuChoice <= 3) // Cases from the display Menu.
			{
				switch(displayMenuChoice)
				{
					case 1: // Checking the balance of the person.  
						System.out.println("Currrent balance is: " + String.format("%.2f", storedBalance) + "$");
						break;
						
					case 2:
						do
						{
							System.out.println("Enter the amount you want to deposit: ");
							inputAmount = cin.nextDouble();
							
							// Beginning of the IF FUNCTIONS (CONTRAINTS LIMITING THE ABILITY TO CONTINUE.)
							if(inputAmount < MIN_VALUE || inputAmount > MAX_DEPOSIT) // When greater than 10000, less than 5.
							{
								System.out.println("The Input amount is INVALID, not between 5.00$ and 10,000.00$"); 
								exit = false;
							}
							else if(inputAmount % 5  != 0 )
							{
								System.out.println("The Input amount is INVALID, was not multiple of 5, 10, 50, or 100");
								exit = false; 
							}
							else
							{
								storedBalance += inputAmount ;
								System.out.println("Deposit Successful!");
								exit = true;
							}
						} while(exit == false);// End of Do - While function for Case 2. 
						break;
					
					case 3:
						do
						{
							
							System.out.println("Enter amount to withdraw (multiples of 5, 10, 50, or 100): ");
							inputAmount = cin.nextDouble(); // Prompt for user to choose how much they want to take out of their account.
							double withdrawalBalance = storedBalance - inputAmount; 
							// Beginning of the IF FUNCTIONS (CONTRAINTS LIMITING THE ABILITY TO CONINUE.) 
							if(inputAmount < MIN_VALUE && inputAmount > MAX_WITHDRAWAL) // When greater than 10000, less than 5.
							{
								System.out.print("The withdrawal amount is INVALID, not between 5.00$ and 1,000$");
								exit = false;
							}
							else if(inputAmount % 5  != 0 ) // If it is not a multiple of 5 in any way. 
							{
								System.out.println("The withdrawal amount is INVALID, was not multiple of 5, 10, 50, or 100");
								exit = false;
							}
							else // If There is not errors with value for the input.
							{
								if(storedBalance - inputAmount < 0) // If function if Final Withdrawal is under zero.
								{
									System.out.println("There is insufficient funds inside your account to withdrawal such amount. Please try again.");
									exit = false; 
								}
								else // When there is going to be no errors with taking money out of the account. 
								{
									System.out.println("You will receive:");
									 // Calculating the number of bills
							        int fiftyBills = (int)inputAmount / 50;
							        inputAmount %= 50; // Update amount to the remainder after 50 bills
								    int tenBills = (int)inputAmount / 10;
								    inputAmount %= 10; // Update amount to the remainder after 10 bills
								    int fiveBills = (int)inputAmount / 5;
								    inputAmount %= 5; // Update amount to the remainder after 5 bills

								    // Display the results
								    System.out.println("Number of 50.00$ bills: [" + fiftyBills + "]");
								    System.out.println("Number of 10.00$ bills: [" + tenBills +"]");
								    System.out.println("Number of 5.00$ bills: [" + fiveBills + "]");
								    System.out.println("Withdraw Sucessfull!");
				
								    storedBalance = withdrawalBalance; 
								    System.out.println("Withdrawal Sucessful!");
								    exit = true;  
								}
							} 
						}while( exit == false); // End of Case 3 while function.
					}		
				}// End of Switch Function.				
			else if(displayMenuChoice >4) // INVALID INPUT
			{
				System.out.println("The Input for the display Menu is INVALID, please try again.");
			}
			
		} // End of 'do' while  function. 
		while(displayMenuChoice != 4); 
		System.out.println("-----------------------------------------");
		System.out.print("Thank you for using the Concordia Virtual ATM Service. Have a great day! :)"); // Exit Message
	cin.close(); 
	} // End of Main function.
}// End of Whole Program. 	
