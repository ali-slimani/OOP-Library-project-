import java.util.*;

// Main program to run the library system through a simple console interface
public class Main {
    static List<Book> books = new ArrayList<>();         // List to store books
    static List<Borrower> borrowers = new ArrayList<>(); // List to store borrowers
    static Scanner scanner = new Scanner(System.in);     // Scanner for user input

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();              // Display menu
            choice = scanner.nextInt();
            scanner.nextLine();      // Clear the newline

            switch (choice) {
                case 1 -> addBook();             // Add a book
                case 2 -> addBorrower();         // Add a borrower
                case 3 -> borrowBook();          // Borrow a book
                case 4 -> returnBook();          // Return a book
                case 5 -> listBorrowedBooks();   // Show borrowed books
                case 6 -> searchBook();          // Search for a book
                case 7 -> searchBorrower();      // Search for a borrower
                case 0 -> System.out.println("Exiting program."); // Exit
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Display the main menu options
    static void showMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Add Borrower");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. List Borrowed Books");
        System.out.println("6. Search Book by ISBN");
        System.out.println("7. Search Borrower by ID");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add a new book to the system
    static void addBook() {
        System.out.print("Enter book type (1: Paper, 2: EBook): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book book = (type == 1) ? new PaperBook(title, author, isbn) : new EBook(title, author, isbn);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Add a new borrower to the system
    static void addBorrower() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();

        borrowers.add(new Borrower(name, id));
        System.out.println("Borrower added successfully.");
    }

    // Let a borrower borrow a book
    static void borrowBook() {
        System.out.print("Enter borrower ID: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book == null || !book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        borrower.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    // Let a borrower return a book
    static void returnBook() {
        System.out.print("Enter borrower ID: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book == null || book.isAvailable()) {
            System.out.println("Book is not currently borrowed.");
            return;
        }

        borrower.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    // List all books borrowed by all borrowers
    static void listBorrowedBooks() {
        for (Borrower b : borrowers) {
            System.out.println("Borrower: " + b.getInfo());
            for (Book book : b.getBorrowedBooks()) {
                System.out.println("  - " + book.getDetails());
            }
        }
    }

    // Search for a book by its ISBN
    static void searchBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book != null) {
            System.out.println(book.getDetails());
        } else {
            System.out.println("Book not found.");
        }
    }

    // Search for a borrower by their student ID
    static void searchBorrower() {
        System.out.print("Enter borrower ID: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower != null) {
            System.out.println(borrower.getInfo());
        } else {
            System.out.println("Borrower not found.");
        }
    }

    // Helper method to find a book by ISBN
    static Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a borrower by student ID
    static Borrower findBorrower(String id) {
        for (Borrower b : borrowers) {
            if (b.getStudentId().equals(id)) {
                return b;
            }
        }
        return null;
    }
                  }
