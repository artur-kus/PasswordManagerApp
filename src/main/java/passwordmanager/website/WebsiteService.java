package passwordmanager.website;

import java.util.List;

public class WebsiteService {

    private final WebsiteDao websiteDao;

    public WebsiteService(WebsiteDao websiteDao) {
        this.websiteDao = websiteDao;
    }

    public void addWebsite() {
        Website website = Website.fromUserInput();
        websiteDao.addWebsite(website);
    }

    public void printWebsites() {
        List<Website> websites = websiteDao.getWebsites();
        for (Website website : websites) {
            System.out.format("%s\n", website.getNameOfWebsite());
        }
    }

}
