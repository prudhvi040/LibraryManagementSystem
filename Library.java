package library;

import library.exceptions.BookNotFoundException;
import library.exceptions.UserNotFoundException;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add new book
    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(title, author);
        books.add(book);

        System.out.println("Book added successfully: " + book);
    }

    // Register user
    public void registerUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = new User(name);
        users.add(user);

        System.out.println("User registered: " + user);
    }

    // Issue book
    public void issueBook(Scanner scanner) throws BookNotFoundException, UserNotFoundException {
        if (books.isEmpty()) {
            System.out.println("No books available to issue.");
            return;
        }

        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = findBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }

        if (book.isIssued()) {
            System.out.println("Sorry, this book is already issued.");
        } else {
            book.setIssued(true);
            System.out.println("Book issued successfully to " + user.getName());
        }
    }

    // Return book
    public void returnBook(Scanner scanner) throws BookNotFoundException {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }

        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = findBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }

        if (!book.isIssued()) {
            System.out.println("This book was not issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book returned successfully.");
        }
    }

    // Display books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Helper: Find user
    private User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Helper: Find book
    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
