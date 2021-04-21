package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> findAccount = users.get(findByPassport(passport));
        if (findAccount != null && !findAccount.contains(account)) {
            findAccount.add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User find : users.keySet()) {
            if (find.getPassport().equals(passport)) {
                user = find;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        List<Account> findAccount = users.get(findByPassport(passport));
        if (findAccount != null) {
            for (Account findRequisite : findAccount) {
                if (findRequisite.getRequisite().equals(requisite)) {
                    account = findRequisite;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, destRequisite);
        if (dstAccount != null && srcAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            dstAccount.setBalance(dstAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
