package bai1_Introduction_to_Java.bai_tap.e1_Greeting;

import java.util.Scanner;
public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: " + name);
    }
}

