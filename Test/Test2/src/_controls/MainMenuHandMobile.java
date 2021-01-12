package _controls;

import _function.Input;
import _models.HandMobile;

public class MainMenuHandMobile {
    private Input input = new Input();
    private HandMobile handMobile = new HandMobile();
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
//                    handMobile.addVMobile();
                    break;
                case 2:
//                    handMobile.deleteVerifiedMobile();
                    break;
                case 3:
//                    handMobile.showListInfoVerifiedMobile();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}
