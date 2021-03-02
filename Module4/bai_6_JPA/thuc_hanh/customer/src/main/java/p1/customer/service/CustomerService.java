package p1.customer.service;

import p1.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void delete(Integer id);
}
