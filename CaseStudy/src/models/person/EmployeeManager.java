package models.person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class EmployeeManager {
    private HashMap<String, Employee> map;
    private Stack<Employee> stack;

    public EmployeeManager() {
        map = new HashMap<>();
        stack = new Stack<>();
    }

    public void showInfoEmployee() {
        for (String key : map.keySet()) {
            System.out.println(map.get(key).toString());
        }
    }

    public void showStackListInfoEmployee() {
        for (Employee employee : stack) {
            System.out.println(employee.toString());
        }
    }

    public void showStackInfoEmployee(String id) {
        for (Employee employee : stack) {
            if (employee.getId().matches(id)) {
                System.out.println(employee.toString());
            }
        }
    }

    public void readEmployee() {
        try {
            readEmployeeCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readEmployeeCheck() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/data/Employee.csv"));
        String line;
        String[] lineInfo;
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            Employee employee = new Employee(
                    lineInfo[0],
                    lineInfo[1],
                    Integer.parseInt(lineInfo[2]),
                    lineInfo[3]);
            map.put(lineInfo[0], employee);
            stack.push(employee);
        }
    }
}
