package ru.job4j.bank;


import java.util.*;

/**
 * Класс описывает упрощенную модель банковской системы
 *
 * @author VLAD RIDUN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользовательских данных и банковского аккаунта
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход объект типа User.
     * Если принимаемый пользователь не существует в коллекции,
     * происходит добавление в хранилище данного пользователя и
     * его нового пустого аккаунта.
     *
     * @param user пользователь, который добавляется в хранилище
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход 2 параметра:
     * passport - реквизиты паспорта
     * account - банковский счет
     * По параметру passport происходит поиск пользователя
     * Если пользователь существует -
     * метод получает список всех банковских счетов данного пользователя
     * Если в списке нет переданого в качестве параметра аккаунта банковского счета,
     * добавляет в список аккаунтов переданный банковский счет.
     *
     * @param passport паспортные данные пользователя
     * @param account  банковский счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход 2 параметра:
     * passport - реквизиты паспорта
     * По параметру passport происходит поиск пользователя.
     *
     * @return метод возвращает объект типа User или Null,
     * если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
          }

    /**
     * Метод принимает на вход 2 параметра:
     * passport - реквизиты паспорта
     * requisite - реквизиты банковского счета
     * По параметру passport происходит поиск пользователя
     * Если пользователь существует -
     * метод проходит по банковским аккаунтам данного пользователя,
     * если есть совпадение по реквизитам - возвращает аккаунт.
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     *
     * @return метод возвращает объект типа Account или Null,
     * если аккаунт не найден
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst();
        }
        return null;
    }

    /**
     * Метод по паспортным данным и реквизитам получает пользовательские аккаунты
     * При успешном выполнении условий-выполняет перечисление
     *
     * @param srcPassport   паспортные данные пользователя отправителя
     * @param srcRequisite  реквизиты банковского счета отправителя
     * @param destPassport  паспортные данные пользователя получателя
     * @param destRequisite реквизиты банковского счета получателя
     * @param amount        сумма перевода
     *
     * @return метод возвращает тип boolean:
     * true при успешном выполнении
     * false при невыполнении условий
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (accountDest != null && accountSrc != null && accountSrc.get().getBalance() >= amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}