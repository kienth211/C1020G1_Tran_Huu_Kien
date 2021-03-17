package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService extends Service<Contract> {
    Page<Contract> findContractsByCurrentDate(Pageable pageable);
}
