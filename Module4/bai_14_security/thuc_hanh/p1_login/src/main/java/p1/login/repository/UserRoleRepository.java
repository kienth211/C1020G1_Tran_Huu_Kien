package p1.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p1.login.model.AppUser;
import p1.login.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}