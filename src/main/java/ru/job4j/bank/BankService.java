package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        } else {
            System.out.println("Данного пользователя не существует!");
        }

    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        } else {
            System.out.println("Данного пользователя не существует!");
        }
    }

    public User findByPassport(String passport) {
        User keyUser = new User(passport, null);
        User[] userList = users.keySet().toArray(new User[0]);
        for (User user : userList) {
            if (user.equals(keyUser)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            System.out.println("Данного пользователя не существует!");
            return null;
        }
        for (Account account : users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
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