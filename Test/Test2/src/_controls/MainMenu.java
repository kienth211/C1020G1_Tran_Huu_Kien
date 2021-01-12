package _controls;

import _function.Input;

public class MainMenu {
    private Input input = new Input();
    private MainMenuVerifiedMobile mainMenuVerifiedMobile = new MainMenuVerifiedMobile();
    private MainMenuHandMobile mainMenuHandMobile = new MainMenuHandMobile();
    private int choice;

    public void mainMenu() {
        while (choice != 3) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Dien thoai chinh hang" + "\n" +
                    "2. Dien thoai xach tay" + "\n" +
                    "3. Thoat");
            System.out.println("Chon:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    mainMenuVerifiedMobile.mainMenu();
                    break;
                case 2:
                    mainMenuHandMobile.mainMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}
