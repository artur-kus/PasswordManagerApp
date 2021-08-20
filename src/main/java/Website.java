import java.util.Scanner;

public class Website {

    private String nameOfWebsite;
    private String link;

    public Website(String nameOfWebsite, String link) {
        this.nameOfWebsite = nameOfWebsite;
        this.link = link;
    }


    public String getNameOfWebsite() {
        return nameOfWebsite;
    }

    public void setNameOfWebsite(String nameOfWebsite) {
        this.nameOfWebsite = nameOfWebsite;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return nameOfWebsite + ":" + link;
    }


    public static Website fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of website: ");
        String nameOfWebsite = scanner.nextLine();
        System.out.println("Enter link to website: ");
        String link = scanner.nextLine();
        return new Website(nameOfWebsite, link);
    }

}
