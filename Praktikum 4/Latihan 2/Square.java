// File: Square.java
public class Square extends Rectangle {

    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side); // Panggil constructor superclass Rectangle(width, length) [cite: 226]
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth(); // Sisi bisa didapat dari width atau length
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    // Override setWidth dan setLength untuk menjaga properti persegi
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}