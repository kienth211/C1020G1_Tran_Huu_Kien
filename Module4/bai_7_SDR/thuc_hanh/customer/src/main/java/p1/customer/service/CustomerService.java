package p1.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import p1.customer.model.Customer;
import p1.customer.model.Province;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void save(Customer customer);
    void delete(Integer id);
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findByName(String name, Pageable pageable);
}
