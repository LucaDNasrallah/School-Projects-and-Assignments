//functions.c
#include "functions.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h> // For tolower() if case-insensitive comparison is desired

//These are the global variables that will be used to save the information from the files.
Entry entries[MAX_ENTRIES];
int entryCount = 0;

//Reading the files:
int loadEntries(const char *filename){
    FILE *file = fopen(filename, "r"); // This opens the files for reading
    if(!file){
        fprintf(stderr, "Error: Cannot Open this file '%s'.\n", filename);
        return -1; //Leaves with the error code above
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
    fclose(file); // Closing the reader of the file.
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
    getchar(); // Waiting for a user response
} // End of choice 1 Function

// Choice 2 -- Expense Distribution
void expenseDistribution(){
    float totalIncome = 0.0;
    float totalExpense = 0.0;
    float totalNeeds = 0.0;
    float totalWants = 0.0;

    // Checking all the entries
    for(int i = 0; i < entryCount; i++){
        if (strcmp(entries[i].type, "Income") == 0) {
            totalIncome += entries[i].amount;
        } else if (strcmp(entries[i].type, "Expense") == 0) {
            totalExpense += entries[i].amount;
            if (strcmp(entries[i].subtype, "Needs") == 0) {
                totalNeeds += entries[i].amount;
            } else if (strcmp(entries[i].subtype, "Wants") == 0) {
                totalWants += entries[i].amount;
            }
        }
    }// End of the loop

    float needsFracExp = 0.0;
    float needsFracInc = 0.0;
    float wantsFracExp = 0.0;
    float wantsFracInc = 0.0;

    if (totalExpense > 0) {
        needsFracExp = (totalNeeds / totalExpense) * 100;
        wantsFracExp = (totalWants / totalExpense) * 100;
    }
    if (totalIncome > 0) {
        needsFracInc = (totalNeeds / totalIncome) * 100;
        wantsFracInc = (totalWants / totalIncome) * 100;
    }

    printf("\n===== Expense Distribution Report =====\n");
    printf("Total Income: $%.2f\n", totalIncome);
    printf("Total Expenses: $%.2f\n", totalExpense);
    printf("Needs: $%.2f (%.2f%% of expenses, %.2f%% of income)\n", totalNeeds, needsFracExp, needsFracInc);
    printf("Wants: $%.2f (%.2f%% of expenses, %.2f%% of income)\n", totalWants, wantsFracExp, wantsFracInc);
    printf("Net Balance: $%.2f\n", (totalIncome - totalExpense));
    printf("==========================================\n");
    printf("Press Enter to continue...\n");
    getchar(); // waiting for User
}// End of Choice 2 Function

// Choice 3 -- Sort Entries
void sortEntries() {
    printf("\n--- Sort Entries ---\n");
    printf("This feature is not yet implemented.\n");
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}

// Choice 4 -- Add Income/ Expense Entry
void addEntry() {
    printf("\n--- Add New Entry ---\n");
    printf("This feature is not yet implemented.\n");
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}

// Choice 5 -- Modify Entry
void modifyEntry() {
    printf("\n--- Modify Entry ---\n");
    printf("This feature is not yet implemented.\n");
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}

// Choice 6 -- Filter by Month
void filterByMonth() {
    printf("\n--- Filter by Month ---\n");
    printf("This feature is not yet implemented.\n");
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}


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
