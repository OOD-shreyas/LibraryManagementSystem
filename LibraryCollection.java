// Team: Night Owls (Isaac Acosta, Cayden Haas, Eddie Brito)
// CSCI 428 - Homework 2 - Library Management System
// Date: 02/12/2024

import java.util.ArrayList;
import java.util.List;

public class LibraryCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    // Utility method to find a book by ID
    public Book findBookByID(int bookID) {
        return books.stream()
                    .filter(book -> book.getID() == bookID)
                    .findFirst()
                    .orElse(null);
    }
}
