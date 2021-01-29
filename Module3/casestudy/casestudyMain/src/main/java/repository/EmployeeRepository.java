package repository;

import bean.Employee;
import bean.User;

import java.util.List;

public interface EmployeeRepository {

//    void save(User user);
    List<Employee> findAll();
//    User findById(Integer id);
//    User findByName(String name);
//    void deleteById(Integer id);
//    User getUserById(Integer id);
}
