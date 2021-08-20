package passwordmanager.website;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WebsiteService {

    private final WebsiteDao websiteDao;

    public WebsiteService(WebsiteDao websiteDao) {
        this.websiteDao = websiteDao;
    }

    public void addWebsite() {
        Website website = Website.fromUserInput();
        websiteDao.addWebsite(website);
    }

    public void printWebsites() {
        List<Website> websiteList = websiteDao.getWebsites();
        printWebsites(websiteList);
    }

    private void printWebsites(List<Website> websites) {
        for (Website website : websites) {
            int index = websites.indexOf(website) + 1;
            System.out.format("%d. %s\n", index, website.getNameOfWebsite());
        }
        System.out.println();
    }

    public Optional<Website> getWebsiteFromUser() {
        System.out.println("Choose website:");
        List<Website> websites = websiteDao.getWebsites();
        printWebsites(websites);
        System.out.println("0. To cancel.");
        int number = getNumberFromUser();
        if (number == 0) {
            return Optional.empty();
        }
        if (number > websites.size() || number < 0) {
            System.out.println("Number is out of range.");
            return Optional.empty();
        }
        Website websiteFromUser = websites.get(number - 1);
        return Optional.of(websiteFromUser);
    }

    private int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}

