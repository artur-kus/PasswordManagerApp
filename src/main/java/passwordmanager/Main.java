package passwordmanager;

import passwordmanager.account.AccountDao;
import passwordmanager.account.AccountService;
import passwordmanager.website.WebsiteDao;
import passwordmanager.website.WebsiteService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WebsiteDao websiteDao = new WebsiteDao();
        WebsiteService websiteService = new WebsiteService(websiteDao);
        AccountDao accountDao = new AccountDao();
        AccountService accountService = new AccountService(accountDao);
        Menu menu = new Menu(websiteService, accountService);
        menu.start();
    }

}
