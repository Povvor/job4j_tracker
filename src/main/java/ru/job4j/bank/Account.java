package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных для конкретного банковского счета.
 * @author OSIPOV VLADIMIR
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета.
     */
    private String requisite;
    /**
     * Баланс счета
     */
    private double balance;

    /**
     * Конструктор для создания объекта счета.
     * @param requisite Реквизиты счета, который мы хотим создать.
     * @param balance  Баланс счета, который мы хотим создать.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для реквизитов счета.
     * @return Реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для реквизитов счета.
     * @param requisite Реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для баланса счета.
     * @return Баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер для баланса счета.
     * @param balance Баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Методы equals и hashCode переопределены.
     * Равенство проверяется по значению поля requisite.
     * @param o Объект с которым идет сравнение.
     * @return Результат сравнения.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}