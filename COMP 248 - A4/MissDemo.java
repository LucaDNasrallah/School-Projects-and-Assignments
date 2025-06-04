// ---------------------------------------------------------
// Assignment 4
// Written by: Luca Nasrallah ID: 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------


import java.util.Scanner;
public class MissDemo {
	
	/*The purpose of the Montreal Intercampuses Shipping Service (MISS) application is 
	to provide a user-friendly interface for managing shipping registries across multiple campuses. 
	The application allows users to perform various operations on shipping registries, such as viewing their 
	contents, comparing them based on stamps or labels, and managing labels and stamps. By leveraging classes 
	like Registry and Label, it enables features like adding or removing labels, updating expiry dates, and 
	identifying registries with similar characteristics. This program enhances organization and efficiency 
	in managing shipping-related data, while the interactive menu system ensures ease of use for operators.*/
	
	public static void main(String[] args) {

	
		Scanner cin = new Scanner(System.in);  
		int choice; 
		System.out.println(
				"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
			   +"|        Welcome to Montreal Intercampuses Shipping Service(MISS©) Application         |\n"
			   +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Registry[] registries = initializeRegistries();
		do {
			  menuDisplayMethod();
			  

	            choice = cin.nextInt();
	            if(choice < 0 || choice > 9 )
	            {
	            	System.out.println(""
							+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
							+"|                Sorry this is not a valid input. Please try again.                    |");	            }
	            else
	            {
	            	switch (choice) {
	                case 1:
	                    displayAllRegistries(registries);
	                    break;
	                case 2:
	                    displaySingleRegistry(registries, cin);
	                    break;
	                case 3:
	                    compareRegistriesByTotalValue(registries);
	                    break;
	                case 4:
	                    compareRegistriesByStampDistribution(registries);
	                    break;
	                case 5:
	                    listEqualRegistries(registries);
	                    break;
	                case 6:
	                    addLabelToRegistry(registries, cin);
	                    break;
	                case 7:
	                    removeLabelFromRegistry(registries, cin);
	                    break;
	                case 8:
	                    updateLabelExpiry(registries,  cin);
	                    break;
	                case 9:
	                    addStampsToRegistry(registries, cin);
	                    break;
	                case 0:
	                    System.out.println("Thank you for using Montreal Intercampuses Shippiung Service(MISS©) Application!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    }
	            	}
	        } while (choice != 0);
	    }
			 // Initialize Registries as specified
			private static Registry[] initializeRegistries() {
				Registry[] registries = new Registry[5]; 
				
				Registry registry1 = new Registry(); // Registry 0 // 
				registry1.addLabel(new Label("Standard",9800000, 8,2));
				registry1.addLabel(new Label("Oversize",9800001, 12,2));
				registry1.addingStamps(1, 2, 3, 4, 5);
				registries[0] = registry1;
				
				Registry registry2 = new Registry(); // Registry 1 // 
				registry2.addLabel(new Label("Oversize",9800002, 8,2));
				registry2.addLabel(new Label("Express",9800003, 28,2));
				registry2.addingStamps(1,2,3,4,5);
				registries[1] = registry2;
				
				Registry registry3 = new Registry(); // Registry 2 // 
				registry3.addLabel(new Label("Small", 9800004, 10, 12));
				registry3.addLabel(new Label("Oversize", 9800005, 11,12));
				registry3.addLabel(new Label("Fragile" , 9800006, 12,12)); 
				registry3.addingStamps(1,0,0,0,10);
				registries[2] = registry3;
				
				Registry registry4 = new Registry(); // Registry 3 // 
				registry4.addingStamps(5,4,3, 2, 1);
				registries[3] = registry4;

				Registry registry5 = new Registry();
				registry5.addingStamps(5, 4, 3, 2, 1);
				registries[4] = registry5; 
				return registries; 
			}
	
	// Menu Display Method //
	private static void menuDisplayMethod(){
		System.out.print(
			    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
			   +"| What would you like to do:                                                           |\n"
			   +"| 1 >> See the content of all Registries.                                              |\n"
			   +"| 2 >> See the content of one Registry.                                                |\n"
			   +"| 3 >> List Registries with same $ amount of shipment Stamps.                          |\n"
			   +"| 4 >> List Registries with same number of shipment Stamps types.                      |\n"
			   +"| 5 >> List Registries with same $ amount of Stamps and the number of Prepaid labels.  |\n"
			   +"| 6 >> Add a prepaid label to an existing Registry.                                    |\n"
			   +"| 7 >> Remove an existing prepaid label from a Registry.                               |\n"
			   +"| 8 >> Update the expiry date of an existing prepaid label.                            |\n"
			   +"| 9 >> Add stamps to a Registry.                                                       |\n"
			   +"| 0 >> Exit.                                                                           |\n"
			   +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
			   + "Enter your choice here and press <Enter>: ");
	} // END of Menu Display Method //  

	// Display all the Registries Method // -- 1 [VERIFIED]
	private static void displayAllRegistries(Registry[] registries) {
		for(int i = 0 ;  i < registries.length ; i++)
		{
			System.out.println("Registry " + (i) + "\n" + registries[i]);
		}
	} // END of Displaying all Registries // 
	
	// Display a Single Registry //  -- 2 [VERIFIED]
	private static void displaySingleRegistry(Registry[] registries , Scanner cin) {
		boolean exit = false;
		do
		{
			System.out.print("Enter the Registry Number (1-" + registries.length + "): " );
			int registryIndex = cin.nextInt()-1; 
			
			if(registryIndex >= 0 && registryIndex < registries.length)
			{
				System.out.println(
						"------------------------------\n"
						+"Registry " + (registryIndex + 1) + ":\n" + registries[registryIndex]);
				exit = true;
			}
			else
			{
				System.out.println("# INVALID Registry Number, Please Try again. #"
						+"\n--------------------------------------------");
				exit= false; 
			}
		}while(exit==false);
	} // END of Displaying Single Registry. // 
	
	// Comparing Registries by their total amount of value of Stamps. //  -- 3 [VERIFIED]
	private static void compareRegistriesByTotalValue(Registry[] registries)
	{
		System.out.println("List of Registries with same total $ Stamps:\n");
		for(int i=0 ; i < registries.length ; i++)
		{
			for( int j = i + 1 ; j < registries.length ; j++)
			{
				if(registries[i].isTotalValueTrue(registries[j]))
				{
					System.out.println("\tRegistry " + (i+1) +  " and Registry " + (j+1) 
							+ " have the same total value of stamps: $" + registries[i].stamps.stampTotal());
				}
			}
		}
	} // END of the Comparing Registries Method // 
	
	// Comparing Registries by Stamp Distribution //  -- 4 [VERIFIED]
    private static void compareRegistriesByStampDistribution(Registry[] registries) {
        System.out.println("List of Registries with same Stamps categories:\n ");
    	for (int i = 0; i < registries.length; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].isStampDistributionEquals(registries[j])) {
                    System.out.println("\tRegistry " + (i + 1) + " and Registry " + (j + 1) +
                            " have the same stamp distribution.");
                }
            }
        }
    } // END of the Comparing Registries by Stamp Distribution  // 
    
    // Listing Equal Registries  // -- 5 [VERIFIED]
    private static void listEqualRegistries(Registry[] registries) {
        System.out.println("List of Registires with same $ amount of Stamps and same number of Labels:\n ");
    	for (int i = 0; i < registries.length; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].equals(registries[j])) {
                    System.out.println("\tRegistry " + (i + 1) + " and Registry " + (j + 1) + 
                                       " are equal based on stamps and labels.");
                }
            }
        }
    } // END of Checking equal Registries. // 

    //Making the first letter of ParcelType Capital in the output method // 
    public static String capitalizeFirstLetter(String word) { // This is just extra work to make the Method 6 more nice. // 
        if (word == null || word.isEmpty()) {
            return word; // Return the input if it's null or empty
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    
    // Adding a label to a Registry //  -- 6 [VERIFIED]
    private static void addLabelToRegistry(Registry[] registries, Scanner cin) {
    	boolean exit = false;
    	do
    	{
	    	System.out.print("Enter the Registry number (1-" + registries.length + ") or Enter ("+ (registries.length +1) + ") to exit back to menu:");
	        int registryIndex = 0;
	        registryIndex = cin.nextInt() - 1;
	        if(registryIndex == registries.length)
	        {
	        	exit = true;
	        }
	        else if (registryIndex >= 0 && registryIndex < registries.length && registryIndex != registries.length) {
	        	System.out.print(" --> Enter Parcel Type (Standard, Small, Oversize, Express, Fragile, Confidential): ");
	            cin.nextLine();
	        	String parcelType = cin.nextLine();
	            if(parcelType.equalsIgnoreCase("standard") || parcelType.equalsIgnoreCase("small") || parcelType.equalsIgnoreCase("oversize") || 
	            		parcelType.equalsIgnoreCase("express") || parcelType.equalsIgnoreCase("fragile") || parcelType.equalsIgnoreCase("confidential"))
	            {
	            	 // Capitalize the first letter
	                parcelType = capitalizeFirstLetter(parcelType);
	            	System.out.print("--> Enter Unit ID (8 digits starting with 98): ");
	                int unitID = cin.nextInt();
	                
	                if(unitID >=98000000 && unitID <= 98999999)
	                {
	                	 System.out.print("--> Enter Expiry Day (1-31): ");
	                     int expiryDay = cin.nextInt();
	                     if(expiryDay >= 1 && expiryDay <= 31)
	                     {
	                    	 System.out.print("--> Enter Expiry Month (1-12): ");
	                         int expiryMonth = cin.nextInt();
	                         if(expiryMonth >= 1 && expiryMonth <= 12)
	                         {
	                        	 Label newLabel = new Label(parcelType, unitID, expiryDay, expiryMonth);
	                             int updatedCount = registries[registryIndex].addLabel(newLabel);
	                             System.out.println("Label added! Registry " + (registryIndex + 1) + " now has " 
	                             + updatedCount + " labels.");
	                             exit = true; 
	                         }
	                         else
	                         {
	                        	 System.out.println("# This Day is INVALID. Please try again. #");
	                         }
	                     }
	                     else
	                     {
	                    	 System.out.println("# This Day is INVALID. Please try again. #");
	                     }
	                }
	                else
	                {
	                	System.out.println("# This ID is INVALID. Please try again. #");
	                }
	              
	            }
	            else
	            {
	            	System.out.println("# This Parcel input is INVALID, please try again. #");
	            }
	           
	        }
	        else 
	        {
	        	System.out.println("# Invalid Registry number. #");
	        }       
    	}while(exit == false);
    } // END of label to Registry // 
    
    
    // Removing label from a Registry // -- 7 [VERIFIED]
    private static void removeLabelFromRegistry(Registry[] registries, Scanner cin) 
    {
    	boolean exit=false; 
    	do
    	{
    	System.out.print("Enter the Registry number (1-" + registries.length + ") or Enter ("+ (registries.length +1) + ") to exit back to menu:");
        int registryIndex = cin.nextInt() - 1;
        if(registryIndex == registries.length)
        {
        	exit = true; 
        }
        else if (registryIndex >= 0 && registryIndex < registries.length && registryIndex != registries.length) 
        {
        	Registry selectedRegistry = registries[registryIndex]; // Get the selected registry
            int numberOfLabels = selectedRegistry.numberOfLabels(); // Get the number of labels in the registry
            if (numberOfLabels > 0)
            {
	                System.out.println("Registry " + (registryIndex + 1) + " has " + numberOfLabels + " label(s).");
	                System.out.print("Enter the label index to update (1-" + numberOfLabels + "): ");
	                int labelIndex = cin.nextInt() - 1; // Convert to 0-based index
	                if(labelIndex > numberOfLabels)
	                {
	                	System.out.println("The Current Label Number Does not exist. Please Try Again.");
	                }
	                else
	                {
	                	boolean success = registries[registryIndex].removeLabel(labelIndex);
	  		            if (success)
	  		            {
	  		                System.out.println("Label removed successfully from Registry " + (registryIndex + 1) + ".");
	  		                exit =true; 
	  		            }
	                }
            } 
            else
            {
            	System.out.print("This Registry Doesn't Contain any labels. Would you like to leave, type \"Yes\" or \"No\": " );
            	String yesOrNo = cin.next();
            	if(yesOrNo.equalsIgnoreCase("yes"))
            	{
            		exit = true;
            	}
            	else if(yesOrNo.equalsIgnoreCase("no")){
            		exit = false; 
            	}
            	else
            	{
            		System.out.println("# INVALID Input, Redirecting too Start ... #");
            	}
            }
        }
        else
        {
        	System.out.println("# Invalid Registry number. Please Try Again. #"
        			+ "\n-------------------------------------------");
        }
    	}while(exit == false);
    } // END of Removing a Label for a Registry // 
    
    
 // Updating label Expiry Date // -- 8 [VERIFIED] 
    private static void updateLabelExpiry(Registry[] registries, Scanner cin) {
    	
    	boolean exit = false; 
    	do{
	    	System.out.print("Enter the Registry number (1-" + registries.length + ") or Enter (" + (registries.length +1)+  ") to Exit back to Menu: "); //Option to leave // 
	        int registryIndex = cin.nextInt() - 1;
	
	        // Check if the registry index is valid
	        if (registryIndex >= 0 && registryIndex < registries.length && registryIndex != registries.length) 
	        {
	            Registry selectedRegistry = registries[registryIndex]; // Get the selected registry
	            int numberOfLabels = selectedRegistry.numberOfLabels(); // Get the number of labels in the registry
	
	            if (numberOfLabels > 0) 
	            {
	                System.out.println("Registry " + (registryIndex + 1) + " has " + numberOfLabels + " label(s).");
	                System.out.print("--> Enter the label index to update (1-" + numberOfLabels + "): ");
	                int labelIndex = cin.nextInt() - 1; // Convert to 0-based index
	
	                // Check if the label index is valid
	                if (labelIndex >= 0 && labelIndex < numberOfLabels) 
	                {
	                    System.out.print("--> Enter new Expiry Day (1-31): ");
	                    int newDay = cin.nextInt();
	                    if(newDay >=1 && newDay <= 31)
	                    {
	                    	
	                    
	
		                    System.out.print("Enter new Expiry Month (1-12): ");
		                    int newMonth = cin.nextInt();
		                    if(newMonth >=1 && newMonth <= 12)
		                    {
			                    selectedRegistry.updateExpiryDate(labelIndex, newDay, newMonth); // Call updateExpiryDate method
			
			                    System.out.println("Expiry date updated for Label " + (labelIndex + 1) + " in Registry " + (registryIndex + 1) + ".");
			                    exit = true;
		                    }
		                    else {
		                    	System.out.println("# This month date is INVALID, please Try again. #");
		                    }
	                    }
	                    else{
	                    	System.out.println("# This date is INVALID, please try again. #");
	                    }
	                }
	                else
	                {
	                    System.out.println("# Invalid label index. #"); // When there isn't a label that exist in the registry // 
	                }
	            } 
	            else 
	            {
	                System.out.println("Registry " + (registryIndex + 1) + " has no labels. Use Option 6 to add Prepaid Labels to a Registry.");
	            }
	        }
	        else if( registryIndex == registries.length)
	        {
	        	exit = true; 
	        }
	        else 
	        {
	            System.out.println("# Invalid Registry number. #"); // When Registry number is not in the range. // 
	        }
    	}while(exit == false);
    } // END of Updating Label Expiry Date
 
    
    
    // Adding Stamps to a Registry // -- 9 [VERIFIED]
    private static void addStampsToRegistry(Registry[] registries, Scanner cin) {
        boolean exit = false;
    	do
        {
    		System.out.print("Enter the Registry number (1-" + registries.length + ") or Enter (" + (registries.length +1)+  ") to Exit back to Menu: "); //Option to leave // 
	        int registryIndex = cin.nextInt() - 1;
	        if(registryIndex == registries.length)
	        {
	         exit = true;	
	        }
	        else if (registryIndex >= 0 && registryIndex < registries.length && registryIndex != registries.length) {
	        	System.out.println("How many category_A($2), category_B($5), category_AC$10), category_D($15), category_E($20) parcel stamps do you want to add.");
	        	
	        	System.out.print("Enter the number of Category A stamps to add: ");
	            int categoryA = cin.nextInt();
	
	            System.out.print("Enter the number of Category B stamps to add: ");
	            int categoryB = cin.nextInt();
	
	            System.out.print("Enter the number of Category C stamps to add: ");
	            int categoryC = cin.nextInt();
	
	            System.out.print("Enter the number of Category D stamps to add: ");
	            int categoryD = cin.nextInt();
	
	            System.out.print("Enter the number of Category E stamps to add: ");
	            int categoryE = cin.nextInt(); 
	
	            int newTotal = registries[registryIndex].addingStamps(categoryA, categoryB, categoryC, categoryD, categoryE);
	
	            System.out.println("Stamps added! The new total value of stamps in Registry " + (registryIndex + 1) + " is $" + newTotal + ".");
	            exit= true;
	        } else {
	            System.out.println("# Invalid Registry number. #");
	        }
        }while(exit == false);
    }// END of add Stamp to Registry Method // 

	//Good bye method // 
}//END OF PROGRAM // 
