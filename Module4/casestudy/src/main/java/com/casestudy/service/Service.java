package com.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T findById(Integer id);
    void delete(T t);
    void save(T t);
}
