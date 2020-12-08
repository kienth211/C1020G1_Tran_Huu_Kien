package bai7_abstract_class_interface.bai_tap.e2_colorable;

import bai7_abstract_class_interface.thuc_hanh.p2_compare.Square;

public class SquareColorable extends Square implements Colorable {
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
