package BankSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * класс транзакции
 */
@Getter
@AllArgsConstructor
public class Transaction {
    private final Bank sourceBank;
    private final Bank receiverBank;
    private final Account sourceAccount;
    private final Account receiverAccount;
    private final double sum;
}
