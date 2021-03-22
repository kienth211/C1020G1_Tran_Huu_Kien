package com.casestudy.service.login.impl;

import com.casestudy.model.employee.AppUser;
import com.casestudy.model.employee.UserRole;
import com.casestudy.repository.login.UserRepository;
import com.casestudy.repository.login.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.userRepository.findByUsername(username);

        if (appUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        UserRole userRole = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRole != null) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getAppRole().getName());
            grantList.add(grantedAuthority);
        }

        UserDetails userDetails = new User(appUser.getUsername(), appUser.getPassword(), grantList);

        System.out.println(userDetails.getAuthorities());

        return userDetails;
    }
}
