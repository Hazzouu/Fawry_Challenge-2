public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public boolean canBeEmailed() { return true; }
} 