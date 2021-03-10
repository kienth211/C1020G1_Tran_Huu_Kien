package p1.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p1.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}