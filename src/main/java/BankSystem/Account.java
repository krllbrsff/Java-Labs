package BankSystem;

import lombok.*;

@Getter
@RequiredArgsConstructor
public abstract class Account {
    protected double balance = 0;
    protected @NonNull Customer owner;

    public void deposit(double amount) {
        balance += amount;
    }

    public Result withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return Result.Succes;
        } else return Result.NotEnoughMoney;
    }
}