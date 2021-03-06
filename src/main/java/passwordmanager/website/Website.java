package passwordmanager.website;

import passwordmanager.account.Account;

import java.util.Scanner;

public class Website {

    private String nameOfWebsite;
    private String id;
    private Account Account;

    public Website(String nameOfWebsite, String id, passwordmanager.account.Account account) {
        this.nameOfWebsite = nameOfWebsite;
        this.id = id;
        Account = account;
    }

    public String getNameOfWebsite() {
        return nameOfWebsite;
    }

    public void setNameOfWebsite(String nameOfWebsite) {
        this.nameOfWebsite = nameOfWebsite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nameOfWebsite + ":" + id;
    }


    public static Website fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of website: ");
        String nameOfWebsite = scanner.nextLine();
        return new Website(nameOfWebsite, null, null);
    }

}
