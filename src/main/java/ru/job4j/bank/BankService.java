package ru.job4j.bank;
import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void deleteUser(String passport) {
        User user = new User(passport, null);
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account output = null;
        if (user == null) {
            return output;
        }
        for (Account account : users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                output = account;
            }
        }
        return output;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount == null || destinationAccount == null) {
            return false;
        }
        double destinationBalance = destinationAccount.getBalance();
        double sourceBalance = sourceAccount.getBalance();
        if (sourceBalance >= amount) {
            sourceAccount.setBalance(sourceBalance - amount);
            destinationAccount.setBalance((destinationBalance + amount));
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}