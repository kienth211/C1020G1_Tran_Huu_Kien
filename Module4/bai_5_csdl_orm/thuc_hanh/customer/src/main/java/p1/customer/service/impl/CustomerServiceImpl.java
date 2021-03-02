package p1.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p1.customer.model.Customer;
import p1.customer.repository.CustomerRepository;
import p1.customer.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
