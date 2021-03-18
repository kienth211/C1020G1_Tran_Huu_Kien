package com.casestudy.model.customer;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "((KH-)([0-9]{4}))", message = "Wrong format")
    private String customerId;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$",
    message = "Wrong format")
    private String customerName;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|" +
            "1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$",
            message = "format DD/MM/YYYY")
    private String customerBirthday;

    @Column(nullable = false)
    private String customerGender;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^([0-9]{9})$", message = "Wrong format")
    private String customerIdCard;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$", message = "Wrong format")
    private String customerPhone;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Email(message = "Wrong format")
    private String customerEmail;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String customerAddress;

    @ManyToOne()
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    List<Contract> contracts;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
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

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
