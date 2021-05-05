package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает создание клиента User и получение информации о нем
 * @author OLEG PANYUKOV
 * @version 1.0
 */
public class User {
    /**
     * Информация о клиенте
     * passport - номер паспорта
     * username - ФИО
     */
    private String passport;
    private String username;

    /**
     * Конструктор клиента
     * @param passport - номер паспорта
     * @param username - ФИО
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для получения номера паспорта
     * @return - номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для записи номера паспорта
     * @param passport - номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для получения ФИО
     * @return - ФИО
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для записи ФИО
     * @param username - ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

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
