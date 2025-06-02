// -----------------------------------------------------------
// Assignment 0
// Question: Part II
// Written By: Luca Nasrallah
// -----------------------------------------------------------
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static final int PASSWORD = 249;
    private static int totalFailedAttemps = 0;
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        System.out.println("| Welcome to the Concordia Trial Book Store.");
        System.out.print("Enter the maximum amount of books the store can hold: ");

        int maxBooks= cin.nextInt();
        Book[] inventory = new Book[maxBooks];
        int bookCount = 0;
        boolean exit = false;
        do{

            menuDisplayMethod();
            int choice = cin.nextInt();

            switch (choice) {
                case 1: // Entering a New Book //
                {
                    bookCount = enterNewBooks(cin,inventory,bookCount, maxBooks);
                    break;
                }
                case 2: // Changing Books info //
                {
                    changeBookInfo(cin, inventory, bookCount);
                    break;
                }

                case 3: // Display all the books by a specific number //
                {
                    displayBooksByAuthor(cin,inventory,bookCount);
                    break;
                }
                case 4: // Display all books under a certain price  //
                {
                    displayBooksUnderPrice(cin,inventory,bookCount);
                    break;
                }
                case 5: // Quiting with Parting message //
                System.out.println("""
                        | Thank you for using the Concordia Trial Library. 
                        | Come back soon :)""");
                exit = true;
                        break;
                default:
                    System.out.println("| Invalid choice. Please try again.");
                    break;
            }
        }while(!exit);
    }

    public static void menuDisplayMethod() { // Menu Display //
        System.out.println("""
                |----------------------------------------------------------|
                | What do you want to do?                                  |
                |    1. Enter new books (password required)                |
                |    2. Change information of a book (password required)   |
                |    3. Display all books by a specific author             |
                |    4. Display all books under a certain a price.         |
                |    5. Quit                                               |
                |----------------------------------------------------------|""");
        System.out.print("| Enter your choice: ");
    }// END of Menu Display Method //

    // option 1 // //NEEDS TO BE TESTED FOR THE AUTHENTICATION //
    private static int enterNewBooks(Scanner cin, Book[] inventory, int bookCount, int maxBooks) {
        if (authenticate(cin)) { // Runs through authenticate function for invalid Passwords.
            System.out.print("| How many books would you like to enter? ");
            int numBooks = cin.nextInt();
            cin.nextLine();

            if (bookCount + numBooks > maxBooks) { // When the new and previous bookCount is greater than the number of books that can be stored in the store.
                System.out.println("| Not enough space in the inventory. You can add up to " + (maxBooks - bookCount) + " books only."); // Displays the error message and how many books can be stored in the library.
            } else {
                System.out.println("| Enter the book details below:"); // Applying all the information for the books being added.
                System.out.print("| Enter title: ");
                String title = cin.nextLine();

                System.out.print("| Enter author: ");
                String author = cin.nextLine();

                System.out.print("| Enter ISBN: ");
                long ISBN = cin.nextLong();

                System.out.print("| Enter price: ");
                double price = cin.nextDouble();
                cin.nextLine();

                for (int i = 0; i < numBooks; i++) {
                    inventory[bookCount++] = new Book(title, author, ISBN, price); /* Starting from the previous bookCount and continue
                     from there. */ // This stores all the books as new book object in the inventory array.
                }
                System.out.println("| Books successfully added. Remaining space in library: " + (maxBooks - bookCount));
                // Showing how much space is left in the library and a success message for the user to know all books have been stored. //
            }
        }
        else if(totalFailedAttemps == 12) {
            System.out.println("| SECURITY RISK DETECTED: Too many failed password attempts.");
            System.out.println("| This program will terminate for security reasons. ");
            System.exit(0); // Terminating the program shortcut :)
        }
        return bookCount;
    } // END of the Entering Books Function //

    // Option 2 // //TEST AUTHENTICATION WITH THIS//
    private static void changeBookInfo(Scanner cin, Book[] inventory, int bookCount){
        boolean exit = false;
        if(authenticate(cin)) {
            do {
                if (bookCount == 0) {
                    System.out.println("""
                            |----------------------------------------------------------|
                            | There aren't any books inside of the inventory.          |
                            | Use Option 1, to add books to the inventory.             |""");
                    //clarifying message for when there were no books initially added into the store. //
                    exit = true;
                } else {
                    System.out.print("| Enter the number of the book to update (1 - " + bookCount + "): ");
                    int index = cin.nextInt(); // Choosing the index of book you want to specifically change. //

                    if (index - 1 < 0 || index - 1 >= bookCount || inventory[index - 1] == null) {
                        System.out.println("| This is an invalid book. Please try again."); // When there is no book that exist in the index or if the input is negative.
                    } else {
                        Book book = inventory[index - 1]; // Choosing the number of the index in the array
                        System.out.println("| Book #"+(index) +"\n"+ book); // Displaying all the attributes of this book that has been chosen. //

                        while (!exit) { // Keeping the user in the same area to be able to change all information about the chosen book if they would like, and then allowing them to leave using option 5. //
                            System.out.println("""
                                    |-------------------------------------------------|
                                    | What Information would you like to change?      |
                                    |    1. Title.                                    |
                                    |    2. Author.                                   |
                                    |    3. ISBN.                                     |
                                    |    4. Price.                                    |
                                    |    5. Quit (Returns to main Menu)               |
                                    |-------------------------------------------------|""");
                            System.out.print("| Enter your Choice here: ");
                            int choice = cin.nextInt();

                            switch (choice) { // Choosing which option they want to change, and prompting the user for an input for that specific attribute to be changed.
                                case 1: // Title //
                                    System.out.print("| Enter the new title of the book: ");
                                    book.setTitle(cin.nextLine());
                                    break;
                                case 2: // Author //
                                    System.out.print("| Enter the new author: ");
                                    book.setAuthor();
                                    break;
                                case 3: // ISBN //O
                                    System.out.print("| Enter the new ISBN: ");
                                    book.setIBSN();
                                    break;
                                case 4:  // Price //
                                    System.out.print("| Enter the new price: ");
                                    book.setPrice();
                                    break;
                                case 5:  // Quitting //
                                    exit = true;
                                    break;
                                default: // Random Input that is INVALID //
                                    System.out.println("| Invalid choice. Please try again.");
                            }
                            System.out.println("| The book details have been successfully updated.");
                        }
                    }
                }
            }while (!exit) ; // Ending of the whole function when option 5 is chosen going back to the menu display. //
        }
    } // END of the Changing Book Details Function //

    // Option 3 // // VERIFIED //
    private static void displayBooksByAuthor(Scanner cin , Book[] inventory, int bookCount){
        boolean exit = false;
        do {
            System.out.print("| Enter the author: ");
            cin.nextLine();
            String author = cin.nextLine();
            boolean found = false;

            for (int i = 0; i < bookCount; i++) {
                if (inventory[i] != null && inventory[i].getAuthor().equalsIgnoreCase(author)) { /* if the index throughout the whole book count isn't null, and the name of the author (string) is
                 the same name of the author within the book count, disregarding the capitalization of the input, then that book will be printed. If not met by these conditions it will be skipped by the loop. */
                    found = true;
                    System.out.println("|-------------------------------------------------|" +
                            "\n| Book #" + (i+1));
                    System.out.println(inventory[i].toString());
                    exit = true;
                }
            }
            // Message if no books were found for the author
            if (!found) {
                System.out.println("| No books found for the author: " + author);
            }
        }while(!exit);
    } //END of the display Books by Author function //

    //Option 4 // //VERIFIED//
    private static void displayBooksUnderPrice(Scanner cin, Book[] inventory, int bookCount){
        boolean exit = false;
        do {
            System.out.print("| Enter the Price you want to check: ");
            cin.nextLine();
            double underPrice = cin.nextDouble();
            boolean found = false;

            for (int i = 0; i < bookCount; i++){
                if (inventory[i] != null && underPrice >= inventory[i].getPrice()) {/* if the index throughout the whole book count isn't null, and the price of the book  is
                 the greater than or equal to the other prices within the book count, then that book will be printed. If not met by these conditions it will be skipped by the loop. */
                    found = true;
                    System.out.println("|-------------------------------------------------|" +
                            "\n| Book #" + (i+1));
                    System.out.println(inventory[i].toString());
                    exit = true;
                }
            }
            // Message if no books were found for the author
            if (!found) {
                System.out.println("| No books are found under that price: " + String.format("%.2f",underPrice));
            }
        }while(!exit);
    } // END Of the Display Price Under Method //

    // Authentication method // //VERIFIED//
    private static boolean authenticate(Scanner cin) {
        for (int attempts = 1; attempts <= 3; ++attempts) {
            System.out.print("| Enter password: ");
            int input = cin.nextInt();
            if (input == PASSWORD) {
                totalFailedAttemps = 0;
                return true;
            } else if (attempts <= 3 && input != PASSWORD) {
                System.out.println("| Incorrect password. Attempt " + attempts + " of 3.");
                totalFailedAttemps++;
            }
            if(attempts == 3){
                System.out.println("| Too many failed attempts. Returning to the main menu");
            }
        }
        return false;
    }
}





