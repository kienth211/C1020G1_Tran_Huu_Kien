//package com.casestudy.service.contract.impl;
//
//import com.casestudy.model.contract.ContractDetail;
//import com.casestudy.repository.contract.ContractDetailRepository;
//import com.casestudy.service.contract.ContractDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ContractDetailServiceImpl implements ContractDetailService {
//    @Autowired
//    ContractDetailService contractDetailService;
//
//    @Override
//    public Page<ContractDetail> findAll(Pageable pageable) {
//        return contractDetailService.findAll(pageable);
//    }
//
//    @Override
//    public ContractDetail findById(Integer id) {
//        return contractDetailService.findById(id);
//    }
//
//    @Override
//    public void delete(ContractDetail contractDetail) {
//        contractDetailService.delete(contractDetail);
//    }
//
//    @Override
//    public void save(ContractDetail contractDetail) {
//        contractDetailService.save(contractDetail);
//    }
//}
