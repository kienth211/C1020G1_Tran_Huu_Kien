package com.casestudy.repository.login;

import com.casestudy.model.employee.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findByName(String roleName);
}