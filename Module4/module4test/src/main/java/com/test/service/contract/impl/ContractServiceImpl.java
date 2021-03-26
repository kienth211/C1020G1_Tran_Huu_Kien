package com.test.service.contract.impl;

import com.test.model.contract.Contract;
import com.test.repository.ContractRepository;
import com.test.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllInput(Pageable pageable, Optional<String> text) {
        return contractRepository.findAllInput(pageable, text);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
