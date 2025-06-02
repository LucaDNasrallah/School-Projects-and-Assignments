//data.c
#include <stdio.h>
#include <stdlib.h>
#include "functions.h"

// Global variables defined here
Entry entries[MAX_ENTRIES];
int entryCount = 0;

// --- loadEntries ---
int loadEntries(){
    const char *filename = "finances.txt";
    FILE *file = fopen(filename, "r");
    if(!file){
        fprintf(stderr, "Error: Cannot Open this file '%s'.\n", filename);
        return -1;
    }

    entryCount = 0;
    // Reads entries from the file, parsing each line based on the format.
    while (entryCount < MAX_ENTRIES &&
           fscanf(file, "%d|%100[^|]|%100[^|]|%100[^|]|%100[^|]|%f\n",
                  &entries[entryCount].id, entries[entryCount].date,
                  entries[entryCount].type, entries[entryCount].subtype,
                  entries[entryCount].description, &entries[entryCount].amount) == 6) {
        entryCount++;
    }

    fclose(file);
    return entryCount;
}
// --- end of loadEntries ---