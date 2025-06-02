// ---------------------------------------------------------
// Assignment 3
// Written by: Luca Nasrallah - 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner; 
public class A3_Q2 {

	public static void main(String[] args)
	{ // Start of Program
		
		Scanner cin = new Scanner(System.in);
		
		
		// Declaring Variables and Array with there sizes. 
		int displayMenu = 0 , choice = 0 ;
		final int ARRAY_SIZE = 5;
		boolean exit = false; 
		String searchWord;
		
		String[] products = new String[ARRAY_SIZE]; // Declaring all the Arrays with there respective Sizes
		double[] prices = new double[ARRAY_SIZE];
		int[] quantity = new int[ARRAY_SIZE];
		System.out.println("Welcome to the Product Management System Program. Lets begin");
		System.out.println("Enter the details of 5 products where the (Price, Quantity, Name) will be used:"
				+"\n------------------------------------------------------------------------");
		for (int i = 0 ; i < ARRAY_SIZE; i++)
		{
			System.out.print("Product " + (i+1) + ":" + "\nEnter Product Details (Example: 10.00 40 Name of the product): ");
			prices[i] = cin.nextDouble() ;
			quantity[i] = cin.nextInt();
			products[i] = cin.nextLine();	 // Prompting the user to input the values that will store in each par of the array.
		}
		do // Beginning of Reading the 5 Products
		{
			exit = false; 
			System.out.println("-----------------------------------------");
			System.out.println("Inventory Management Menu: (Input Choice between 1 and 6)"
					+ "\n1. Display Information of all Products.\n2. Update the quantity of a product."
					+ "\n3. Search for a product by name.\n4. Find the product with the lowest quantity."
					+ "\n5. Find the product with the highest price."
					+ "\n6. Exit.");
			choice = cin.nextInt(); // Input for the CHOICE.
			
			if(choice < 1 || choice > 6) // If the Value for the choice is out of bounds from 1 to 6. 
			{
				System.out.println("This is an invalid Input, please try again.");
				exit = false;
			} // end of IF statement
			else if(choice == 6) // Exit value if The input for the choice is 6. 
			{
				exit = true; 
			} // END of IF ELSE statement. 
			else 
			{
				switch(choice) // Choices between 1 and 6 to access different functions. 
				{
				case 1: // Case for the display information of all products.
					System.out.println("Product List: ");
					for(int j = 0 ; j < ARRAY_SIZE ; j++)
					{
						System.out.println("--------------------------------------"
							+"\nName: "+ products[j]
							+"\nPrice: " + String.format("%.2f", prices[j] ) + "$" // Rounding the decimal to two deimcal points. 
							+"\nQuantity: " + quantity[j]);
						
					}
					exit = false; 
					break;
					
				case 2: // Case Updating the quantity of a product.	
					do
					{
						System.out.println("Enter the product number (1-5) to update the quantity");
						int productNumber = cin.nextInt();
						if(productNumber >= 1 && productNumber <= 5) // When the choice is between 1 and 5.
						{
							System.out.println("Enter new quantity for Product ["+ products[productNumber-1] + "]: " );
							int quantityChange = cin.nextInt();
							if(quantityChange  >= 0 ) // Condition if quantity is all positive integers. 
							{
								quantity[productNumber-1] = quantityChange; 
								System.out.println("Quantity updated successfully!");
								exit = true;
							}
							else // ELSE statement when the input is anything lower than the value of 0. 
							{
								System.out.println("The Value inputed is INVALID, please try again.");
								exit = false; 
							}
						} // END of main IF function.
						else // ELSE statement when input is anything but the main constraints 
						{
							System.out.println("The input is INVALID, please try again.");
							exit = false; 
						} // END of else statement
						
					} while(exit == false); // End of the DO function
					exit = false; 
					break;
					
				case 3: // Case for searching for a product name.
					boolean found = false; 
					cin.nextLine();
					do {
						System.out.println("Enter the name of the product to search for: ");
				        searchWord = cin.nextLine(); // Prompt user for search term once
				        
				        for (int i = 0; i < products.length; i++) 
				        { // This loop goes through each index of the products array, and checks if the search word String is 
				        	// equal to any of the index.
				            if (products[i].equalsIgnoreCase(searchWord)) 
				            { // Case-insensitive comparison
				                System.out.println("Name: " + products[i] 
				                                   + "\nPrice: " + String.format("%.2f",prices[i]) + "$"
				                                   + "\nQuantity: " + quantity[i]);
				               exit = true;
				               found =true;
				            }// END of IF function  determining if the INPUT is the same as an index of the products Array.
				        }// END of FOR loop
				        if(found == false) // If the string inputed doesn't exist in the array. 
			            {
				            System.out.println("Product not found. Please Try again"
				            		+"\n-----------------------------------");
				            exit = false;
			            }
				    } while (exit == false); // END of case 3
					exit = false;  // Returning boolean for main DO-WHILE function. 
				    break;
				    
				case 4: // Case for finding the product with the lowest quantity.
					int min = 0;
						for( int i = 0 ; i <quantity.length ; i++)
						{
							if(quantity[i] < quantity[min]) // if the quantity of index i is less than what is saved as the 
							{								// lowest quantity, then, that index will become the new Minimum.
								min = i;
							}
						}
						System.out.println("Product with the Lowest Quantity" // Printing the values contained in the product
								+ "\n    Name: " + products[min]			  // with the lowest quantity
								+ "\n    Price: " + String.format("%.2f",prices[min])+"$"
								+ "\n    Quantities: " + quantity[min]);
						exit = false;
					break;
				case 5: // Case for finding the product with the highest Price. 
					int max = 0;
					for(int i = 0 ; i <prices.length ; i++)
					{
						if(prices[i] > prices[max]) // if the price of index i is greater then what is saved as the 
						{							// highest price, then, that index will become the new Max.
							max = i;
						}
					}
					System.out.println("Product with the Highest Price: " // Printing the values contained in the highest 
							+ "\n    Name: " + products[max]			  // priced product. 
							+ "\n    Price: " + String.format("%.2f",prices[max])+"$"
							+ "\n    Quantities: " + quantity[max]);
					exit = false; 
					break;	 // END of Case 5
				} // END of SWITCH method.
			} // END of ELSE  statement. 
		}while(exit == false); //END of main DO-WHILE function. 
		System.out.println("-----------------------------------------");
		System.out.println("Thank you for using the most amazing product Inventory Management program that you have ever see. Have a great day!");// :)
				
		cin.close(); // Closing Scanner
	}//End of Main Function
} // End of Program