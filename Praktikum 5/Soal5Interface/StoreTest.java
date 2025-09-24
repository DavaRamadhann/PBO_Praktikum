// File: StoreTest.java
public class StoreTest {
    public static void main(String[] args) {
        // Membuat array Goods yang bisa diisi oleh semua turunannya
        Goods[] items = new Goods[3];
        items[0] = new Food("Chocolate Bar", 1.50, 250);
        items[1] = new Toy("Lego Set", 49.99, 6);
        items[2] = new Book("The Hobbit", 14.99, "J.R.R. Tolkien");

        double totalTax = 0;

        for (Goods item : items) {
            item.display();
            
            // Cek apakah item tersebut merupakan instance dari Taxable
            if (item instanceof Taxable) {
                // Jika ya, kita bisa cast dan panggil method calculateTax()
                Taxable taxableItem = (Taxable) item;
                totalTax += taxableItem.calculateTax();
            }
            System.out.println(); // Spasi untuk pemisah
        }

        System.out.printf("=====================\n");
        System.out.printf("Total Tax for all taxable items: $%.2f\n", totalTax);
    }
}