import java.time.LocalDate;

// Manages the process of borrowing and returning a book
public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Records the borrowing event
    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now(); // Automatically sets today's date
    }

    // Marks the book as returned
    public void returnBook() {
        this.returnDate = LocalDate.now();
        borrower.returnBook(book);
    }

    // Returns a summary of the borrowing process
    public String getDetails() {
        return borrower.getInfo() + " borrowed "" + book.getDetails() +
               "" on " + borrowDate +
               (returnDate != null ? ", returned on " + returnDate : ", not returned yet");
    }
          }
