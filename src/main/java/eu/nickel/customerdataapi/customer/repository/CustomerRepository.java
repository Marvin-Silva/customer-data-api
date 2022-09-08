package eu.nickel.customerdataapi.customer.repository;

import eu.nickel.customerdataapi.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
