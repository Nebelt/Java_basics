import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static Bank BANK = new Bank();

    public static void main(String[] args) {

        Account Vaska = new Account(100500000, "100101");
        Account Boris = new Account(0, "7");
        Account NoFriendsMan = new Account(0, "0");

        HashMap<String,Account> accounts = new HashMap<>();
        accounts.put("100101", Vaska);
        accounts.put("7", Boris);
        accounts.put("0", NoFriendsMan);
        BANK.setAccounts(accounts);

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(Main::bigTransfer));
        }
        threads.forEach(Thread::run);
        BANK = new Bank();
    }

    public static void bigTransfer() {
        long allMoneyAtStart = BANK.getSumAllAccounts();
        for (int i = 0; i < 1000; i++) {
            if (Math.random() * 100 < 5) {
                BANK.transfer("100101", "7", 50001);
            } else {
                BANK.transfer("100101", "7", 1);
            }


            System.out.println(BANK.getBalance("100101"));
            System.out.println(BANK.getBalance("7"));
        }

        BANK.transfer("100101", "0", 1);
        BANK.transfer("7", "0", 1);
        BANK.transfer("0", "7", 1);
        System.out.println("---------------------------");
        System.out.println((allMoneyAtStart == BANK.getSumAllAccounts()) ? "All amounts are ok" : "Something WRONG!!!");
    }


}


