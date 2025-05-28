//functions.h
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#define MAX_ENTRIES 1000
#define MAX_LEN 101

typedef struct{
    int id; 
    char date[MAX_LEN]; // Date for String Example: 2025-05-23
    char type[MAX_LEN]; // Entry type Either Income, Expenses or Needs
    char subtype[MAX_LEN]; // Either Needs or Want
    char description[MAX_LEN]; // Short description of the entry
    float amount; // Amount, can be both postive and negative
}Entry;


//Global Varibales defined in function.c
extern Entry entries[MAX_ENTRIES]; // This is an Array that Stroes all teh entries. 
extern int entryCount; // Saved number of Entries being loaded

//Functions declarations
int  loadEntries( const char *fileName); // Load data from input 
void displayMenu(); // Self explanatory 

void displayEntries(); // Choice 1 - Displays all entries in a table  
void expenseDistribution(); //Choice 2 - Shows a summary reportof the entries 
void sortEntries(); //Choice 3 - 
void addEntry();//Choice 4 - 
void modifyEntry(); // Choice -5 - 
void filterByMonth(); // Choice 6 - 

void clearScreen(); // Clear Terminal Screen. 


#endif
