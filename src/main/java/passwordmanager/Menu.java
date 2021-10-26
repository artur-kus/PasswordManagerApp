package passwordmanager;

import passwordmanager.account.AccountDao;
import passwordmanager.account.AccountService;
import passwordmanager.website.WebsiteService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final WebsiteService websiteService;
    private final AccountService accountService;

    public Menu(WebsiteService websiteService, AccountService accountService) {
    this.websiteService = websiteService;
    this.accountService= accountService;
    }
    private void printBaner(){
        System.out.println(" _____                                    _   __  __                                              _____  _____  \n" +
                "|  __ \\                                  | | |  \\/  |                                       /\\   |  __ \\|  __ \\ \n" +
                "| |__) |_ _ ___ _____      _____  _ __ __| | | \\  / | __ _ _ __   __ _  __ _  ___ _ __     /  \\  | |__) | |__) |\n" +
                "|  ___/ _` / __/ __\\ \\ /\\ / / _ \\| '__/ _` | | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|   / /\\ \\ |  ___/|  ___/ \n" +
                "| |  | (_| \\__ \\__ \\\\ V  V / (_) | | | (_| | | |  | | (_| | | | | (_| | (_| |  __/ |     / ____ \\| |    | |     \n" +
                "|_|   \\__,_|___/___/ \\_/\\_/ \\___/|_|  \\__,_| |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|    /_/    \\_\\_|    |_|     \n" +
                "                                                                        __/ |                                   \n" +
                "                                                                       |___/                                    ");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("PASSWORD MANAGER APP");
        System.out.println("1. ADD WEBSITE");
        System.out.println("2. ADD ACCOUNT TO WEBSITE");
        System.out.println("3. SHOW ACCOUNTS & WEBSITES");
        System.out.println("0. EXIT");
    }

    public void start() {
        printBaner();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            printMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    websiteService.addWebsite();
                    break;
                case 2:
                    accountService.addAccount();
                    break;
                case 3:
                    try {
                        AccountDao accountDao = new AccountDao();
                        websiteService.printAccountsToWebsite(accountDao.saveAccountsToWebsite(websiteService.getWebsiteFromUser()));
                    } catch (SQLException throwables) {
                        System.out.println("Error: " + throwables.getMessage());
                    }
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}
