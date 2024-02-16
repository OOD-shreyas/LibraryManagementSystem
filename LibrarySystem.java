// Team: Night Owls (Isaac Acosta, Cayden Haas, Eddie Brito)
// CSCI 428 - Homework 2 - Library Management System
// Date: 02/12/2024

import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class LibrarySystem {
//
    public static void main(String[] args) {
        LibraryCollection collection = new LibraryCollection();
        try (Scanner scanner = new Scanner(System.in)) {
            // Example librarian and member setup
            Librarian librarian = new Librarian(1, "Admin", collection);
            Member member = new Member(2, "John Doe");

            // Simple CLI loop for demonstration
            while (true) {
                System.out.println("Enter command (1: Add book, 2: Borrow book, 3: Return book, 4: Exit): ");
                int command = scanner.nextInt();

                switch (command) {
                    case 1:
                        // Add a book (Librarian only)
                        System.out.println("Adding a book (Librarian action)...");
                        scanner.nextLine();
                        // Dummy book details for simplicity
                        System.out.println("Enter the author's name: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter the book title: ");
                        String title = scanner.nextLine();
                        Book newBook = new Book(collection.getBooks().size() + 1, title , author);
                        librarian.addBook(newBook);
                        System.out.print("Book added: ID: " + "\u001B[31m" + newBook.getID() + "\u001B[0m" + ", Title: " + "\u001B[31m" + newBook.getTitle() + "\u001B[0m" + ", Author: " +  "\u001B[31m" + newBook.getAuthor() + "\u001B[0m" + "\n");
                        break;
                    case 2:
                        // Borrow a book (Member action)
                        System.out.println("Enter book ID to borrow: ");
                        int bookIDToBorrow = scanner.nextInt();
                        Book bookToBorrow = collection.findBookByID(bookIDToBorrow);
                        if (bookToBorrow != null && bookToBorrow.isAvailable()) {
                            member.borrowBook(bookToBorrow);
                            System.out.println("Book borrowed: " + "\u001B[31m" + bookToBorrow.getTitle() + "\u001B[0m");
                        } else {
                            System.out.println("Book is not available or does not exist.");
                        }
                        break;
                    case 3:
                        // Return a book
                        System.out.println("Enter book ID to return: ");
                        int bookIDToReturn = scanner.nextInt();
                        Book bookToReturn = collection.findBookByID(bookIDToReturn);
                        if (bookToReturn != null) {
                            member.returnBook(bookToReturn);
                            System.out.println("Book returned: " + "\u001B[31m" + bookToReturn.getTitle() + "\u001B[0m");
                        } else {
                            System.out.println("Book does not exist.");
                        }
                        break;
                    case 4:
                        // Exit
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        }
    }
}
