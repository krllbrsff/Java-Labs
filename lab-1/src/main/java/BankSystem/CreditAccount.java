package BankSystem;

import lombok.Getter;

@Getter
public class CreditAccount extends Account {
    private int limit;

    public CreditAccount(Customer owner, int limit) {
        super(owner);
        if (limit > 0)
            System.out.println("Wrong limit");
        else this.limit = limit;
    }

    @Override
    public Result withdraw(double amount) {
        if (balance - amount >= limit) {
            balance -= amount;
            return Result.Succes;
        } else return Result.NotEnoughMoney;
    }
}
