package eu.nickel.customerdataapi.customer;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class CustomerMapper {
    public List<CustomerDto> mapToDtoList(List<Customer> customer){

        return customer.stream().map(mapToDto).collect(Collectors.toUnmodifiableList());
    }
    public CustomerDto mapToDtoEntity(Customer customer){
        return Optional.ofNullable(customer).map(mapToDto).orElse(null);
    }
    public Function<Customer, CustomerDto> mapToDto = (final Customer customer) ->

                    CustomerDto.builder()
                        .refCustomer(customer.getRefCustomer())
                        .FirstName(customer.getFirstName())
                        .LastName(customer.getLastName())
                        .BankAccountNumber(customer.getBankAccountNumber())
                        .PhoneNumber(customer.getPhoneNumber())
                        .email(customer.getEmail())
                        .BirthDate(customer.getBirthDate())
                        .BirthPlace(customer.getBirthPlace())
                        .build();
}
