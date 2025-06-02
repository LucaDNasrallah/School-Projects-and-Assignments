// -----------------------------------------------------------
// Assignment 0
// Question: Part I
// Written By: Luca Nasrallah
// -----------------------------------------------------------
import java.util.Scanner;

public class Book {
    Scanner cin = new Scanner(System.in);
    private String title;
    private String author;
    private long iBSN;
    private double price;

    public static int bookCount = 0 ;


    public Book() {
        this("", "", 0, 0);
    } // END of Default Constructor //

    public Book(String title, String author, long isbn , double price) {
        this.title = title;
        this.author = author;
        this.iBSN = isbn;
        if (this.price >= 0){
            this.price = price;
        }
        else{
            System.out.println("Invalid Price");
        }
     bookCount++;
    } // END of Constructor Book //


    // GETTERs  //
    public String getTitle() {
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public long getIBSN(){
        return iBSN;
    }
    public double getPrice(){
        return price;
    }

    // SETTERS //
    public void setTitle(String title) {this.title = cin.nextLine();}
    public void setAuthor(){
        this.author = cin.nextLine();
    }
    public void setIBSN(){
        this.iBSN = cin.nextLong();
    }
    public void setPrice(){
        this.price = cin.nextDouble();
    }

    public int findNumberOfBooks(){
       return bookCount;
    }

    public boolean equals(Book otherBook){
        return (this.price == otherBook.price && this.iBSN == otherBook.iBSN);
    }


    @Override
    public String toString(){
        return "|-------------------------------------------------|\n"
                +"| \t1.Title: " + this.title + "\n| \t2.Author: " + this.author + " \n| \t3.IBSN: "
                + this.iBSN + "\n| \t4.Price: " + String.format("%.2f",this.price) + "$";
    }


} // END of Public Class Book //
