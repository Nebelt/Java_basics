import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new Hashtable<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (fromAccountNum.compareTo(toAccountNum) > 0) {
            synchronized (fromAccountNum) {
                synchronized (toAccountNum) {
                    transferRun(fromAccountNum, toAccountNum, amount);
                }
            }
        } else {
            synchronized (toAccountNum) {
                synchronized (fromAccountNum) {
                    transferRun(fromAccountNum, toAccountNum, amount);
                }
            }
        }
    }

    public void transferRun(String fromAccountNum, String toAccountNum, long amount) {
        if (amount > 50000) checkAccounts(fromAccountNum, toAccountNum, amount);
        if (accounts.get(fromAccountNum).isLegal() && accounts.get(toAccountNum).isLegal()) {
            accounts.get(fromAccountNum).setMoney(getBalance(fromAccountNum) - amount);
            accounts.get(toAccountNum).setMoney(getBalance(toAccountNum) + amount);
        } else {
            System.out.println("Some account is banned =(");
        }
    }


    public void checkAccounts(String fromAccountNum, String toAccountNum, long amount) {
        try {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                accounts.get(fromAccountNum).setLegal(false);
                accounts.get(toAccountNum).setLegal(false);
                System.out.println("Accounts were baned: " + fromAccountNum + "," + toAccountNum);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long amount = 0;
        for (Account account : accounts.values()) {
            amount += account.getMoney();
        }
        return amount;

    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}