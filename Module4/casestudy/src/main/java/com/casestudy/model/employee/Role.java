package com.casestudy.model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Integer roleId;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
