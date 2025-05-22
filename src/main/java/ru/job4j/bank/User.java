package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных для конкретного пользователя.
 * @author OSIPOV VLADIMIR
 * @version 1.0
 */
public class User {
    /**
     * Паспортные данные пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор для создания объекта счета.
     * @param passport Паспортные данные пользователя., которого мы хотим создать.
     * @param username  Имя пользователя, которого мы хотим создать.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для паспортных данных пользователя.
     * @return Паспортные данные пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для номера паспорта.
     * @param passport Номер паспорта.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для имени пользователя.
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для имени.
     * @param username Имя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Методы equals и hashCode переопределены.
     * Равенство проверяется по значению поля passport.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}