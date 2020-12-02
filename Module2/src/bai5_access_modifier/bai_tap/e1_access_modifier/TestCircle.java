package bai5_access_modifier.bai_tap.e1_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle_1 = new Circle();
        circle_1.setRadius(5);
        System.out.println(circle_1.getArea());
        Circle circle_2 = new Circle(10);
        System.out.println(circle_2.getArea());
    }
}
