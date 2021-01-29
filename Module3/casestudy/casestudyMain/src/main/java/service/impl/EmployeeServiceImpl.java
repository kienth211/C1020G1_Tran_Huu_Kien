package service.impl;

import bean.Employee;
import bean.User;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
//    @Override
//    public void save(Employee employee) {
//        employeeRepository.save(employee);
//    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

//    @Override
//    public User findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public User findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//
//    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return null;
//    }
}
