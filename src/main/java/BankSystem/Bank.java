package BankSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс банка.
 */
public class Bank {
    List<DebetAccount> debetAccounts = new ArrayList<>();
    List<CreditAccount> creditAccounts = new ArrayList<>();
    List<DepositAccount> depositAccounts = new ArrayList<>();
    private double percent;
    private double creditFee;

    /**
     * Создание дебетового счета
     *
     * @param customer владелец счета
     * @return созданный счет
     */
    public Account NewDebetAccount(Customer customer) {
        DebetAccount account = new DebetAccount(customer);
        debetAccounts.add(account);
        return account;
    }

    /**
     * Создание депозитного счета
     *
     * @param customer      владелец счета
     * @param depositPeriod Период депозита
     * @return созданный счет
     */
    public Account NewDepositAccount(Customer customer, int depositPeriod) {
        DepositAccount account = new DepositAccount(customer, depositPeriod);
        depositAccounts.add(account);
        return account;
    }

    /**
     * Создание депозитного счета
     *
     * @param customer владелец счета
     * @param limit    кредитный лимит
     * @return созданный счет
     */
    public Account NewCreditAccount(Customer customer, int limit) {
        CreditAccount account = new CreditAccount(customer, limit);
        creditAccounts.add(account);
        return account;
    }

    public void MonthlyPayment() {
        for (DebetAccount account : debetAccounts) {
            account.balance += account.balance * (percent / 12 / 100);
        }
        for (DepositAccount account : depositAccounts) {
            account.balance += account.balance * (percent / 12 / 100);
            if (account.depositPeriod > 0)
                account.depositPeriod--;
        }
        for (CreditAccount account : creditAccounts) {
            if (account.balance < 0)
                account.balance += account.balance * (creditFee / 12 / 100);
        }
    }

    public void updatePercent(double newPercent) {
        percent = newPercent;
        for (Account account : debetAccounts) {
            account.owner.receiveMessage("New percent is", newPercent);
        }
        for (Account account : depositAccounts) {
            account.owner.receiveMessage("New percent is", newPercent);
        }
    }

    public void updateFee(double newFee) {
        for (Account account : creditAccounts) {
            creditFee = newFee;
            account.owner.receiveMessage("New percent is", newFee);
        }
    }
}