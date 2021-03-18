package com.casestudy.repository.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

    @Query("select c from Contract c " +
    "where CURRENT_DATE between c.contractStartDate and c.contractEndDate")
    Page<Contract> findContractsByCurrentDate(Pageable pageable);

//    @Query("select c from Contract c " +
//            "where concat(c.c,c.customerEmail) like %?1%")
//    Page<Customer> findAllInput(Pageable pageable, Optional<String> text);
}
