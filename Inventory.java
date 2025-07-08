import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<PaperBook> paperBooks;
    private List<EBook> eBooks;
    private List<ShowcaseBook> showcaseBooks;

    public Inventory() {
        paperBooks = new ArrayList<>();
        eBooks = new ArrayList<>();
        showcaseBooks = new ArrayList<>();
    }

   
    public void addBook(Book book) {
        if (book instanceof PaperBook) {
            paperBooks.add((PaperBook) book);
        } else if (book instanceof EBook) {
            eBooks.add((EBook) book);
        } else if (book instanceof ShowcaseBook) {
            showcaseBooks.add((ShowcaseBook) book);
        }
    }

    
    public List<Book> removeOutdatedBooks(int maxAge, int currentYear) {
        List<Book> removed = new ArrayList<>();
        // PaperBooks
        Iterator<PaperBook> paperIt = paperBooks.iterator();
        while (paperIt.hasNext()) {
            PaperBook book = paperIt.next();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                paperIt.remove();
            }
        }
       
        Iterator<EBook> eIt = eBooks.iterator();
        while (eIt.hasNext()) {
            EBook book = eIt.next();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                eIt.remove();
            }
        }
        
        Iterator<ShowcaseBook> sIt = showcaseBooks.iterator();
        while (sIt.hasNext()) {
            ShowcaseBook book = sIt.next();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                sIt.remove();
            }
        }
        return removed;
    }

    
    

    
    

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        // Check if the input is valid or not
        if (isbn == null || quantity <= 0 || email == null || address == null) {
            throw new Exception("Invalid input parameters");
        }
    
         
        Book targetBook = null;
        for (Book book : getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                targetBook = book;
                break;
            }
        }
    
        if (targetBook == null) {
            throw new Exception("Book with ISBN: " + isbn + " not found.");
        }
    
        // because showcase books are not for sale, i'll throw an exception :D
        if (targetBook instanceof ShowcaseBook) {
            throw new Exception("ShowcaseBook with ISBN: " + isbn + " is not for sale.");
        }
        else if (targetBook instanceof PaperBook) {
            PaperBook pb = (PaperBook) targetBook;
            if (pb.getStock() < quantity) {
                throw new Exception("Not enough stock for PaperBook with ISBN: " + isbn);
            }
            pb.setStock(pb.getStock() - quantity);
            ShippingService.send(pb, address);
            return pb.getPrice() * quantity;
        }
        else if (targetBook instanceof EBook) {
            EBook eb = (EBook) targetBook;
            MailService.send(eb, email);
            return eb.getPrice() * quantity;
        }
    
        // This line should be  unreachable if all book types are covered but is still needed to make the code compile
        throw new Exception("Unsupported book type.");
    }


    public List<PaperBook> getPaperBooks() { return paperBooks; }
    public List<EBook> getEBooks() { return eBooks; }
    public List<ShowcaseBook> getShowcaseBooks() { return showcaseBooks; }

    public List<Book> getBooks() {
        List<Book> all = new ArrayList<>();
        all.addAll(paperBooks);
        all.addAll(eBooks);
        all.addAll(showcaseBooks);
        return all;
    }
} 