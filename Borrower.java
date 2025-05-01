import java.util.ArrayList;
import java.util.List;

// Represents a borrower who can borrow and return books
public class Borrower {
    private String name;
    private String studentId;
    private List<Book> borrowedBooks;

    public Borrower(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Adds a book to the borrower's list and marks it as unavailable
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    // Removes a book from the list and marks it as available
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getStudentId() {
        return studentId;
    }

    // Returns formatted borrower info
    public String getInfo() {
        return name + " (ID: " + studentId + ")";
    }
          }
