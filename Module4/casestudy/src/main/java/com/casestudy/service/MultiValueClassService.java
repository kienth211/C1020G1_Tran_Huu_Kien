package com.casestudy.service;

import com.casestudy.model.customer.CustomerType;

import java.util.List;

public interface MultiValueClassService<T> {
    List<T> findAll();
    T findById(Integer id);
}
