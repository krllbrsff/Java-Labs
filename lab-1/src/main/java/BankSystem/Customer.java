package BankSystem;

import lombok.Builder;
import lombok.Data;

/**
 * класс клиента банка
 */
@Data
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String address;

    public boolean verified() {
        return address == null && passportNumber == null;
    }

    public void receiveMessage(String message, double newNumber) {
        System.out.println(message + " " + newNumber);
    }
}