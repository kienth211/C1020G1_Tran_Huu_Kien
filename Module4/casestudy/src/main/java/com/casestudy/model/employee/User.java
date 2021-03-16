package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;

    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
