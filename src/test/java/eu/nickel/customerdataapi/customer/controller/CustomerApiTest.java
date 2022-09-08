package eu.nickel.customerdataapi.customer.controller;

import eu.nickel.customerdataapi.customer.CustomerDto;
import eu.nickel.customerdataapi.customer.CustomerMapper;
import eu.nickel.customerdataapi.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerApiTest {

    @InjectMocks private CustomerApi customerApi;
    @Mock private CustomerService customerService;
    @Mock private CustomerMapper customerMapper;


    @Test
    public void whenGetCustomerDtoList_thenReturnAllCustomerDto (){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customerDtoList.add(
            CustomerDto.builder()
                .refCustomer(1)
                .BirthPlace(null)
                .BirthDate(null)
                .PhoneNumber("+33 06 25 78 96 15")
                .email("Jean_pierre@gmail.com")
                .BankAccountNumber(null)
                .LastName("Pierre")
                .FirstName("Jean")
                .build());

        given(customerMapper.mapToDtoList(customerService.findCustomers())).willReturn(customerDtoList);

        List<CustomerDto> result = customerApi.getCustomerDtoList();

        assertThat(result).isEqualTo(customerDtoList);
    }

    @Test
    public void whenGetCustomerById_thenReturnCustomerDtoById(){

        CustomerDto customerDto =
        CustomerDto.builder()
                .refCustomer(1)
                .FirstName("Jean")
                .LastName("Michel")
                .email("Jean_michel@gmail.com")
                .BankAccountNumber("15685463212")
                .PhoneNumber("+33 55 44 55 54 ")
                .BirthPlace("Paris")
                .BirthDate(null)
                .build();

        given(customerMapper.mapToDtoEntity(customerService.findCustomerId(customerDto.getRefCustomer()))).willReturn(customerDto);

        CustomerDto result = customerApi.getCustomerById(customerDto.getRefCustomer());

        assertThat(result).isEqualTo(customerDto);
    }
}
