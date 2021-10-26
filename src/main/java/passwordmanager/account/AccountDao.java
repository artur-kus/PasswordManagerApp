package passwordmanager.account;

import passwordmanager.UniqueIdGenerator;
import passwordmanager.website.Website;
import passwordmanager.website.WebsiteDao;
import passwordmanager.website.WebsiteService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDao {

    private final UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
    private final Connection connection;

    public AccountDao() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/password_menager", "admin", "admin123");
    }

    public void addAccount(Account account) {
        try {
            String query = ("INSERT INTO account (id, website_id, mail, password, description) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, uniqueIdGenerator.generateId());
            preparedStmt.setString(2, account.getWebsiteId());
            preparedStmt.setString(3, account.getMail());
            preparedStmt.setString(4, account.getPassword());
            preparedStmt.setString(5, account.getDescription());
            preparedStmt.execute();
        } catch (SQLException throwables) {
            System.out.println("Error: " + throwables.getMessage());
        }
    }

    public List<Account> getAccounts() {
        List<Account> listOfAccounts = new ArrayList<>();

        try {
            String query = ("select mail, password, description, website_id from account");
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery(query);
            while (result.next()) {
                String mail = result.getString("mail");
                String password = result.getString("password");
                String description = result.getString("description");
                String id = result.getString("website_id");
                Account account = new Account(id, mail, password, description);
                listOfAccounts.add(account);
            }
            preparedStmt.execute();
        } catch (SQLException throwables) {
            System.out.println("Error " + throwables.getMessage());
        }
        return listOfAccounts;
    }

    public List<Account> saveAccountsToWebsite(Optional<Website> optional) {
        List<Account> list = new ArrayList<>();
        try {
            if (optional.isPresent()) {
                String query = "select name_of_website, mail, password, description from account LEFT JOIN website w on account.website_id = w.id " +
                        "WHERE website_id=\"" + optional.get().getId() + "\" ORDER BY name_of_website;";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                ResultSet result = preparedStmt.executeQuery(query);
                while (result.next()) {

                    String mail = result.getString("mail");
                    String password = result.getString("password");
                    String description = result.getString("description");
                    Account account = new Account(optional.get().getId(), mail, password, description);
                    list.add(account);
                }
            }
        } catch (SQLException throwable) {
            System.out.println("Error: " + throwable.getMessage());
        }
        return list;
    }
}
