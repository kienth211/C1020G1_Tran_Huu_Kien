package com.casestudy.repository.employee;

import com.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
