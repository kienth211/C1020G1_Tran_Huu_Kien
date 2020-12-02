package bai4_class.bai_tap.e1_pt_bac_2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation qua = new QuadraticEquation(a,b,c);
        System.out.print(qua.getRoot());
    }
}
