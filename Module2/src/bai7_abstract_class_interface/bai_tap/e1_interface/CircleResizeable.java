package bai7_abstract_class_interface.bai_tap.e1_interface;

import bai7_abstract_class_interface.thuc_hanh.p2_compare.Circle;

public class CircleResizeable extends Circle implements Resizeable {
    public String resize(double percent) {
        return " Old Area: " + getArea() + "\t" + "Percent: " + percent + " % " +
                "\t" +" New Area: " + (getArea() + (getArea() * percent / 100));
    }
}
