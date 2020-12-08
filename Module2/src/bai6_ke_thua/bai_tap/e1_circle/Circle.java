package bai6_ke_thua.bai_tap.e1_circle;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    public String toString(){
        return "Circle area: " + getArea() + " Color: " + getColor();
    }
}
