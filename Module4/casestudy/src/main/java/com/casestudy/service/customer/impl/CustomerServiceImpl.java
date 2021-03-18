package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.customer.CustomerRepository;
import com.casestudy.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllInput(Pageable pageable, Optional<String> text) {
        return customerRepository.findAllInput(pageable, text);
    }

//    @Override
//    public Page<Customer> findAllBetween(Pageable pageable) {
//        return customerRepository.findCustomersByContractsIsBetween(pageable);
//    }
}
