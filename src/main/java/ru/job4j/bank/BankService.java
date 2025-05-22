package ru.job4j.bank;
import java.util.*;

/**
 * Класс описывает работу системы банковских переводов.
 * @author OSIPOV VLADIMIR
 * @version 1.0
 */

public class BankService {

    /**
     * Коллекция включающая в себя пользователя и список всех его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в users.
     * @param user Пользователь, который добавляется в users.
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод удаляет пользователя из users по номеру паспорта.
     * @param passport Номер паспорта удаляемого пользователя.
     */
    public void deleteUser(String passport) {
        User user = new User(passport, null);
        users.remove(user);
    }

    /**
     * Метод позволяющий добавить счет определенному пользователю.
     * В случае отсутствия искомого пользователя в users, метод не сделает ничего.
     * В случае наличия принятого в метод счета у пользователя, дубликат не будет добавлен.
     * @param passport номер паспорта искомого пользователя
     * @param account счет, который добавляется пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает номер паспорта и возвращает пользователя.
     * В случае отсутствия пользователя с принятым номером паспорта, метод вернет null.
     * @param passport Номер паспорта искомого пользователя.
     * @return Возвращает пользователя при успешном поиске по номеру паспорта
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяющий получить счет определенного пользователя по реквизитам.
     * В случае отсутствия искомого пользователя или счета, метод вернет null.
     * @param passport Номер паспорта искомого пользователя.
     * @param requisite Реквизиты искомого счета.
     * @return Возвращает счет при успешном поиске по номеру паспорта и реквизитам.
     */
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

    /**
     * Метод позволяющий сделать перевод с одного счета на другой.
     * @param sourcePassport Номер паспорта пользователя отправителя.
     * @param sourceRequisite Номер счета с которого будет осуществлен перевод.
     * @param destinationPassport Номер паспорта пользователя получателя.
     * @param destinationRequisite Номер счета на который будет осуществлен перевод.
     * @param amount Сумма перевода.
     * @return Возвращает true в случае успешного перевода и false в случае неудачного.
     */
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

    /**\
     * Метод позволяет получить коллекцию счетов пользователя.
     * Используется преимущественно для тестов.
     * @param user Пользователь, счета которого мы хотим получить.
     * @return Коллекция из всех счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}