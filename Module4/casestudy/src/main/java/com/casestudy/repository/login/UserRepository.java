package com.casestudy.repository.login;

import com.casestudy.model.employee.AppUser;
import com.casestudy.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);

    AppUser findByEmployee(Employee employee);

    AppUser findByEmployee_EmployeeId (String id);


}
