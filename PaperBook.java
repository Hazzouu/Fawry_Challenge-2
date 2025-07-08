public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean canBeShipped() { return stock > 0; }
} 