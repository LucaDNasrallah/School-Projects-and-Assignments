//functions.h
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#define MAX_ENTRIES 1000
#define MAX_LEN 101

// Macro for custom lowercase conversion
#define TO_LOWER_CUSTOM(c) (((c) >= 'A' && (c) <= 'Z') ? ((c) + ('a' - 'A')) : (c))

// Structure for a financial entry
typedef struct {
    int id;
    char date[MAX_LEN];
    char type[MAX_LEN];
    char subtype[MAX_LEN];
    char description[MAX_LEN];
    float amount;
} Entry;

// Global variables (defined in data.c)
extern Entry entries[MAX_ENTRIES];
extern int entryCount;

// Function declarations (budget.c)
void displayMenu();
void displayEntries();
void expenseDistribution();
void addEntry();
void modifyEntry();
void filterByMonth();
void clearScreen();

// Function declaration (data.c)
int loadEntries();

// Function declaration (ordering.c)
void sortEntries();

// Function declaration (budget.c)
int strcasecmp_custom(const char *s1, const char *s2);

#endif // FUNCTIONS_H