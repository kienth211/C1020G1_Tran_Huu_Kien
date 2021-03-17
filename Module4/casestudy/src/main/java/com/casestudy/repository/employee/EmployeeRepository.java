package com.casestudy.repository.employee;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e " +
            "where concat(e.employeeName,e.employeeEmail) like %?1%")
    Page<Employee> findAllInput(Pageable pageable, Optional<String> text);
}
