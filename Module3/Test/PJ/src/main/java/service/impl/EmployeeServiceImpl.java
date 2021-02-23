package service.impl;

import bean.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.function.Input;
import service.function.Regex;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private Regex regex = new Regex();
    private Input input = new Input();
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public String save(Employee employee) {
        if (!input.inputString(employee.getProduct_name())) {
            return "Name must have value";
        }


        if (!regex.regexPrice(employee.getProduct_price())) {
            if (!input.inputDouble(employee.getProduct_price())) {
                if (!input.inputString(employee.getProduct_price())) {
                    return "Price must have value";
                }
                return "Price must have all numbers";
            }
            return "Price must > 100";
        }

        if (!regex.regexDiscount(employee.getProduct_discount())) {
            if (!input.inputInt(employee.getProduct_discount())) {
                if (!input.inputString(employee.getProduct_discount())) {
                    return "Discount must have value";
                }
                return "Discount must have all numbers";
            }
            return "Discount must be 5, 10, 15, 20";
        }

        if (!regex.regexStock(employee.getProduct_not_sold())) {
            if (!input.inputInt(employee.getProduct_not_sold())) {
                if (!input.inputString(employee.getProduct_not_sold())) {
                    return "Stock must have value";
                }
                return "Stock must have all numbers";
            }
            return "Stock must > 10";
        }

        employeeRepository.save(employee);
        return "OK";
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return null;
//    }
}
