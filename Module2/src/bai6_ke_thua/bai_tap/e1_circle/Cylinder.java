package bai6_ke_thua.bai_tap.e1_circle;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

//    @Override
//    public double getArea() {
//        return getRadius() * getRadius() * height * Math.PI;
//    }

    @Override
    public String toString(){
        return "Cylinder Volume: " + (getArea() * getHeight())
                + " Color: " + getColor();
    }

}
