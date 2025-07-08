# Fawry Book Store

A Java-based online book store system that demonstrates object-oriented programming concepts with inheritance, polymorphism, and exception handling.

## Project Structure

### Core Classes

- **`Book.java`** - Abstract base class for all book types
  - Contains common properties: ISBN, title, year, price
  - Provides getters and setters for basic book information

- **`PaperBook.java`** - Extends Book class
  - Additional property: stock quantity
  - Can be shipped to physical addresses
  - Stock is reduced when purchased

- **`EBook.java`** - Extends Book class
  - Additional property: file type (PDF, EPUB, etc.)
  - Can be sent via email
  - No stock management (unlimited copies)

- **`ShowcaseBook.java`** - Extends Book class
  - Not for sale (price always 0)
  - Used for display/demo purposes only

### Management Classes

- **`Inventory.java`** - Manages the book store inventory
  - Maintains separate lists for each book type
  - Methods for adding, removing outdated books, and purchasing
  - Handles stock management and service integration

- **`ShippingService.java`** - Stub service for shipping paper books
- **`MailService.java`** - Stub service for emailing e-books

### Testing

- **`BookStoreTest.java`** - Demonstrates all system functionality
  - Tests adding books to inventory
  - Tests removing outdated books
  - Tests purchasing different book types
  - Tests error handling for invalid operations

## Features

### 1. Book Management
- Add books of any type to inventory
- Remove outdated books (configurable age threshold)
- Separate storage for different book types

### 2. Purchasing System
- Buy books by ISBN with quantity specification
- Automatic stock reduction for paper books
- Error handling for insufficient stock
- Integration with shipping and email services

### 3. Book Types Support
- **Paper Books**: Physical books with stock management and shipping
- **E-Books**: Digital books with email delivery
- **Showcase Books**: Display-only books (not for sale)

## Usage Examples

### Adding Books
```java
Inventory inventory = new Inventory();

PaperBook pb = new PaperBook("ISBN001", "Java Basics", 2018, 100.0, 5);
EBook eb = new EBook("ISBN002", "Learn Python", 2020, 50.0, "PDF");
ShowcaseBook sb = new ShowcaseBook("ISBN003", "Rare Book", 1990);

inventory.addBook(pb);
inventory.addBook(eb);
inventory.addBook(sb);
```

### Purchasing Books
```java
try {
    double paid = inventory.buyBook("ISBN001", 2, "buyer@gmail.com", "123 Main St");
    System.out.println("Paid: " + paid);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Removing Outdated Books
```java
List<Book> removed = inventory.removeOutdatedBooks(20, 2024);
for (Book book : removed) {
    System.out.println("Removed: " + book.getTitle());
}
```

## Error Handling

The system handles various error scenarios:
- Insufficient stock for paper books
- Attempting to purchase showcase books
- Books not found in inventory
- Invalid operations

## Running the Project

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the test class:
   ```bash
   java BookStoreTest
   ```

## Design Patterns

- **Inheritance**: Book hierarchy with common base class
- **Polymorphism**: Different book types handled uniformly
- **Exception Handling**: Robust error management
- **Separation of Concerns**: Inventory management separate from book types

![image](https://github.com/user-attachments/assets/099b3abf-b535-46f4-9616-eb28ce7fb0de)
