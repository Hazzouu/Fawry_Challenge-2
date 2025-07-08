public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year) {
        super(isbn, title, year, 0.0); //  price is always 0 because yk  its a demo book
    }

    @Override
    public double getPrice() {
        return 0.0;
    }
} 