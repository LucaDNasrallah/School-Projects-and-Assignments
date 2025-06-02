// ---------------------------------------------------------
// Assignment 1_ Question 2
// Written by: Luca Nasrallah ID: 40316548
// For COMP 248 Section R – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;
public class A1_Q2
{	
	public static void main(String[] args)
		{
		//Scanner Implementation
		Scanner myKey = new Scanner(System.in);
		
		//Salutations 
		System.out.println("Welcome to Algorithm 2: String Inspector Program. \n");
		
		// Main Sentence and beginning of User Inputs
		System.out.print("Enter a given sentence (greater than 5 characters): ");
		String mainSentence = myKey.nextLine();
		
		//Search Word for mainsetence.contains(); method
		System.out.print("Enter a Search Word: ");
		String searchWord = myKey.next();
		
		//Separator word for String.join(); method
		System.out.print("Enter a seperator String: ");
		String seperatorString = myKey.next();
		//End of User Inputs
		
		//All operation methods in order( i.e. contains(),startsWith(),replaceAll(),String.join(),indexOf() and charAt() ) 
		System.out.println("The given sentence contains the search word: "+ mainSentence.contains(searchWord));
		System.out.println("The given sentence begins with the letter \'i:\' " + mainSentence.startsWith("i"));
		System.out.println("Sentence with \'a\'replaced by \'e\': " + mainSentence.replaceAll("a","e"));
		System.out.println("Joined String: " + String.join("",mainSentence, seperatorString, searchWord));
		System.out.println("\'a\' appears at index " + mainSentence.indexOf("a") + " in the given sentence.");
		System.out.println("Character at the 3rd position in the given sentence is: "+ mainSentence.charAt(2));
		
		// Exiting Message
		System.out.println("\nThank you for using the String Inspector Program. Come back soon!");
		myKey.close(); // Closing Scanner
		//:)
		
	}

}
