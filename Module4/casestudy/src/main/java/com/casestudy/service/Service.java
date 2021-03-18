package com.casestudy.service;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    Page<T> findAllInput(Pageable pageable, Optional<String> text);
    T findById(String id);
    void delete(T t);
    void save(T t);
}
