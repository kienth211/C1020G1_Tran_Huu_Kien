package p1.repository;

import p1.model.Login;
import p1.model.User;

public interface UserRepo {
    User checkLogin(Login login);
}
