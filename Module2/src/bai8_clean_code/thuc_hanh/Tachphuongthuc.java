package bai8_clean_code.thuc_hanh;

public class Tachphuongthuc {
    public static void main(String[] args) {
        System.out.println(getBaseArea(10));
        System.out.println(getVolume(10,10));
    }
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
