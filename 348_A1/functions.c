//functions.c
#include "functions.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <time.h> // For time(), localtime(), strftime()

// Macro to convert a character to lowercase if it's an uppercase letter
// This replaces tolower() from ctype.h
#define TO_LOWER_CUSTOM(c) (((c) >= 'A' && (c) <= 'Z') ? ((c) + ('a' - 'A')) : (c))

// Custom function for case-insensitive string comparison
// Returns 0 if strings are equal (ignoring case), non-zero otherwise
int strcasecmp_custom(const char *s1, const char *s2) {
    while (*s1 && *s2) {
        char c1 = TO_LOWER_CUSTOM(*s1);
        char c2 = TO_LOWER_CUSTOM(*s2);
        if (c1 != c2) {
            return c1 - c2; // Return difference if characters don't match
        }
        s1++;
        s2++;
    }
    // If one string is longer than the other, return the difference of the null terminator and the remaining character
    return TO_LOWER_CUSTOM(*s1) - TO_LOWER_CUSTOM(*s2);
}

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
    // Read entries from the file, ensuring all 6 fields are successfully scanned
    while (entryCount < MAX_ENTRIES &&
           fscanf(file, "%d|%100[^|]|%100[^|]|%100[^|]|%100[^|]|%f\n",
                  &entries[entryCount].id,
                  entries[entryCount].date,
                  entries[entryCount].type,
                  entries[entryCount].subtype,
                  entries[entryCount].description,
                  &entries[entryCount].amount) == 6) {
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

    getchar(); // Consume the newline character left by previous input
    getchar(); // Waiting for a user response
} // End of choice 1 Function

// Choice 2 -- Expense Distribution
void expenseDistribution(){
    float totalIncome = 0.0;
    float totalExpense = 0.0;
    float totalNeeds = 0.0;
    float totalWants = 0.0;
    
    // Loop through all entries to calculate totals
    for(int i = 0; i < entryCount; i++){
        // Use the custom case-insensitive comparison function
        if (!strcasecmp_custom(entries[i].type, "income")) { // If the Type is an Income
            totalIncome += entries[i].amount;
        } 
        // Check if the type is "expense" (case-insensitive)
        else if (!strcasecmp_custom(entries[i].type, "expense") ) {
            totalExpense += entries[i].amount;
            // If it's an expense, check if the subtype is "needs" (case-insensitive)
            if(!strcasecmp_custom(entries[i].subtype, "needs")) {
                totalNeeds += entries[i].amount;
            } 
            // Check if the subtype is "wants" (case-insensitive)
            else if (!strcasecmp_custom(entries[i].subtype, "wants")) {
                totalWants += entries[i].amount;
            }
        }
    }// End of the loop

    float needsFracExp = 0.0;
    float needsFracInc = 0.0;
    float wantsFracExp = 0.0;
    float wantsFracInc = 0.0;

    // Calculate percentages if total expenses are greater than zero
    if (totalExpense > 0) {
        needsFracExp = (totalNeeds / totalExpense) * 100;
        wantsFracExp = (totalWants / totalExpense) * 100;
    }
    // Calculate percentages if total income is greater than zero
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
    getchar(); // Consume the newline character left by previous input
    getchar(); // Waiting for User
}// End of Choice 2 Function

// Choice 3 -- Sort Entries
void sortEntries() {
    int sortChoice;
    Entry temp; // Temporary variable for swapping entries during sort

    clearScreen();
    printf("\n--- Sort Menu ---\n");
    printf("1. Sort by ID\n");
    printf("2. Sort by Date\n");
    printf("3. Sort by Amount\n");
    printf("4. Sort by Description\n");
    printf("Choice: ");
    scanf("%d", &sortChoice);

    // Consume the newline character left by scanf
    getchar(); 

    // Simple Bubble Sort implementation
    for (int i = 0; i < entryCount - 1; i++) {
        for (int j = 0; j < entryCount - 1 - i; j++) {
            int shouldSwap = 0; // Flag to determine if a swap is needed

            switch (sortChoice) {
                case 1: // Sort by ID (ascending)
                    if (entries[j].id > entries[j+1].id) {
                        shouldSwap = 1;
                    }
                    break;
                case 2: // Sort by Date (ascending)
                    // strcmp works for YYYY-MM-DD format for chronological order
                    if (strcmp(entries[j].date, entries[j+1].date) > 0) {
                        shouldSwap = 1;
                    }
                    break;
                case 3: // Sort by Amount (ascending)
                    if (entries[j].amount > entries[j+1].amount) {
                        shouldSwap = 1;
                    }
                    break;
                case 4: // Sort by Description (ascending, case-insensitive)
                    if (strcasecmp_custom(entries[j].description, entries[j+1].description) > 0) {
                        shouldSwap = 1;
                    }
                    break;
                default:
                    printf("Invalid sort choice. Returning to main menu.\n");
                    // Add getchar to consume the newline after the invalid input
                    getchar(); 
                    return; // Exit function if choice is invalid
            }

            if (shouldSwap) {
                temp = entries[j];
                entries[j] = entries[j+1];
                entries[j+1] = temp;
            }
        }
    }

    printf("\nEntries sorted successfully!\n");
    printf("Press Enter to view sorted entries...");
    getchar(); // Wait for user to press Enter

    displayEntries(); // Display the sorted entries
}

// Choice 4 -- Add Income/ Expense Entry
void addEntry() {
    clearScreen();
    printf("\n--- Add New Entry ---\n");

    if (entryCount >= MAX_ENTRIES) {
        printf("Maximum number of entries reached. Cannot add more.\n");
        printf("Press Enter to continue...\n");
        getchar(); // Consume newline
        getchar();
        return;
    }

    Entry newEntry;
    char choice_char;
    
    // 1. Generate new ID
    // If there are existing entries, new ID is last_id + 1, otherwise start from 101
    newEntry.id = (entryCount > 0) ? entries[entryCount - 1].id + 1 : 101; 

    // 2. Get Date
    printf("Use today's date? (y/n) : ");
    // Use " %c" to consume any leftover newline from previous inputs
    scanf(" %c", &choice_char); 

    if (TO_LOWER_CUSTOM(choice_char) == 'y') {
        time_t t = time(NULL); // Get current time
        struct tm *tm_info = localtime(&t); // Convert to local time structure
        // Format date as YYYY-MM-DD
        strftime(newEntry.date, MAX_LEN, "%Y-%m-%d", tm_info);
    } else {
        printf("Enter date (YYYY-MM-DD) : ");
        // Use " %s" to consume any leftover newline and read string
        scanf(" %s", newEntry.date); 
    }

    // 3. Get Type (income/expense)
    printf("Type (income/expense) : ");
    scanf(" %s", newEntry.type);

    // 4. Get Category (subtype)
    printf("Category : ");
    scanf(" %s", newEntry.subtype);

    // 5. Get Description
    printf("Description : ");
    // Clear input buffer before fgets to avoid reading leftover newlines
    while (getchar() != '\n'); 
    fgets(newEntry.description, MAX_LEN, stdin);
    // Remove the trailing newline character that fgets might add
    newEntry.description[strcspn(newEntry.description, "\n")] = 0; 

    // 6. Get Amount
    printf("Amount : $");
    scanf("%f", &newEntry.amount);

    // 7. Add to array
    entries[entryCount] = newEntry;
    entryCount++;

    printf("\nEntry added successfully with ID: %d\n", newEntry.id);
    printf("Press Enter to continue...\n");
    // Consume the newline character left by scanf("%f", ...) and then wait for user
    getchar(); 
    getchar();
}

// Choice 5 -- Modify Entry
void modifyEntry() {
    clearScreen();
    printf("\n--- Modify Entry ---\n");

    // Display all entries first so the user can see available IDs
    printf("\nFinances Summary\n");
    printf("ID   Date        Type       Category   Description                 Amount\n");
    printf("===============================================================================\n");
    for (int i = 0; i < entryCount; i++) {
        printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n", 
               entries[i].id,
               entries[i].date,
               entries[i].type,
               entries[i].subtype,
               entries[i].description,
               entries[i].amount);
    }
    printf("\n"); // Add a newline for better spacing

    int idToModify;
    printf("Enter ID of entry to modify : ");
    scanf("%d", &idToModify);

    // Consume the newline character left by scanf
    getchar();

    int foundIndex = -1;
    for (int i = 0; i < entryCount; i++) {
        if (entries[i].id == idToModify) {
            foundIndex = i;
            break;
        }
    }

    if (foundIndex != -1) {
        printf("\nCurrent Details :\n");
        printf("ID : %d\n", entries[foundIndex].id);
        printf("Date : %s\n", entries[foundIndex].date);
        printf("Type : %s\n", entries[foundIndex].type);
        printf("Category : %s\n", entries[foundIndex].subtype);
        printf("Description : %s\n", entries[foundIndex].description);
        printf("Amount : $%.2f\n", entries[foundIndex].amount);

        int modifyChoice;
        printf("\nWhat would you like to modify ?\n");
        printf("1. Date\n");
        printf("2. Amount\n");
        printf("Choice : ");
        scanf("%d", &modifyChoice);

        // Consume the newline character left by scanf
        getchar();

        switch (modifyChoice) {
            case 1: // Modify Date
                printf("Enter new date (YYYY-MM-DD) : ");
                scanf(" %s", entries[foundIndex].date); // Read new date
                break;
            case 2: // Modify Amount
                printf("Enter new amount : $");
                scanf("%f", &entries[foundIndex].amount); // Read new amount
                break;
            default:
                printf("Invalid modification choice.\n");
                printf("Press Enter to continue...\n");
                getchar();
                return; // Exit function if choice is invalid
        }
        printf("Entry updated successfully.\n");
    } else {
        printf("Entry with ID %d not found.\n", idToModify);
    }

    printf("Press Enter to continue...\n");
    getchar(); // Wait for user to press Enter
}

// Choice 6 -- Filter by Month
void filterByMonth() {
    clearScreen();
    printf("\n--- Filter by Month ---\n");

    int year, month;
    printf("Enter year (YYYY) : ");
    scanf("%d", &year);
    printf("Enter month (1-12) : ");
    scanf("%d", &month);

    // Consume the newline character left by scanf
    getchar();

    printf("\nEntries for %d-%02d :\n", year, month); // %02d for two-digit month
    printf("ID   Date        Type       Category   Description                 Amount\n");
    printf("===============================================================================\n");

    int foundEntries = 0;
    for (int i = 0; i < entryCount; i++) {
        int entryYear, entryMonth, entryDay;
        // Parse date string (YYYY-MM-DD)
        if (sscanf(entries[i].date, "%d-%d-%d", &entryYear, &entryMonth, &entryDay) == 3) {
            if (entryYear == year && entryMonth == month) {
                printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n", 
                       entries[i].id,
                       entries[i].date,
                       entries[i].type,
                       entries[i].subtype,
                       entries[i].description,
                       entries[i].amount);
                foundEntries = 1;
            }
        }
    }

    if (!foundEntries) {
        printf("No entries found for %d-%02d.\n", year, month);
    }

    printf("\nPress Enter to continue...\n");
    getchar(); // Wait for user to press Enter
}


// Clears the terminal screen using the system command
void clearScreen() {
    #ifdef _WIN32
        system("cls"); // Command for Windows
    #else
        system("clear"); // Command for Unix-like systems (Linux, macOS)
    #endif
}
