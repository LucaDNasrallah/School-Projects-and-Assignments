/*
---------------------------------
Assignment 1
Name: Luca Nasrallah
Group: COMP 348 - AA
ID: 40316548
----------------------------------
*/

#include <stdio.h>    
#include <stdlib.h>  
#include "functions.h"
//main.c
int main(){

    const char *filename = "finances.txt"; // Hardcoded Input file 

    int loadedCount = loadEntries(filename);
    if(loadedCount < 0){
        fprintf(stderr, "Failed to load entries from file '%s'. Exiting \n", filename);
        return 1;
    } else if( loadedCount == 0){
        printf("No entries found in '%s'. \n", filename);
    } else{
        printf("Successfully loaded %d entries from '%s'.\n",loadedCount,filename);
    }

    int choice = 0; // Variables to store user's menu choice 

    do{
        displayMenu(); // Show the menu seen in function.c
        scanf("%d",&choice); 
        while (getchar() != '\n'); // clear input buffer
       switch (choice) {
            case 1:
                displayEntries(); // Call displayEntries; it uses the global 'entries' and 'entryCount'
                break;
            case 2:
                printf("Choice 2: Expense Distribution - Not implemented yet.\n");
                printf("\nPress Enter to continue...");
                getchar(); // Wait for user to press Enter
                break;
            case 3:
                printf("Choice 3: Sort Entries - Not implemented yet.\n");
                printf("\nPress Enter to continue...");
                getchar(); // Wait for user to press Enter
                break;
            case 4:
                printf("Choice 4: Add income/ expense entry - Not implemented yet.\n");
                printf("\nPress Enter to continue...");
                getchar(); // Wait for user to press Enter
                break;
            case 5:
                printf("Choice 5: Modify Entry - Not implemented yet.\n");
                printf("\nPress Enter to continue...");
                getchar(); // Wait for user to press Enter
                break;
            case 6:
                printf("Choice 6: Filter by month - Not implemented yet.\n");
                printf("\nPress Enter to continue...");
                getchar(); // Wait for user to press Enter
                break;
            case 7:
                printf("Exiting program.\n"); // Exit message for the user
                break;
            default:
                printf("Invalid choice. Please try again.\n"); // Message for invalid input
                getchar(); // Wait for user to press Enter
                break;
        }

    } while (choice != 7);
    return 0; // This is the end of program. Meaning the program ran without any issues. 
}



