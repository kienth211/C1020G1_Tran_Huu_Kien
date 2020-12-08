package bai6_ke_thua.bai_tap.e2_point2d;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z = 0.0f;
    private float[] array = new float[3];

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        this.z = z;
    }

    public float[] getXYZ() {
        array[0] = getX();
        array[1] = getY();
        array[2] = getZ();
        return array;
    }

    public String toString(){
        return "x,y,z: " + Arrays.toString(getXYZ());
    }
}
