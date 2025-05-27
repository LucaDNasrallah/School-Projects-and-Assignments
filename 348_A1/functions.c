//functions.c
#include "functions.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

//These are the globa variabels that will be used to save the information from the files. 
Entry entries[MAX_ENTRIES];
int entryCount = 0;

//Reading the files:
int loadEntries(const char *filename){
    FILE *file = fopen(filename, "r"); // This opens the files for reading 
    if(!file){
        fprintf(stderr, "Error: Cannot Open this file '%s'.\n", filename);
        return -1; //Leaves with the erorr code above      
    }
    entryCount = 0; 
     while (entryCount < MAX_ENTRIES &&
           fscanf(file, "%d|%100[^|]|%100[^|]|%100[^|]|%100[^|]|%f\n",
                  &entries[entryCount].id,
                  entries[entryCount].date,        
                  entries[entryCount].type,
                  entries[entryCount].subtype,
                  entries[entryCount].description,
                  &entries[entryCount].amount) == 6) { // Check if 6 items were successfully read
        entryCount++; // Increment the count for each successfully read entry
    }
    fclose(file); // Closeing the reader of the file. 
    return entryCount; 
} // END of loadingEntries Function 


// Constant Method -- Menu Display
void displayMenu(){
    clearScreen();
    printf(
        "Welcome to the budget Tracker App\n"
        "---------------------------------\n"
        "  1. Display all Entries\n"
        "  2. Expense Distribution\n"
        "  3. Sort Entries\n"
        "  4. Add income/ expense entry \n"
        "  5. Modify Entry \n"
        "  6. Filter by month\n"
        "  7. Exit\n"
        "---------------------------------\n"
        "Enter your choice here: "
    );
}

// Choice 1 -- Display All Entries
void displayEntries() {
    // Print table header with adjusted spacing for better alignment
    printf("ID   Date        Type       Subtype    Description                 Amount\n");
    printf("===============================================================================\n");

    // Loop through all loaded entries and print their details
    for (int i = 0; i < entryCount; i++) {
        printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n", // Formatted output
               entries[i].id,
               entries[i].date,
               entries[i].type,
               entries[i].subtype,
               entries[i].description,
               entries[i].amount);
    }
    printf("\nPress Enter to continue..."); // Prompt the user to continue

    getchar(); 
    getchar(); // Waiting for a user reponse 
}

// Choice 2 -- Expense Distribution


// Choice 3 -- Sort Entries


// Choice 4 -- Add Income/ Expense Entry


// Choice 5 -- Modify Entry


// Choice 6 -- Filer Month



//Add as an extra, but this is used to clear the terminal. Doesn't flood the terminal with a bunch of outputs
// Clears the terminal screen using the system command
void clearScreen() {
    #ifdef _WIN32
        system("cls"); // Command for Windows
    #else
        system("clear"); // Command for Unix-like systems (Linux, macOS)
    #endif
    // Found this online since it wasn't working when testing on linux // 
}
