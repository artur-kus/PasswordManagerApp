import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WebsiteDao {

   private final UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
   private final Connection connection;

    public WebsiteDao() throws SQLException {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/password_menager", "admin", "admin123");
    }


    public void addWebsite(Website website) {
        try{
        String query = ("INSERT INTO website (id, name_of_website, link) VALUES (?, ?, ?)");
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, uniqueIdGenerator.generateId());
        preparedStmt.setString(2, website.getNameOfWebsite());
        preparedStmt.setString(3, website.getLink());
        preparedStmt.execute();
        }
        catch(SQLException throwables){
            System.out.println("Error: " + throwables.getMessage());
        }
    }

    public void printWebsites(){
        try{
            String query = ("select name_of_website, link from website");
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery(query);
            while (result.next())
            {
                String nameOfWebsite = result.getString("name_of_website");
                String link = result.getString("link");
                System.out.format("%s | %s\n", nameOfWebsite, link);
            }
            preparedStmt.execute();
        } catch (SQLException throwables) {
            System.out.println("Error " + throwables.getMessage());
        }
    }
}
