package BankSystem;

public class DepositAccount extends Account {
    public int depositPeriod;

    public DepositAccount(Customer owner, int depositPeriod){
        super(owner);
        this.depositPeriod = depositPeriod;
    }
    @Override
    public Result withdraw(double amount) {
        if (depositPeriod <= 0) {
            if (balance - amount >= 0) {
                balance -= amount;
                return Result.Succes;
            } else return Result.NotEnoughMoney;
        } else return Result.DepositHasNotEnded;
    }
}