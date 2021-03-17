package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query("select c from Customer c" +
//    "where ?1 between ")
//    Page<Customer> findCustomersByContractsIsBetween(Pageable pageable, Date date);


    @Query("select c from Customer c " +
            "where concat(c.customerName,c.customerEmail) like %?1%")
    Page<Customer> findAllInput(Pageable pageable, Optional<String> text);
}
