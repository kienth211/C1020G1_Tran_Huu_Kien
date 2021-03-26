package com.test.model.contract;

import com.test.model.customer.Customer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_code",nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "((MGD-)([0-9]{4}))", message = "Wrong format")
    private String contractCode;

    @Column(name = "contract_type",nullable = false)
    @NotBlank(message = "Need value")
    private String contractType;

    @Column(name = "contract_date",nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|" +
            "1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$",
            message = "format DD/MM/YYYY")
    private String contractDate;

    @Column(name = "contract_cost",nullable = false)
    @NotBlank(message = "Need value")
    @Min(value = 500000, message = "value must > 500,000")
    private String contractCost;

    @Column(name = "contract_area",nullable = false)
    @NotBlank(message = "Need value")
    @Min(value = 20, message = "value must > 20")
    private String contractArea;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractCost() {
        return contractCost;
    }

    public void setContractCost(String contractCost) {
        this.contractCost = contractCost;
    }

    public String getContractArea() {
        return contractArea;
    }

    public void setContractArea(String contractArea) {
        this.contractArea = contractArea;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
