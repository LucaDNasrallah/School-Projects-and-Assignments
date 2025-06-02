//budget.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "functions.h"

int strcasecmp_custom(const char *s1, const char *s2) {
    while (*s1 && *s2) {
        char c1 = TO_LOWER_CUSTOM(*s1);
        char c2 = TO_LOWER_CUSTOM(*s2);
        if (c1 != c2) return c1 - c2;
        s1++;
        s2++;
    }
    return TO_LOWER_CUSTOM(*s1) - TO_LOWER_CUSTOM(*s2);
}

void clearScreen() {
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

// --- displayMenu ---
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
// --- end of displayMenu ---

// --- displayEntries ---
void displayEntries() {
    clearScreen();
    printf("ID   Date        Type       Subtype    Description                 Amount\n");
    printf("===============================================================================\n");
    for (int i = 0; i < entryCount; i++) {
        printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n",
               entries[i].id, entries[i].date, entries[i].type,
               entries[i].subtype, entries[i].description, entries[i].amount);
    }
    printf("\nPress Enter to continue...");
    getchar();
    getchar();
}
// --- end of displayEntries ---

// --- expenseDistribution ---
void expenseDistribution(){
    float totalIncome = 0.0;
    float totalExpense = 0.0;
    float totalNeeds = 0.0;
    float totalWants = 0.0;

    for(int i = 0; i < entryCount; i++){
        if (!strcasecmp_custom(entries[i].type, "income")) {
            totalIncome += entries[i].amount;
        } else if (!strcasecmp_custom(entries[i].type, "expense")) {
            totalExpense += entries[i].amount;
            if(!strcasecmp_custom(entries[i].subtype, "needs")) {
                totalNeeds += entries[i].amount;
            } else if (!strcasecmp_custom(entries[i].subtype, "wants")) {
                totalWants += entries[i].amount;
            }
        }
    }

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

    clearScreen();
    printf("\n===== Expense Distribution Report =====\n");
    printf("Total Income: $%.2f\n", totalIncome);
    printf("Total Expenses: $%.2f\n", totalExpense);
    printf("Needs: $%.2f (%.2f%% of expenses, %.2f%% of income)\n", totalNeeds, needsFracExp, needsFracInc);
    printf("Wants: $%.2f (%.2f%% of expenses, %.2f%% of income)\n", totalWants, wantsFracExp, wantsFracInc);
    printf("Net Balance: $%.2f\n", (totalIncome - totalExpense));
    printf("==========================================\n");
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}
// --- end of expenseDistribution ---

// --- addEntry ---
void addEntry() {
    clearScreen();
    printf("\n--- Add New Entry ---\n");

    if (entryCount >= MAX_ENTRIES) {
        printf("Maximum number of entries reached. Cannot add more.\n");
        printf("Press Enter to continue...\n");
        getchar();
        getchar();
        return;
    }

    Entry newEntry;
    char choice_char;

    newEntry.id = (entryCount > 0) ? entries[entryCount - 1].id + 1 : 101;

    printf("Use today's date? (y/n) : ");
    if (scanf(" %c", &choice_char) != 1) {
        printf("Invalid input. Please enter 'y' or 'n'.\n");
        while (getchar() != '\n');
        return;
    }
    getchar();

    if (TO_LOWER_CUSTOM(choice_char) == 'y') {
        time_t t = time(NULL);
        struct tm *tm_info = localtime(&t);
        strftime(newEntry.date, MAX_LEN, "%Y-%m-%d", tm_info);
    } else {
        printf("Enter date (YYYY-MM-DD) : ");
        if (scanf(" %s", newEntry.date) != 1) {
            printf("Invalid date format.\n");
            while (getchar() != '\n');
            return;
        }
    }

    printf("Type (income/expense) : ");
    if (scanf(" %s", newEntry.type) != 1) {
        printf("Invalid type.\n");
        while (getchar() != '\n');
        return;
    }

    printf("Category : ");
    if (scanf(" %s", newEntry.subtype) != 1) {
        printf("Invalid category.\n");
        while (getchar() != '\n');
        return;
    }

    printf("Description : ");
    while (getchar() != '\n');
    if (fgets(newEntry.description, MAX_LEN, stdin) == NULL) {
        printf("Error reading description.\n");
        return;
    }
    newEntry.description[strcspn(newEntry.description, "\n")] = 0;

    printf("Amount : $");
    if (scanf("%f", &newEntry.amount) != 1) {
        printf("Invalid amount.\n");
        while (getchar() != '\n');
        return;
    }

    entries[entryCount] = newEntry;
    entryCount++;

    printf("\nEntry added successfully with ID: %d\n", newEntry.id);
    printf("Press Enter to continue...\n");
    getchar();
    getchar();
}
// --- end of addEntry ---

// --- modifyEntry ---
void modifyEntry() {
    clearScreen();
    printf("\n--- Modify Entry ---\n");

    printf("\nFinances Summary\n");
    printf("ID   Date        Type       Category   Description                 Amount\n");
    printf("===============================================================================\n");
    for (int i = 0; i < entryCount; i++) {
        printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n",
               entries[i].id, entries[i].date, entries[i].type,
               entries[i].subtype, entries[i].description, entries[i].amount);
    }
    printf("\n");

    int idToModify;
    printf("Enter ID of entry to modify : ");
    if (scanf("%d", &idToModify) != 1) {
        printf("Invalid input. Please enter a number.\n");
        while (getchar() != '\n');
        return;
    }
    getchar();

    int foundIndex = -1; // Linear search to find the entry by ID.
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
        if (scanf("%d", &modifyChoice) != 1) {
            printf("Invalid input. Please enter a number.\n");
            while (getchar() != '\n');
            return;
        }
        getchar();

        switch (modifyChoice) {
            case 1:
                printf("Enter new date (YYYY-MM-DD) : ");
                if (scanf(" %s", entries[foundIndex].date) != 1) {
                    printf("Invalid date format.\n");
                    while (getchar() != '\n');
                    return;
                }
                break;
            case 2:
                printf("Enter new amount : $");
                if (scanf("%f", &entries[foundIndex].amount) != 1) {
                    printf("Invalid amount.\n");
                    while (getchar() != '\n');
                    return;
                }
                break;
            default:
                printf("Invalid modification choice.\n");
                printf("Press Enter to continue...\n");
                getchar();
                return;
        }
        printf("Entry updated successfully.\n");
    } else {
        printf("Entry with ID %d not found.\n", idToModify);
    }

    printf("Press Enter to continue...\n");
    getchar();
}
// --- end of modifyEntry ---

// --- filterByMonth ---
void filterByMonth() {
    clearScreen();
    printf("\n--- Filter by Month ---\n");

    int year, month;
    printf("Enter year (YYYY) : ");
    if (scanf("%d", &year) != 1) {
        printf("Invalid input. Please enter a number for the year.\n");
        while (getchar() != '\n');
        return;
    }
    printf("Enter month (1-12) : ");
    if (scanf("%d", &month) != 1 || month < 1 || month > 12) {
        printf("Invalid input. Please enter a number between 1 and 12 for the month.\n");
        while (getchar() != '\n');
        return;
    }
    getchar();

    printf("\nEntries for %d-%02d :\n", year, month);
    printf("ID   Date        Type       Category   Description                 Amount\n");
    printf("===============================================================================\n");

    int foundEntries = 0;
    for (int i = 0; i < entryCount; i++) {
        int entryYear, entryMonth, entryDay;
        if (sscanf(entries[i].date, "%d-%d-%d", &entryYear, &entryMonth, &entryDay) == 3) {
            if (entryYear == year && entryMonth == month) {
                printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n",
                       entries[i].id, entries[i].date, entries[i].type,
                       entries[i].subtype, entries[i].description, entries[i].amount);
                foundEntries = 1;
            }
        }
    }

    if (!foundEntries) {
        printf("No entries found for %d-%02d.\n", year, month);
    }

    printf("\nPress Enter to continue...\n");
    getchar();
}
// --- end of filterByMonth ---