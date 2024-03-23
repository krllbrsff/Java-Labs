package BankSystem;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Абстрактный класс для всех счетов
 */
@Getter
@RequiredArgsConstructor
public abstract class Account {
    protected double balance = 0;
    protected @NonNull Customer owner;

    /**
     * пополнить баланс
     *
     * @param amount сумма пополнения
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * снять деньги
     *
     * @param amount сумма снятия
     * @return результат выполнения операции
     */
    public Result withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return Result.Succes;
        } else return Result.NotEnoughMoney;
    }
}