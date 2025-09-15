// File: TestCylinder.java
public class TestCylinder {
    public static void main(String[] args) {
        // Silinder dengan nilai default
        Cylinder c1 = new Cylinder();
        System.out.println("--- Cylinder 1 ---");
        System.out.println(c1.toString()); // Memanggil toString() yang di-override
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Height: " + c1.getHeight());
        System.out.println("Base Area: " + c1.getArea()); // Memanggil getArea() yang di-override (luas permukaan)
        System.out.println("Volume: " + c1.getVolume());

        // Silinder dengan tinggi 10.0
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("\n--- Cylinder 2 ---");
        System.out.println(c2.toString());
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Height: " + c2.getHeight());
        System.out.println("Base Area: " + c2.getArea());
        System.out.println("Volume: " + c2.getVolume());

        // Silinder dengan radius 2.0 dan tinggi 10.0
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("\n--- Cylinder 3 ---");
        System.out.println(c3.toString());
        System.out.println("Radius: " + c3.getRadius());
        System.out.println("Height: " + c3.getHeight());
        System.out.println("Base Area: " + c3.getArea());
        System.out.println("Volume: " + c3.getVolume());
    }
}