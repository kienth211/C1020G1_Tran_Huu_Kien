package com.casestudy.model.employee;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Employee {

    @NotBlank(message = "Need value")
    @Pattern(regexp = "((NV-)([0-9]{4}))", message = "Wrong format")
    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$",
            message = "Wrong format")
    private String employeeName;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|" +
            "1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$",
            message = "format DD/MM/YYYY")
    private String employeeBirthday;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^([0-9]{9})$", message = "Wrong format")
    private String employeeIdCard;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String employeeSalary;

    @Column(nullable = false)
    @Pattern(regexp = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$", message = "Wrong format")
    private String employeePhone;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Email(message = "Wrong format")
    private String employeeEmail;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private AppUser appUser;

    @OneToMany(mappedBy = "employee")
    List<Contract> contracts;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
