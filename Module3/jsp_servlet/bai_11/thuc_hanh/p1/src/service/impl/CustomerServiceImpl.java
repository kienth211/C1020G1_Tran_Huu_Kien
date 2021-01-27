package service.impl;

import bean.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
