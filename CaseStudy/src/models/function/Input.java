package models.function;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean status;

    public String inputString() {
        return scanner.nextLine();
    }

    public int inputInt() {
        int num = 0;
        do {
            try {
                status = true;
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                status = false;
                System.err.println("Not 'int' type, Input again:");
            }
        } while (!status);
        return num;
    }

    public double inputDouble() {
        double num = 0;
        do {
            try {
                status = true;
                num = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                status = false;
                System.err.println("Not 'double' type, Input again:");
            }
        } while (!status);
        return num;
    }
}
