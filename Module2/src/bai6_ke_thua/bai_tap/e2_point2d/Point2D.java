package bai6_ke_thua.bai_tap.e2_point2d;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    private float[] array = new float[2];

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        array[0] = getX();
        array[1] = getY();
        return array;
    }

    public String toString(){
        return "x,y: " + Arrays.toString(getXY());
    }
}
