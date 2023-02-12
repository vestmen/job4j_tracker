package ru.job4j.bank;

import java.util.*;

/**
 * Данный класс - модель для банковской системы
 * @author Alexey Nemtsev
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему
     * @param user пользователь системы
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает пасспорт пользователя и позволяет удалить его из системы
     * @param passport пасспорт пользователя
     * @return возвращает true если удаление прошло успешно
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод ищет пользователя по паспорту,
     * проверяет, что этого банковского счета у пользователя еще нету
     * и в таком случае добавляет его к пользователю
     * @param passport пасспорт пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user.getPassport() != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает пользователя с указанным паспортом
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (Objects.equals(passport, user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return возвращает банковский счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport паспорт пользователя, который переводит деньги
     * @param srcRequisite реквизиты счета пользователя, с которого переводят деньги
     * @param destPassport паспорт пользователя, которому переводят деньги
     * @param destRequisite реквизиты счета пользователя, которому переводят деньги
     * @param amount сумма перевода
     * @return возвращает true если перевод выполнен успешно,
     * если счёт не найден или не хватает денег на счёте, с которого переводят, то метод вернет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

    /**
     * Метод принимает пользоателя и позволяет получить все его счета
     * @param user пользователь системы
     * @return все возвращает банковские счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
