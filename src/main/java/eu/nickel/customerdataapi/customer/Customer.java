package eu.nickel.customerdataapi.customer;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "Customer", schema = "BankSI" )
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int refCustomer; private String FirstName; private String LastName;
    private Integer RefPoliteness;
    private String Sex;
    private String email;
    private String PhoneNumber;
    private Integer RefSubscriptionABM;
    private String RegistrationCode;
    private String BankReference;
    private String BankWebIdentifier;
    private String BankAccountNumber;
    private String BankRefSubscription;
    private BigDecimal FirstDeposit;
    private String BarCode;
    private Timestamp BirthDate;
    private String BirthCountryISO2;
    private String BirthPlace;
    private Timestamp CreationDate;
    private Boolean isPro;
    private Boolean isDeleted;
    private Boolean isLocked;
    private String IBAN;
    private Boolean FirstAddressChecked;
    private String TokenRegistrationCode;
    private Short BankStatus;
    private Boolean isSubscriptionFree;
    private Short RefAccountKind;
    private Integer RefCustomerParent;
    private Timestamp ReOpenDate;
    private char RegistrationCountry;
    private String Culture;
    private String LastNames;

}
