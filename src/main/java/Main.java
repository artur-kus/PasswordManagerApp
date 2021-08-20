import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WebsiteDao websiteDao = new WebsiteDao();
        WebsiteService websiteService = new WebsiteService(websiteDao);
        Menu menu = new Menu(websiteService);
        menu.start();
    }

}
