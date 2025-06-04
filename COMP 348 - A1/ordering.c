//ordering.c
#include <stdio.h>
#include <string.h>
#include "functions.h"

// --- sortEntries ---
void sortEntries() {
    int sortChoice;
    Entry temp;

    clearScreen();
    printf("\n--- Sort Menu ---\n");
    printf("1. Sort by ID\n");
    printf("2. Sort by Date\n");
    printf("3. Sort by Amount\n");
    printf("4. Sort by Description\n");
    printf("Choice: ");
    if (scanf("%d", &sortChoice) != 1) {
        printf("Invalid input. Please enter a number.\n");
        while (getchar() != '\n');
        return;
    }
    getchar();

    // Bubble sort algorithm: repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
    for (int i = 0; i < entryCount - 1; i++) {
        for (int j = 0; j < entryCount - 1 - i; j++) {
            int shouldSwap = 0;
            switch (sortChoice) {
                case 1: if (entries[j].id > entries[j+1].id) shouldSwap = 1; break;
                case 2: if (strcmp(entries[j].date, entries[j+1].date) > 0) shouldSwap = 1; break;
                case 3: if (entries[j].amount > entries[j+1].amount) shouldSwap = 1; break;
                case 4: if (strcasecmp_custom(entries[j].description, entries[j+1].description) > 0) shouldSwap = 1; break;
                default: printf("Invalid sort choice. Returning to main menu.\n"); getchar(); return;
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
    getchar();
    displayEntries();
}
// --- end of sortEntries ---
