package repository.impl;

import bean.Employee;
import repository.EmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private final String SQL_FIND_ALL = "select * " +
            "from product";

    private final String SQL_FIND_BY_ID = "select * " +
            "from product " +
            "where product_id = ?";

    private final String SQL_FIND_BY_NAME = "select * " +
            "from product " +
            "where product_name like concat('%',?,'%')";

    private final String SQL_UPDATE = "update product " +
            "set product_name = ?, product_price = ?, " +
            "product_discount = ?, product_not_sold = ? " +
            "where product_id = ?";

    private final String SQL_CREATE = "insert into product(product_name, product_price, product_discount," +
            " product_not_sold) values " +
            "(?, ?, ?, ?)";

    private final String SQL_DELETE = "delete from product " +
            "where product_id = ?";

    @Override
    public void save(Employee employee) {
        if (employee.getProduct_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_CREATE);
                preparedStatement.setString(1, employee.getProduct_name());
                preparedStatement.setString(2, employee.getProduct_price());
                preparedStatement.setString(3, employee.getProduct_discount());
                preparedStatement.setString(4, employee.getProduct_not_sold());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1, employee.getProduct_name());
                preparedStatement.setString(2, employee.getProduct_price());
                preparedStatement.setString(3, employee.getProduct_discount());
                preparedStatement.setString(4, employee.getProduct_not_sold());
                preparedStatement.setString(5, employee.getProduct_id());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setProduct_id(resultSet.getString("product_id"));
                employee.setProduct_name(resultSet.getString("product_name"));
                employee.setProduct_price(resultSet.getString("product_price"));
                employee.setProduct_discount(resultSet.getString("product_discount"));
                employee.setProduct_not_sold(resultSet.getString("product_not_sold"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = new Employee();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            employee.setProduct_id(resultSet.getString("product_id"));
            employee.setProduct_name(resultSet.getString("product_name"));
            employee.setProduct_price(resultSet.getString("product_price"));
            employee.setProduct_discount(resultSet.getString("product_discount"));
            employee.setProduct_not_sold(resultSet.getString("product_not_sold"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setProduct_id(resultSet.getString("product_id"));
                employee.setProduct_name(resultSet.getString("product_name"));
                employee.setProduct_price(resultSet.getString("product_price"));
                employee.setProduct_discount(resultSet.getString("product_discount"));
                employee.setProduct_not_sold(resultSet.getString("product_not_sold"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    @Override
//    public User getUserById(Integer id) {
//        User user = null;
//        String query = "{CALL get_user_by_id(?)}";
//        try {CallableStatement callableStatement =
//                     this.baseRepository.getConnection().prepareCall(query);
//             callableStatement.setString(1, String.valueOf(id));
//            ResultSet rs = callableStatement.executeQuery();
////            while (rs.next()) {
//            rs.next();
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
////            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
}
