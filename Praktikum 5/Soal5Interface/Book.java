// File: Book.java
public class Book extends Goods implements Taxable {
    private String author;

    public Book(String description, double price, String author) {
        super(description, price);
        this.author = author;
    }
    
    // Harus mengimplementasikan method dari interface Taxable
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public void display() {
        System.out.println("--- BOOK ---");
        super.display();
        System.out.println("Author: " + author);
        System.out.printf("Tax: $%.2f\n", calculateTax());
    }
}