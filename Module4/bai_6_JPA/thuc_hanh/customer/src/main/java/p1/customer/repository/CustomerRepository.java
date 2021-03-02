package p1.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p1.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
