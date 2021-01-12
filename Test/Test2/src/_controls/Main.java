package _controls;

import _models.VerifiedMobileManager;

public class Main {
    private static MainMenu mainMenu = new MainMenu();
    private static VerifiedMobileManager verifiedMobileManager = new VerifiedMobileManager();
    public static void main(String[] args) {
        verifiedMobileManager.readVerifiedMobile();
        mainMenu.mainMenu();
    }
}
