package com.casestudy.service.login;

import com.casestudy.model.employee.AppUser;

public interface UserService {
    void save(AppUser user);

    AppUser findByUsername(String username);

}
