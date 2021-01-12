package _controls;

import _function.*;
import _models.VerifiedMobileManager;

public class MainMenuVerifiedMobile {
    private Input input = new Input();
    private VerifiedMobileManager verifiedMobileManager = new VerifiedMobileManager();
    private int choice;
    public void mainMenu() {
        while (choice != 5) {
            System.out.println("=/Menu/=" + "\n" +
                    "1. Them moi" + "\n" +
                    "2. Xoa" + "\n" +
                    "3. Xem danh sach dien thoai" + "\n" +
                    "4. Tim kiem" + "\n" +
                    "5. Thoat ra Menu" + "\n" +
                    "6. Thoat");
            System.out.println("Chon:");
            choice = input.inputInt();
            switch (choice) {
                case 1:
                    verifiedMobileManager.addVMobile();
                    break;
                case 2:
                    verifiedMobileManager.deleteVerifiedMobile();
                    break;
                case 3:
                    verifiedMobileManager.showListInfoVerifiedMobile();
                    break;
                case 4:
//                    mainMenu.mainMenu();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}
