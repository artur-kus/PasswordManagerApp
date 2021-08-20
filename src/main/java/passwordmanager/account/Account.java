package passwordmanager.account;

import java.util.Objects;
import java.util.Scanner;

public class Account {
    private String websiteId;
    private String mail;
    private String password;
    private String description;

    public Account(String nameOfWebsite, String mail, String password, String description) {
        this.websiteId = nameOfWebsite;
        this.mail = mail;
        this.password = password;
        this.description = description;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return mail.equals(account.mail) && password.equals(account.password) && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, password, description);
    }

    @Override
    public String toString() {
        return "Email: " + mail + " | password: " + password + " | description: " + description;
    }

    public static Account fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of website to add account: ");
        String nameOfWebsite = scanner.nextLine();
        System.out.println("Enter email: ");
        String mail = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        return new Account(nameOfWebsite, mail, password, description);
    }
}
