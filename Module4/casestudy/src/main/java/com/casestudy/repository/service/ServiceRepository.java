package com.casestudy.repository.service;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {
    @Query("select s from Service s " +
            "where concat(s.serviceName,s.serviceType.serviceTypeName) like %?1%")
    Page<Service> findAllInput(Pageable pageable, Optional<String> text);
}
