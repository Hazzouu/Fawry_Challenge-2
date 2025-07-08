public class BookStoreTest {
    public static void main(String[] args) {
        
            Inventory inventory = new Inventory();

           
            PaperBook pb1 = new PaperBook("ISBN001", "Java Basics", 2018, 100.0, 5);
            EBook eb1 = new EBook("ISBN002", "Learn Python", 2020, 50.0, "PDF");
            ShowcaseBook sb1 = new ShowcaseBook("ISBN003", "Rare Book", 1990);
            double paid = 0;
            inventory.addBook(pb1);
            inventory.addBook(eb1);
            inventory.addBook(sb1);

            System.out.println("Books after adding:");
            for (Book b : inventory.getBooks()) {
                System.out.println(b.getTitle() + " (" + b.getIsbn() + ")");
            }

            // Remove outdated books (older than 20 years)
            int currentYear = 2024;
            System.out.println("\nRemoving outdated books (older than 20 years):");
            for (Book b : inventory.removeOutdatedBooks(20, currentYear)) {
                System.out.println("Removed: " + b.getTitle());
            }

            System.out.println("\nBooks after removing outdated:");
            for (Book b : inventory.getBooks()) {
                System.out.println(b.getTitle() + " (" + b.getIsbn() + ")");
            }

            // Buy a paper book
            System.out.println("\nBuying 2 copies of Java Basics:");
            try {
                 paid = inventory.buyBook("ISBN001", 2, "buyer@gmail.com", "123 Main St");
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
            System.out.println("Paid: " + paid);
            System.out.println("Stock left: " + pb1.getStock());

            // Buy an ebook
            System.out.println("\nBuying 1 copy of Learn Python:");
           
            try {
                 paid = inventory.buyBook("ISBN002", 1, "buyer@gmail.com", "123 Main St");
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
            System.out.println("Paid: " + paid);

            // Try to buy a showcase book (should throw exception)
            try {
                System.out.println("\nTrying to buy a showcase book:");
                inventory.buyBook("ISBN003", 1, "buyer@gmail.com", "123 Main St");
            } catch (Exception e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            // Try to buy more paper books than in stock (should throw exception)
            try {
                System.out.println("\nTrying to buy 10 copies of Java Basics:");
                inventory.buyBook("ISBN001", 10, "buyer@gmail.com", "123 Main St");
            } catch (Exception e) {
                System.out.println("Expected error: " + e.getMessage());
            }

       
        
    }
} 