package repository.impl;

import bean.Employee;
import bean.User;
import repository.EmployeeRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private final String SQL_FIND_ALL = "select employee_id, employee_name, position_id, education_degree_id, division_id " +
            "from employee";

//    private final String SQL_FIND_BY_ID = "select id, `name`, email, country " +
//            "from users " +
//            "where id = ";
//
//    private final String SQL_FIND_BY_NAME = "select * " +
//            "from users " +
//            "where name = ?";
//
//    private final String SQL_UPDATE = "update users " +
//            "set `name` = ?, email = ?, country = ? " +
//            "where id = ?";
//
//    private final String SQL_CREATE = "insert into users(`name`, email, country) values " +
//            "(?, ?, ?)";
//
//    private final String SQL_DELETE = "delete from users " +
//            "where id = ?";

//    @Override
//    public void save(User user) {
//        if (user.getId() == null) {
//            try {
//                PreparedStatement preparedStatement =
//                        this.baseRepository.getConnection().prepareStatement(SQL_CREATE);
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setString(2, user.getEmail());
//                preparedStatement.setString(3, user.getCountry());
//
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                PreparedStatement preparedStatement =
//                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setString(2, user.getEmail());
//                preparedStatement.setString(3, user.getCountry());
//                preparedStatement.setString(4, String.valueOf(user.getId()));
//
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

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
                employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setPosition_id(Integer.parseInt(resultSet.getString("position_id")));
                employee.setEducation_degree_id(Integer.parseInt(resultSet.getString("education_degree_id")));
                employee.setDivision_id(Integer.parseInt(resultSet.getString("division_id")));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

//    @Override
//    public User findById(Integer id) {
//        User user = new User();
//
//        try {
//            PreparedStatement preparedStatement =
//                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID + id);
////            preparedStatement.setString(1, String.valueOf(id));
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                user.setId(Integer.parseInt(resultSet.getString("id")));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setCountry(resultSet.getString("country"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    @Override
//    public User findByName(String name) {
//        User user = new User();
//
//        try {
//            PreparedStatement preparedStatement =
//                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_NAME);
//            preparedStatement.setString(1, name);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                user.setId(Integer.parseInt(resultSet.getString("id")));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setCountry(resultSet.getString("country"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        PreparedStatement preparedStatement =
//                null;
//        try {
//            preparedStatement = this.baseRepository.getConnection().prepareStatement(SQL_DELETE);
//            preparedStatement.setString(1, String.valueOf(id));
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
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
