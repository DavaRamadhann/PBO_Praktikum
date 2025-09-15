// File: Cylinder.java
public class Cylinder extends Circle {
    private double height; // private variable

    // Constructors
    public Cylinder() {
        super(); // panggil constructor superclass Circle() [cite: 77, 83]
        height = 1.0;
    }

    public Cylinder(double height) {
        super(); // panggil constructor superclass Circle() [cite: 83]
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius); // panggil constructor superclass Circle(r) [cite: 89]
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color); // panggil constructor superclass Circle(r, c)
        this.height = height;
    }

    /** Returns the height */
    public double getHeight() {
        return height;
    }

    /** Sets the height */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Returns the volume of this Cylinder instance */
    public double getVolume() {
        // Gunakan super.getArea() untuk menghindari pemanggilan method getArea() yang sudah di-override
        return super.getArea() * height;
    }

    /**
     * [Tugas 1.2] Overriding the getArea() method.
     * Mengoverride getArea() untuk menghitung luas permukaan silinder.
     * Luas permukaan = 2 * pi * r * h + 2 * luas alas
     */
    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
    }

    /**
     * [Tugas 1.3] Provide a toString() method.
     * Mengoverride toString() dari superclass Circle.
     */
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString() + " height=" + height; // Gunakan Circle's toString() [cite: 142]
    }
}