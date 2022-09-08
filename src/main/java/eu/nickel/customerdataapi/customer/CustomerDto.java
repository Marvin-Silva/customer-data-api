package eu.nickel.customerdataapi.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class CustomerDto{

    private int refCustomer;
    private String FirstName;
    private String LastName;
    private String BankAccountNumber;
    private Timestamp BirthDate;
    private String BirthPlace;
    private String PhoneNumber;
    private String email;
}
