package controllers;

import models.Services;
import models.Villa;
import models.VillaManager;

import java.util.Arrays;
import java.util.Scanner;

public class MainController {
    private static VillaManager list = new VillaManager();
    private static Scanner scanner = new Scanner(System.in);
    static int choice;

    private static boolean regexName() {
        String[] strArr;

        return true;
    }

    private static boolean regexMaxPeople(int num) {
        return num > 0 && num < 20;
    }

    private static boolean regexPrice(int num) {
        return num > 0;
    }

    private static boolean regexFloors(int num) {
        return num > 0;
    }

    private static void regexBirthday(String date) {
        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
        StringBuilder stringBuilder = new StringBuilder(date);
        int yearCustomer;
        if (date.matches(regex)) {
            stringBuilder.delete(0, 6);
            System.out.println(stringBuilder);
            yearCustomer = Integer.parseInt(stringBuilder.toString());
            if ((2020 - yearCustomer) > 18) {
                System.out.println(">18");
            } else {
                System.out.println("<18");
            }
        } else {
            System.out.println("wrong");
        }
    }

    private static void regexServiceName() {
        String regex = "(SV)(VL|HO|RO)-[0-9]{4}";
        System.out.println("ServiceName:");
        String serviceName = scanner.nextLine();
        if (serviceName.matches(regex)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static void regexAdditionServiceName(){
        String regex = "(Massage|Karaoke|Food|Drink|Car)";
        System.out.println("Addition Service Name:");
        String additionServiceName = scanner.nextLine();
        if (additionServiceName.matches(regex)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean regexPoolArea(){
        int area = Integer.parseInt(scanner.nextLine());
        return area > 30;
    }

    private static void addNewVilla() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        list.addNewService(new Villa(name));
    }

    private static void showVilla() {
        list.displayVilla();
    }

    private static void showNameNotDupVilla() {
        list.displayNotDuplicateNameVilla();
    }

    private static void addNewServices() {
        while (choice != 4) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Add New Villa" + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            System.out.println("Input choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    showVilla();
                    break;
                case 3:
                    showNameNotDupVilla();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public static void main(String[] args) {
        list.addNewService(new Villa("Villa_1"));
        list.addNewService(new Villa("Villa_1"));
        list.addNewService(new Villa("Villa_1"));
        list.addNewService(new Villa("Villa_2"));
        list.addNewService(new Villa("Villa_3"));
        while (choice != 7) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Add New Services" + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Add New Customer" + "\n" +
                    "4. Show Information of Customer" + "\n" +
                    "5. Add New Booking" + "\n" +
                    "6. Show Information of Employee" + "\n" +
                    "7. Exit");
            System.out.println("Input choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
