package passwordmanager.account;

import passwordmanager.website.Website;
import passwordmanager.website.WebsiteService;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private final AccountDao accountDao;
    private final WebsiteService websiteService;

    public AccountService(AccountDao accountDao, WebsiteService websiteService) {
        this.accountDao = accountDao;
        this.websiteService = websiteService;
    }

    public void addAccount() {
        Optional<Website> targetWebsiteId = websiteService.getWebsiteFromUser();
        if (targetWebsiteId.isPresent()) {
            Account account = Account.fromUserInput();
            account.setWebsiteId(targetWebsiteId.get().getId());
            accountDao.addAccount(account);
            System.out.println("Account save successfully.");
        } else {
            System.out.println("Adding account cancelled.");
        }
    }

    public void printAccounts() {
        List<Account> accountList = accountDao.getAccounts();
        printAccounts(accountList);
    }



    public void printAccounts(List<Account> accounts) {
        for (Account account : accounts){
            int index = accounts.indexOf(account) +1;
            System.out.format("%d. %s\n", index, account.toString());
        }
        System.out.println();
    }

//    public void printWebsites() {
//        try {
//            Connection connection;
//            connection =  DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/password_menager", "admin", "admin123");
//            List<Website> websiteList = websiteDao.getWebsites();
//            printWebsites(websiteList);
//            String outIdFromUser = getWebsiteFromUser().get().getId();
//            System.out.println(outIdFromUser);
//            String query = "select name_of_website, mail, password, description from account LEFT JOIN website w on account.website_id = w.id " +
//                    "WHERE website_id=\"" + outIdFromUser + "\" ORDER BY name_of_website;";
//            System.out.println(query);
//            PreparedStatement preparedStmt = connection.prepareStatement(query);
//            ResultSet result = preparedStmt.executeQuery(query);
//        } catch (
//                SQLException throwables) {
//            System.out.println("Error: " + throwables.getMessage());
//        }
//    }
}
