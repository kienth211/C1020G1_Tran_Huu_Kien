package com.casestudy.service.service.impl;

import com.casestudy.model.service.Service;
import com.casestudy.repository.service.ServiceRepository;
import com.casestudy.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findAllInput(Pageable pageable, Optional<String> text) {
        return serviceRepository.findAllInput(pageable, text);
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }
}
