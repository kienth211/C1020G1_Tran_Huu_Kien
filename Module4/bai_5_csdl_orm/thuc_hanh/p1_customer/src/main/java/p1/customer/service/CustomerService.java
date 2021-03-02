package p1.customer.service;

import p1.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
List<Customer> findAll();
//Customer findByName(String name);
Customer findById(Integer id);
void delete(Customer customer);
}
