package com.casestudy.model.employee;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

//    @Size(min = 5, max = 45, message = "value must > 5 and < 45")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
