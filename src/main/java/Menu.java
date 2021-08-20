import java.util.Scanner;

public class Menu {

    private final WebsiteService websiteService;

    public Menu(WebsiteService websiteService) {
    this.websiteService = websiteService;
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
                    websiteService.printWebsites();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}
