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
            int index = websites.indexOf(website)+1;
            System.out.format("%d. %s\n", index, website.getNameOfWebsite());
        }
        System.out.println();
    }

}
