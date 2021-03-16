package com.casestudy.model.employee;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;

//    @Size(min = 5, max = 45, message = "value must > 5 and < 45")
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private List<Employee> employees;

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
