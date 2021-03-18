package com.casestudy.model.service;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Service {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "((DV-)([0-9]{4}))", message = "Wrong format")
    private String serviceId;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String serviceName;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String serviceArea;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String serviceCost;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Must be positive Integer")
    private String serviceMaxPeople;

    @Column(nullable = false)
    private String standardRoom;

    @Column(nullable = false)
    private String descriptionOtherConvenience;

    @Column(nullable = false)
    @NotBlank(message = "Need value")
    private String poolArea;


    @Column(nullable = false)
    @NotBlank(message = "Need value")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Must be positive Integer")
    private String numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    List<Contract> contracts;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
