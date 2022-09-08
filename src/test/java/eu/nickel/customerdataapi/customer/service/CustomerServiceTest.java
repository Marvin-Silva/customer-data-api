package eu.nickel.customerdataapi.customer.service;

import eu.nickel.customerdataapi.customer.Customer;
import eu.nickel.customerdataapi.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks CustomerService customerService;
    @Mock CustomerRepository customerRepository;

    @Test
    public void whenCustomersFound_thenReturnAllCustomers(){

        final List<Customer> result = customerService.findCustomers();

        assertThat(result).isEqualTo(customerRepository.findAll());
    }

    @Test
    public void whenCustomerIdFound_thenReturnCustomer(){
        Customer customer=
        Customer.builder()
                .refCustomer(1)
                .FirstName("Benoit")
                .LastName("LE BRETON")
                .RefPoliteness(null)
                .Sex("M")
                .email("benoit_lb@gmail.com")
                .PhoneNumber("+ 33 06 55 44 77")
                .RefSubscriptionABM(null)
                .RegistrationCode(null)
                .BankReference(null)
                .BankWebIdentifier(null)
                .BankAccountNumber("123545568")
                .BankRefSubscription("")
                .FirstDeposit(null)
                .BarCode(null)
                .BirthDate(null)
                .BirthCountryISO2(null)
                .BirthPlace("Bretagne")
                .CreationDate(null)
                .isPro(null)
                .isDeleted(null)
                .isLocked(null)
                .IBAN("FR3045658956523")
                .FirstAddressChecked(null)
                .TokenRegistrationCode(null)
                .BankStatus(null)
                .isSubscriptionFree(null)
                .RefAccountKind(null)
                .RefCustomerParent(null)
                .ReOpenDate(null)
                .RegistrationCountry('F')
                .Culture(null)
                .LastNames(null)
                .build();

        final Customer result = customerService.findCustomerId(customer.getRefCustomer());

        assertThat(result).isEqualTo(customerRepository.findById(customer.getRefCustomer()).orElse(null));
    }
}
