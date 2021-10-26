package passwordmanager.website;


import passwordmanager.account.Account;

import java.sql.*;
import java.util.ArrayList;
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
        System.out.println("Website save successfully.");
    }

//public void printWebsites() {
//    List<Website> websiteList = websiteDao.getWebsites();
//    printWebsites(websiteList);
//}

    private void printWebsites(List<Website> websites) {
        for (Website website : websites) {
            int index = websites.indexOf(website) + 1;
            System.out.format("%d. %s\n", index, website.getNameOfWebsite());
        }
        System.out.println();
    }

    public Optional<Website> getWebsiteFromUser() {
        System.out.println("List of websites:");
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

    public void printAccountsToWebsite(List<Account> list) throws SQLException {
        Optional<Website> method = getWebsiteFromUser();
        if (list.size() >= 1) {
            System.out.println("Passwords for website: " + method.get().getNameOfWebsite());
            for (Account account : list) {
                System.out.println(account);
            }
        } else if (list.size() == 0) {
            System.out.println("Website " + method.get().getNameOfWebsite() + ", doesn't have any account.");
        } else {
            System.out.println("Website doesn't exist.");
        }
    }

//    public void printWebsites() {
//        try {
//            Connection connection;
//            connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/password_menager", "admin", "admin123");
//
//            List<Account> list = new ArrayList<>();
//            Optional<Website> method = getWebsiteFromUser();
//            if (method.isPresent()) {
//                String query = "select name_of_website, mail, password, description from account LEFT JOIN website w on account.website_id = w.id " +
//                        "WHERE website_id=\"" + method.get().getId() + "\" ORDER BY name_of_website;";
//                PreparedStatement preparedStmt = connection.prepareStatement(query);
//                ResultSet result = preparedStmt.executeQuery(query);
//                while (result.next()) {
//
//                    String mail = result.getString("mail");
//                    String password = result.getString("password");
//                    String description = result.getString("description");
//                    Account account = new Account(method.get().getId(), mail, password, description);
//                    list.add(account);
//                }
//                if(list.size()>=1) {
//                    System.out.println("Passwords for website: " + method.get().getNameOfWebsite());
//                    for (Account account : list) {
//                        System.out.println(account);
//                    }
//                } else if(list.size()==0){
//                    System.out.println("Website " + method.get().getNameOfWebsite() + ", doesn't have any account.");
//                } else {
//                    System.out.println("Website doesn't exist.");
//                }
//            }
//
//        } catch (SQLException throwables) {
//            System.out.println("Error: " + throwables.getMessage());
//        }
//    }
}