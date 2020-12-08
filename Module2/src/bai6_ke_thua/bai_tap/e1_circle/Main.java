package bai6_ke_thua.bai_tap.e1_circle;

public class Main {
    public static void main(String[] args) {
        Circle circle_1 = new Circle();
        circle_1.setRadius(5.0);
        circle_1.setColor("blue");
        System.out.println(circle_1.toString());

        Cylinder cylinder_1 = new Cylinder();
        cylinder_1.setRadius(10);
        cylinder_1.setColor("yellow");
        cylinder_1.setHeight(10);
        System.out.println(cylinder_1.toString());
    }
}
