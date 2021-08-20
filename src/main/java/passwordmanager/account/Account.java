package passwordmanager.account;

import java.util.Objects;
import java.util.Scanner;

public class Account {
    private String websiteId;
    private String mail;
    private String password;
    private String description;

    public Account(String websiteId, String mail, String password, String description) {
        this.websiteId = websiteId;
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


    public String getPassword() {
        return password;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(websiteId, account.websiteId) && mail.equals(account.mail) && password.equals(account.password) && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(websiteId, mail, password, description);
    }

    @Override
    public String toString() {
        return "Email: " + mail + " | password: " + password + " | description: " + description;
    }

    public static Account fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        String mail = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        return new Account(null, mail, password, description);
    }
}
