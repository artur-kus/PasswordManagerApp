package passwordmanager;

import passwordmanager.account.AccountService;
import passwordmanager.website.WebsiteService;

import java.util.Scanner;

public class Menu {

    private final WebsiteService websiteService;
    private final AccountService accountService;

    public Menu(WebsiteService websiteService, AccountService accountService) {
    this.websiteService = websiteService;
    this.accountService= accountService;
    }

    private void printMenu() {
        System.out.println("1. ADD WEBSITE");
        System.out.println("2. ADD ACCOUNT");
        System.out.println("3. SHOW WEBSITES");
        System.out.println("4. SHOW ACCOUNTS FOR WEBSITES");
        System.out.println("0. EXIT");
    }

    public void start() {
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
                    websiteService.printWebsites();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}
