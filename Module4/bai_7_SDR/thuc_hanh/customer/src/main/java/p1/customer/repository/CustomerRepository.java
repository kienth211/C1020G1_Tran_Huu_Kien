package p1.customer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p1.customer.model.Customer;
import p1.customer.model.Province;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findByName(String name, Pageable pageable);
}
