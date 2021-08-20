import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
