import BankSystem.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void depositAndTransactionTest() {
        CentralBank centralBank = new CentralBank();
        Bank bank1 = new Bank();
        Customer customer = Customer.builder()
                .firstName("A")
                .lastName("B")
                .build();
        Account account1 = bank1.NewDebetAccount(customer);
        Account account2 = bank1.NewDebetAccount(customer);
        account1.deposit(100);
        centralBank.handleTransaction(bank1, bank1, account1, account2, 100.0);

        assertEquals(100.0, account2.getBalance());
    }

    @Test
    public void withdrawTest() {
        Bank bank1 = new Bank();
        Customer customer = Customer.builder()
                .firstName("A")
                .lastName("B")
                .build();
        Account account1 = bank1.NewDebetAccount(customer);
        account1.deposit(100);

        assertEquals(Result.Succes, account1.withdraw(100));
    }
}
