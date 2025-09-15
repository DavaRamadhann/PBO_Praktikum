// File: Circle.java
/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle {
    // private instance variables
    private double radius;
    private String color;

    // Constructors (overloaded)
    /** Constructs a Circle instance with default value for radius and color */
    public Circle() { // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */
    public Circle(double r) { // 2nd constructor
        radius = r;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and color */
    public Circle(double r, String c) { // 3rd constructor
        radius = r;
        color = c;
    }

    /** Returns the radius */
    public double getRadius() {
        return radius;
    }

    /** Sets the radius */
    public void setRadius(double r) {
        this.radius = r;
    }

    /** Returns the color */
    public String getColor() {
        return color;
    }

    /** Sets the color */
    public void setColor(String c) {
        this.color = c;
    }

    /** Returns the area of this Circle instance */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Returns a self-descriptive string of this instance */
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}