package bai6_ke_thua.bai_tap.e3_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(1);
        point.setY(2);
        System.out.println(point.toString());

        MoveablePoint moveablePoint = new MoveablePoint();
        moveablePoint.setX(1);
        moveablePoint.setY(2);
        System.out.println(moveablePoint.toString());

        moveablePoint.setxSpeed(5);
        moveablePoint.setySpeed(5);
        System.out.println(moveablePoint.move());
    }
}
