package bai4_Class.Bai_tap.e1_pt_bac_2;

public class QuadraticEquation {
    private double a,b,c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        double delta = Math.pow(this.b,2) - 4 * this.a * this.c;
        return delta;
    }
    public String getRoot(){
        if (getDiscriminant() > 0){
            return "Root 1: " + getRoot1() + "\n" +"Root 2: " + getRoot2();
        }
        if (getDiscriminant() == 0){
            return "1 Root: " + get1Root();
        }
        return "The equation has no roots";
    }
    public double  getRoot1(){
        double root_1 = (-this.b + Math.pow(getDiscriminant(),0.5)) / (2 * a);
        return root_1;
    }
    public double  getRoot2(){
        double root_2 = (-this.b - Math.pow(getDiscriminant(),0.5)) / (2 * a);
        return root_2;
    }
    public double  get1Root(){
        double root_3 = - this.b / (2 * this.a);
        return root_3;
    }
}
