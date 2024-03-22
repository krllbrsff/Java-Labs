package BankSystem;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CentralBank {
    private final List<Transaction> transactions = new ArrayList<>();

    public void handleTransaction(Bank sourceBank, Bank receiverBank, Account sourceAccount, Account receiverAccount, Double sum) {
        Transaction transaction = new Transaction(sourceBank, receiverBank, sourceAccount, receiverAccount, sum);
        transactions.add(transaction);
        sourceAccount.withdraw(sum);
        receiverAccount.deposit(sum);
    }

    public void cancelTransaction(Transaction transaction) {
        if (transactions.contains(transaction)) {
            transaction.getSourceAccount().deposit(transaction.getSum());
            transaction.getReceiverAccount().withdraw(transaction.getSum());
            transactions.remove(transaction);
        }
    }
}
