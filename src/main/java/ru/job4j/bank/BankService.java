package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банка с клиентом
 *
 * @author OLEG PANYUKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о клиенте в коллекции Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление клиента.
     * Проверяется наличие клиента в системе
     *
     * @param user - информация о клиенте
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление счета клиента.
     * Проверяется наличие такого счета
     *
     * @param passport - номер паспорта для поиска клиента
     * @param account  - информация о счете
     */
    public void addAccount(String passport, Account account) {
        List<Account> findAccount = users.get(findByPassport(passport).get());
        if (findAccount != null && !findAccount.contains(account)) {
            findAccount.add(account);
        }
    }

    /**
     * Поиск клиента по паспорту
     *
     * @param passport - номер паспорта для поиска клиента
     * @return - возвращает данные клиента, если клиент не найден возвращает null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(f -> f.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск счета клиента по реквизитам
     *
     * @param passport  - номер паспорта для поиска клиента
     * @param requisite - реквизиты счета
     * @return - возвращает счет клиента, если счет не найден возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        if (findByPassport(passport).isPresent()) {
            return users.get(findByPassport(passport).get())
                    .stream()
                    .filter(f -> f.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Переводит деньги с одного счета на другой
     * Если счёта не найдены или не хватает денег на счёте srcAccount возращает false
     *
     * @param srcPassport   - паспорт клиента с счета которого переводят деньги
     * @param srcRequisite  - реквизиты счета с которого переводят деньги
     * @param destPassport  - паспорт клиента на счет которого переводят деньги
     * @param destRequisite - реквизиты счета на который переводят деньги
     * @param amount        - размер перевода
     * @return - возвращает true Если перевод произведен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite).get();
        Account dstAccount = findByRequisite(destPassport, destRequisite).get();
        if (srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            dstAccount.setBalance(dstAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
