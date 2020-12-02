package bai4_class.bai_tap.e3_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan_1 = new Fan();
        Fan fan_2 = new Fan();
        fan_1.setSpeed(3);
        fan_1.setRadius(10);
        fan_1.setColor("Yellow");
        fan_1.setOn(true);
        System.out.println(fan_1.toString());
        fan_2.setSpeed(2);
        fan_2.setRadius(5);
        fan_2.setColor("Blue");
        fan_2.setOn(false);
        System.out.println(fan_2.toString());
    }
}
