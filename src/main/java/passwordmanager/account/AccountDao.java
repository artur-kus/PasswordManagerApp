package passwordmanager.account;

import passwordmanager.UniqueIdGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
