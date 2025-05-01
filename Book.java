// Abstract class representing a generic book in the library
public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean isAvailable;

    // Constructor to initialize common book attributes
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // Book is available by default
    }

    // Each subclass should specify its type
    public abstract String getType();

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Returns basic details about the book
    public String getDetails() {
        return getType() + " - " + title + " by " + author + " (ISBN: " + isbn + ") - " +
               (isAvailable ? "Available" : "Borrowed");
    }

    public String getIsbn() {
        return isbn;
    }
      }
