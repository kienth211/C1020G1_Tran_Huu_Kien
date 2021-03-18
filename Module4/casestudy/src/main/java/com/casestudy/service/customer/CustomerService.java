package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService extends Service<Customer> {
    Page<Customer> findAllInput(Pageable pageable, Optional<String> text);
//    Page<Customer> findAllBetween(Pageable pageable);
}
