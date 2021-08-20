package passwordmanager.account;

import passwordmanager.website.Website;
import passwordmanager.website.WebsiteDao;

import java.util.List;
import java.util.Scanner;

public class AccountService {
    private final AccountDao accountDao;
    private final WebsiteDao websiteDao;

    public AccountService(AccountDao accountDao, WebsiteDao websiteDao) {
        this.accountDao = accountDao;
        this.websiteDao = websiteDao;
    }

    public void addAccount() {
        String targetWebsiteId = getTargetWebsiteIdFromUser();
        Account account = Account.fromUserInput();
        account.setWebsiteId(targetWebsiteId);
        accountDao.addAccount(account);
    }

    private String getTargetWebsiteIdFromUser() {
        System.out.println("Choose website:");
        List<Website> websites = websiteDao.getWebsites();
        printWebsites(websites);
        int number = getNumberFromUser();
        Website websiteFromUser = websites.get(number - 1);
        return websiteFromUser.getId();
    }

    private int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void printWebsites(List<Website> websites) {

        for (Website website : websites) {
            int index = websites.indexOf(website) + 1;
            System.out.format("%d. %s\n", index, website.getNameOfWebsite());
        }
        System.out.println();
    }
}
