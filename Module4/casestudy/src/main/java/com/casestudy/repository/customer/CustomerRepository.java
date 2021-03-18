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
public interface CustomerRepository extends JpaRepository<Customer, String> {
//    @Query("select cu from Customer cu " +
//            "left join Contract co on cu.customerId = co.customer.customerId " +
//            "where current_date between co.contractStartDate and co.contractEndDate")
//    Page<Customer> findCustomersByContractsIsBetween(Pageable pageable);


    @Query("select c from Customer c " +
            "where concat(c.customerName,c.customerEmail) like %?1%")
    Page<Customer> findAllInput(Pageable pageable, Optional<String> text);
}
