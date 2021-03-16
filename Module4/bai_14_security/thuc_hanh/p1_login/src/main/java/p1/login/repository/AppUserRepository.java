package p1.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p1.login.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}