package eu.nickel.customerdataapi.customer.service;

import eu.nickel.customerdataapi.customer.Customer;
import eu.nickel.customerdataapi.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    // Filter id for searchBar in Front
    public List<Customer> findCustomers (){
        return customerRepository.findAll();
    }

//    public List<CustomerDto> findCustomerDto (){return customerRepository.findAll();}
    public Customer findCustomerId(int customerId){
        return customerRepository.findById(customerId).orElse(null);
    }
}
