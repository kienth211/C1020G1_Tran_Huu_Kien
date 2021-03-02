package p1.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p1.customer.model.Customer;
import p1.customer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

//    @Override
//    public Customer findByName(String name) {
//        return customerRepository.findByName(name);
//    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
