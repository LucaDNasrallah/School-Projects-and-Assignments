//functions.h
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#define MAX_ENTRIES 1000
#define MAX_LEN 101

typedef struct{
    int id;
    char date[MAX_LEN];
    char type[MAX_LEN];
    char subtype[MAX_LEN];
    char description[MAX_LEN];
    float amount;
}Entry;

extern Entry entries[MAX_ENTRIES]; // This is an Array that Stroes all teh entries. 
extern int entryCount; // Saved number of Entries being loaded

//Functions declarations
void loadEntries(char *fileName); // Load data from input file
void displayEntries(); // Choice 1 - Displays all entries in a table  
// Missing the other choices 
// COME BACK THE OTHER CHOICES ONCE THE FIRST WORKS


void clearScreen(); // Clear Terminal Screen. 


#endif
