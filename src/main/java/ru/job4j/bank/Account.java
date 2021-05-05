package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает порядок создания счета Account и получения информации о счете
 * @author OLEG PANYUKOV
 * @version 1.0
 */

public class Account {
    /**
     * Счет содержит следующую информацию:
     * requisite - реквизиты счета
     * balance - количество денег на счете
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор счета.
     * Счет содержит следующую информацию:
     * @param requisite - реквизиты счета
     * @param balance   - количество денег на счете
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для получения реквизитов
     * @return - возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для записи реквизитов
     * @param requisite - реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для получения баланса
     * @return - возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     *Сеттер для записи баланса
     * @param balance - величина баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

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
