package eu.nickel.customerdataapi.customer;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerMapperTest {

    @InjectMocks CustomerMapper customerMapper;

    @Test
    public void whenMapToDto_thenReturnMappedDtoList(){

        final List<Customer> customers = new ArrayList<>();

        Customer customer =
                Customer.builder()
                        .refCustomer(1)
                        .FirstName("Patrick")
                        .LastName("Baltasar")
                        .BankAccountNumber("123534135")
                        .PhoneNumber("+33 55 66 99 88")
                        .email("Patrick_baltasar@gmail.com")
                        .BirthDate(null)
                        .BirthPlace("Nice")
                        .build();
        customers.add(customer);

        final List<CustomerDto> result = customerMapper.mapToDtoList(customers);

        assertThat(result)
                .extracting(
                        CustomerDto::getRefCustomer,
                        CustomerDto::getFirstName,
                        CustomerDto::getLastName,
                        CustomerDto::getBankAccountNumber,
                        CustomerDto::getPhoneNumber,
                        CustomerDto::getEmail,
                        CustomerDto::getBirthDate,
                        CustomerDto::getBirthPlace)
                .containsExactly(
                        Tuple.tuple(
                        customer.getRefCustomer(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getBankAccountNumber(),
                        customer.getPhoneNumber(),
                        customer.getEmail(),
                        customer.getBirthDate(),
                        customer.getBirthPlace()));

    }
@Test
 public void whenMapToEntity_thenReturnMappedEntity(){

        Customer customer =
                Customer.builder()
                        .refCustomer(2)
                        .FirstName("Humbert")
                        .LastName("Souza")
                        .BankAccountNumber("1235654899")
                        .PhoneNumber("+33 06 25 48 78 99")
                        .email("Humbert_Souza@gmail.com")
                        .BirthDate(null)
                        .BirthPlace("Marseille")
                        .build();

        final CustomerDto result = customerMapper.mapToDtoEntity(customer);

        assertThat(result)
                .extracting(
                    CustomerDto::getRefCustomer,
                        CustomerDto::getFirstName,
                        CustomerDto::getLastName,
                        CustomerDto::getBankAccountNumber,
                        CustomerDto::getPhoneNumber,
                        CustomerDto::getEmail,
                        CustomerDto::getBirthDate,
                        CustomerDto::getBirthPlace
                ).containsExactly(
                        customer.getRefCustomer(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getBankAccountNumber(),
                        customer.getPhoneNumber(),
                        customer.getEmail(),
                        customer.getBirthDate(),
                        customer.getBirthPlace());
 }
}
