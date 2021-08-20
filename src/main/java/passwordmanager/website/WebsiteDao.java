package passwordmanager.website;

import passwordmanager.UniqueIdGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class WebsiteDao {

    private final UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
    private final Connection connection;

    public WebsiteDao() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/password_menager", "admin", "admin123");
    }


    public void addWebsite(Website website) {
        try {
            String query = ("INSERT INTO website (id, name_of_website) VALUES (?, ?)");
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, uniqueIdGenerator.generateId());
            preparedStmt.setString(2, website.getNameOfWebsite());
            preparedStmt.execute();
        } catch (SQLException throwables) {
            System.out.println("Error: " + throwables.getMessage());
        }
    }

    public List<Website> getWebsites() {
        List<Website> listOfWebsite = new ArrayList<>();
        try {
            String query = ("select name_of_website, id from website");
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery(query);
            while (result.next()) {
                String nameOfWebsite = result.getString("name_of_website");
                String idWebsite = result.getString("id");
                Website website = new Website(nameOfWebsite, idWebsite);
                listOfWebsite.add(website);
            }
            preparedStmt.execute();
        } catch (SQLException throwables) {
            System.out.println("Error " + throwables.getMessage());
        }
        return listOfWebsite;
    }
}
