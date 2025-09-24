// File: Taxable.java
public interface Taxable {
    // Variabel di interface secara otomatis public, static, dan final
    double taxRate = 0.06; // 6% tax rate [cite: 345]

    // Method di interface secara otomatis public dan abstract
    double calculateTax(); // [cite: 345]
}