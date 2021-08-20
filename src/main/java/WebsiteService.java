import java.util.HashMap;
import java.util.Map;

public class WebsiteService {

   private final WebsiteDao websiteDao;

    public WebsiteService(WebsiteDao websiteDao) {
        this.websiteDao = websiteDao;
    }

    public void addWebsite(){
       Website website = Website.fromUserInput();
        websiteDao.addWebsite(website);
    }

    public void printWebsites(){
        websiteDao.printWebsites();
    }
}
