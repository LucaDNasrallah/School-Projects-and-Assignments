/*
---------------------------------
Assignment 1
Name: Luca Nasrallah
Group: COMP 348 - AA
ID: 40316548
----------------------------------
*/


/*
    For this assignment, please make sure to compile the  code as such in the VS code terminal:
    gcc -o budgetTracker main.c data.c ordering.c budget.c
    and then to run  the code, in the terminal, type: ./budgetTracker
    This is the proper way to run the code for this case, since the finance.txt file is
    hard coded into the program and can be altered when accessed through visual studios to add or take way the base line code.
*/

#include <stdio.h>    
#include <stdlib.h>   
#include "functions.h" // Custom header containing Entry struct, global variables, and function declarations

int main(){
   
    int loadedCount = loadEntries(); 
    if(loadedCount < 0){
        
        fprintf(stderr, "Failed to load entries from file. Exiting.\n");
        return 1; // Exit with an error code
    } else if( loadedCount == 0){
        printf("No entries found.\n"); // Adjusted message
    } else{
        printf("Successfully loaded %d entries.\n", loadedCount); // Adjusted message
    }

    int choice = 0;

    // Main program loop: display menu and process user's choice until 'Exit' is selected
    do{
        displayMenu(); // Display the main menu options
        if (scanf(" %d", &choice) != 1) {
            printf("Invalid input. Please enter a number.\n");
            while (getchar() != '\n'); 
            choice = 0; 
            continue; 
        }
       
        // Process the user's choice using a switch statement
        switch (choice) {
            case 1:
                displayEntries(); // Call function to display all loaded entries
                break;
            case 2:
                expenseDistribution(); // Call function to show expense distribution report
                break;
            case 3:
                sortEntries(); // Call function to sort entries
                break;
            case 4:
                addEntry(); // Call function to add a new income/expense entry
                break;
            case 5:
                modifyEntry(); // Call function to modify an existing entry
                break;
            case 6:
                filterByMonth(); // Call function to filter entries by month
                break;
            case 7:
                printf("Thank you for using the Assignment 1 Budget Tracker Software!\n"); // Exit message
                break;
            default:
                printf("Invalid choice. Please try again.\n"); // Message for invalid menu input
                getchar(); // Consume the newline character left by scanf
                break;
        }

    } while (choice != 7); // Continue loop until user chooses to exit (option 7)

    return 0; // Program executed successfully
}
