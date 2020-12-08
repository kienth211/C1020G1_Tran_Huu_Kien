package bai7_abstract_class_interface.bai_tap.e2_colorable;

import bai7_abstract_class_interface.thuc_hanh.p2_compare.Circle;
import bai7_abstract_class_interface.thuc_hanh.p2_compare.Rectangle;
import bai7_abstract_class_interface.thuc_hanh.p2_compare.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new SquareColorable();

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            if (shape instanceof SquareColorable){
                shape.howToColor();
            }
            else {
                System.out.println("Area: " + shape.getArea());
            }
        }
    }
}
