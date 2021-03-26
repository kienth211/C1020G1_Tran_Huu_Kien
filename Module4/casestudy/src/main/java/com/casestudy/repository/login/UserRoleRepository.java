package com.casestudy.repository.login;

import com.casestudy.model.employee.AppUser;
import com.casestudy.model.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByAppUser(AppUser user);
}
