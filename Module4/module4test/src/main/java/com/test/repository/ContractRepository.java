package com.test.repository;

import com.test.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query("select c from Contract c " +
            "where concat(c.customer.customerName,c.contractType) like %?1%")
    Page<Contract> findAllInput(Pageable pageable, Optional<String> text);
}
