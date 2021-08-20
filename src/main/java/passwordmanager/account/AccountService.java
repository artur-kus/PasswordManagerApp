package passwordmanager.account;

public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void addAccount() {
        Account account = Account.fromUserInput();
        accountDao.addAccount(account);
    }
}
