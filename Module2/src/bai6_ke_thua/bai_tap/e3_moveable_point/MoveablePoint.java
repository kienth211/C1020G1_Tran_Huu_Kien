package bai6_ke_thua.bai_tap.e3_moveable_point;

import java.util.Arrays;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    private float[] array = new float[2];

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = getxSpeed();
        this.ySpeed = getySpeed();
    }

    public float[] getSpeed(){
        array[0] = getxSpeed();
        array[1] = getySpeed();
        return array;
    }

    public String toString(){
        return super.toString() + " xSpeed, ySpeed: " + Arrays.toString(getSpeed());
    }

    public MoveablePoint move(){
        setX(getX() + getySpeed());
        setY(getY() + getySpeed());
        return this;
    }
}
