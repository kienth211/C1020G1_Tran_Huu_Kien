package com.test.model.customer;

import com.test.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_code",nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "((KH-)([0-9]{4}))", message = "Wrong format")
    private String customerCode;

    @Column(name = "customer_name",nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$",
            message = "Wrong format")
    private String customerName;

    @Column(name = "customer_phone",nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$", message = "Wrong format")
    private String customerPhone;

    @Column(name = "customer_email",nullable = false)
    @NotBlank(message = "Need value")
    @Email(message = "Wrong format")
    private String customerEmail;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
