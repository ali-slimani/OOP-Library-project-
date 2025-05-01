// Represents a physical paper book
public class PaperBook extends Book {
    public PaperBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    // Specifies the type of book
    @Override
    public String getType() {
        return "Paper Book";
    }
}
