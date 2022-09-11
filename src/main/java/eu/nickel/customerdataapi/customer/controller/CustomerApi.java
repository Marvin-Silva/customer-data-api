package eu.nickel.customerdataapi.customer.controller;

import eu.nickel.customerdataapi.customer.CustomerDto;
import eu.nickel.customerdataapi.customer.CustomerMapper;
import eu.nickel.customerdataapi.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/customer-data-api")
@AllArgsConstructor
public class CustomerApi {
    private CustomerService customerService;
    private CustomerMapper customerMapper;
    @GetMapping(path = "/customers")
    @RolesAllowed({"MANAGER", "ANALYST", "CLIENT"})
    @CrossOrigin("*")
    public List<CustomerDto> getCustomerDtoList (){

        return customerMapper.mapToDtoList(customerService.findCustomers());
    }
    @GetMapping(path = "/customer/{id}")
//    @RolesAllowed({"MANAGER", "ANALYST", "CLIENT"})
    public CustomerDto getCustomerById(@PathVariable(value = "id") int refCustomer){
        return customerMapper.mapToDtoEntity(customerService.findCustomerId(refCustomer));
    }
}
