package bai7_abstract_class_interface.bai_tap.e1_interface;

public class Main {
    public static float getrandomNum(){
        return (float) Math.random() * 101;
    }
    public static void main(String[] args) {
        CircleResizeable[] circles = new CircleResizeable[3];
        circles[0] = new CircleResizeable();
        circles[1] = new CircleResizeable();
        circles[2] = new CircleResizeable();
        for (CircleResizeable circleResizeable: circles){
            circleResizeable.setRadius(10);
            System.out.println(circleResizeable.resize(getrandomNum()));
        }
    }
}
