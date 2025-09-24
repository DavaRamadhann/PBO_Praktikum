// File: Food.java
public class Food extends Goods {
    private int calories;

    public Food(String description, double price, int calories) {
        super(description, price); // Memanggil constructor parent
        this.calories = calories;
    }

    @Override
    public void display() {
        System.out.println("--- FOOD ---");
        super.display(); // Memanggil display() dari parent
        System.out.println("Calories: " + calories);
    }
}