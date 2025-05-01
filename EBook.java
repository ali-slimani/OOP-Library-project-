// Represents a digital e-book
public class EBook extends Book {
    public EBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    // Specifies the type of book
    @Override
    public String getType() {
        return "E-Book";
    }
}
