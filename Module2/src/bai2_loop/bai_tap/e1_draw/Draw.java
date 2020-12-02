package bai2_loop.bai_tap.e1_draw;

import java.util.Scanner;
public class Draw {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++){
                        for(int j = 0; j < 5; j++) {
                            if (j == 4){
                                System.out.println("*");
                            }
                            else {
                                System.out.print("*");
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++) {
                            if (j < i){
                                System.out.print("*");
                            }
                            if (j == i){
                                System.out.println("*");
                            }
                        }
                    }
                    System.out.println("---");
                    for (int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++) {
                            if (j < 4 - i){
                                System.out.print("*");
                            }
                            if (j == 4 - i){
                                System.out.println("*");
                            }
                        }
                    }
                    System.out.println("---");
                    for (int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++) {
                            if (j > i){
                                System.out.print("*");
                            }
                            if (j < i){
                                System.out.print(" ");
                            }
                            if (j == 4){
                                System.out.println("*");
                            }
                        }
                    }
                    System.out.println("---");
                    for (int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++) {
                            if (j > 4 - i){
                                System.out.print("*");
                            }
                            if (j < 4 - i){
                                System.out.print(" ");
                            }
                            if (j == 4){
                                System.out.println("*");
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 7; i++){
                        if (i < 4) {
                            for (int j = 0; j < 4; j++) {
                                if (j < i) {
                                    System.out.print("*");
                                }
                                if (j == i) {
                                    System.out.println("*");
                                }
                            }
                        }
                        else {
                            for (int j = 0; j < 5; j++) {
                                if (j < 6 - i) {
                                    System.out.print("*");
                                }
                                if (j == 6 - i) {
                                    System.out.println("*");
                                }
                            }
                        }
                    }

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
        while (choice != 0);
    }
}
