package controllers;

import models.activities.BookingManager;
import models.activities.CinemaManager;
import models.function.Input;
import models.person.Customer;
import models.person.CustomerManager;
import models.person.EmployeeManager;
import models.services.*;

public class MainController {
    private static VillaManager villaManager = new VillaManager();
    private static HouseManager houseManager = new HouseManager();
    private static RoomManager roomManager = new RoomManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static BookingManager bookingManager = new BookingManager();
    private static EmployeeManager employeeManager = new EmployeeManager();
    private static CinemaManager cinemaManager = new CinemaManager();
    private static Input input = new Input();
    static int choice;

    //MAIN CONTROLLER
    private static void mainController() {
        choice = 0;
        while (choice != 9) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Add New Services" + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Add New Customer" + "\n" +
                    "4. Show Information of Customer" + "\n" +
                    "5. Add New Booking" + "\n" +
                    "6. Show Information of Employee" + "\n" +
                    "7. Cinema Manager" + "\n" +
                    "8. Employee Manager" + "\n" +
                    "9. Exit");
            System.out.println("Input choice:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    showInfoCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInfoEmployee();
                    break;
                case 7:
                    cinemaManager();
                    break;
                case 8:
                    stackEmployeeManager();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    //ADD SERVICE
    private static void addNewServices() {
        choice = 0;
        while (choice != 4) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Add New Villa" + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            System.out.println("Input choice:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    mainController();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void addNewVilla() {
        villaManager.addNewVilla();
    }

    private static void addNewHouse() {
        houseManager.addNewHouse();
    }

    private static void addNewRoom() {
        roomManager.addNewRoom();
    }

    //SHOW SERVICE
    private static void showService() {
        choice = 0;
        while (choice != 7) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Show All Villa" + "\n" +
                    "2. Show All House" + "\n" +
                    "3. Show All Room" + "\n" +
                    "4. Show All Name Villa Not Duplicate" + "\n" +
                    "5. Show All Name House Not Duplicate" + "\n" +
                    "6. Show All Name Room Not Duplicate" + "\n" +
                    "7. Back to menu" + "\n" +
                    "8. Exit");
            System.out.println("Input choice:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    showAllVilla();
                    break;
                case 2:
                    showAllHouse();
                    break;
                case 3:
                    showAllRoom();
                    break;
                case 4:
                    showNameNotDupVilla();
                    break;
                case 5:
                    showNameNotDupHouse();
                    break;
                case 6:
                    showNameNotDupRoom();
                    break;
                case 7:
                    mainController();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void showAllVilla() {
        villaManager.displayVilla();
    }

    private static void showAllHouse() {
        houseManager.displayHouse();
    }

    private static void showAllRoom() {
        roomManager.displayRoom();
    }

    private static void showNameNotDupVilla() {
        villaManager.displayNotDuplicateNameVilla();
    }

    private static void showNameNotDupHouse() {
        houseManager.displayNotDuplicateNameHouse();
    }

    private static void showNameNotDupRoom() {
        roomManager.displayNotDuplicateNameRoom();
    }

    //ADD CUSTOMER
    private static void addCustomer() {
        customerManager.addNewCustomer();
    }

    //SHOW CUSTOMER
    private static void showInfoCustomer() {
        customerManager.showInfoCustomer();
    }

    //ADD BOOKING
    private static void addNewBooking() {
        choice = 0;
        Customer tempCustomer;
        Villa tempVilla;
        House tempHouse;
        Room tempRoom;
        while (choice != 4) {
            customerManager.showListInfoCustomer();
            System.out.println("Input index customer:");
            tempCustomer = customerManager.getCustomerByIndex();
            System.out.println("=/Menu/=" + "\n" +
                    "1. Booking Villa" + "\n" +
                    "2. Booking House" + "\n" +
                    "3. Booking Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            System.out.println("Input choice:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    villaManager.showListInfoVilla();
                    System.out.println("Input index villa:");
                    tempVilla = villaManager.getVillaByIndex();
                    bookingVilla(tempVilla, tempCustomer);
                    mainController();
                    break;
                case 2:
                    houseManager.showListInfoHouse();
                    System.out.println("Input index house:");
                    tempHouse = houseManager.getHouseByIndex();
                    bookingHouse(tempHouse, tempCustomer);
                    mainController();
                    break;
                case 3:
                    roomManager.showListInfoRoom();
                    System.out.println("Input index room:");
                    tempRoom = roomManager.getRoomByIndex();
                    bookingRoom(tempRoom, tempCustomer);
                    mainController();
                    break;
                case 4:
                    mainController();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void bookingVilla(Villa villa, Customer customer) {
        bookingManager.addNewBooking(villa, customer);
    }

    private static void bookingHouse(House house, Customer customer) {
        bookingManager.addNewBooking(house, customer);
    }

    private static void bookingRoom(Room room, Customer customer) {
        bookingManager.addNewBooking(room, customer);
    }

    //SHOW EMPLOYEE
    private static void showInfoEmployee() {
        employeeManager.showInfoEmployee();
    }

    //CINEMA MANAGER
    private static void cinemaManager() {
        choice = 0;
        while (choice != 3) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Add Customer to Queue" + "\n" +
                    "2. Show Queue" + "\n" +
                    "3. Back to menu" + "\n" +
                    "5. Exit");
            System.out.println("Input choice:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    customerManager.showListInfoCustomer();
                    System.out.println("Input index customer:");
                    cinemaManager.addCustomerQueueCinema(
                            customerManager.getCustomerByIndex()
                    );
                    break;
                case 2:
                    cinemaManager.showCustomerQueueCinema();
                    break;
                case 3:
                    mainController();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    //EMPLOYEE MANAGER
    private static void stackEmployeeManager() {
        employeeManager.showStackListInfoEmployee();
        System.out.println("Input id employee:");
        employeeManager.showStackInfoEmployee(input.inputString());
    }

    public static void main(String[] args) {
        villaManager.readVilla();
        houseManager.readHouse();
        roomManager.readRoom();
        customerManager.readCustomer();
        employeeManager.readEmployee();
//        System.out.println("add");
//        String str = input.inputString();
//        villaManager.containVillaList(str);
        villaManager.deleteVilla();
//        mainController();
    }
}
