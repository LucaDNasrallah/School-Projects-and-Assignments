//functions.c
#include "functions.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

//These are the globa variabels that will be used to save the information from the files. 
Entry entries[MAX_ENTRIES];
int entryCount = 0;

//Reading the files:
void loadEntries(char *filename){
    FILE *file = fopen(filename, "r"); // This opens the files for reading 
    if(!file){
        fprintf(stderr, "Error: Cannot Open this file.\n");
        exit(1); //Leaves with the erorr code above      
    }
    while(fscanf(file,"%d|%100[^|]|%100[^|]|%100[^|]|%100[^|]|%f\n", 
            &entries[entryCount].id,
            &entries[entryCount].date,
            &entries[entryCount].type,
            &entries[entryCount].subtype,
            &entries[entryCount].description,
            &entries[entryCount].amount) == 6){
            entryCount++; // Incrementing the count for each sucessfly read entry
    }
    fclose(file); // Closeing the reader of the file. 
} // END of loadingEntries Function 


// Constant Method -- Menu Display


// Choice 1 -- Display All Entries
void displayEntries(){
    printf("ID  Data    Type    Subtype     Description         Amount\n");
    printf("===========================================================\n");
    for(int i = 0; i < entryCount; i++){
        printf("%-4d %-11s %-10s %-10s %-28s $%.2f\n",
            entries[i].id,entries[i].date, entries[i].type, entries[i].subtype, entries[i].description , entries[i].amount);
    }
}

// Choice 2 -- Expense Distribution


// Choice 3 -- Sort Entries


// Choice 4 -- Add Income/ Expense Entry


// Choice 5 -- Modify Entry


// Choice 6 -- Filer Month



//Add as an extra, but this is used to clear the terminal. Doesn't flood the terminal with a bunch of outputs
// Clears the terminal screen using the system command
void clearScreen() {
    system("clear"); // Use "cls" if on Windows; Docker/Unix uses "clear"
}
