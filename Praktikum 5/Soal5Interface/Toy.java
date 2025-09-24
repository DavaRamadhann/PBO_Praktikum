// File: Toy.java
public class Toy extends Goods implements Taxable {
    private int minimumAge;

    public Toy(String description, double price, int minimumAge) {
        super(description, price);
        this.minimumAge = minimumAge;
    }

    // Harus mengimplementasikan method dari interface Taxable
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public void display() {
        System.out.println("--- TOY ---");
        super.display();
        System.out.println("Minimum Age: " + minimumAge);
        System.out.printf("Tax: $%.2f\n", calculateTax());
    }
}