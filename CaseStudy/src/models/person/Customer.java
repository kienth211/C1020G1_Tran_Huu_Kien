package models.person;

import models.services.Services;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String idNum;
    private String mobileNum;
    private String email;
    private String customerType;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idNum, String mobileNum, String email, String customerType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNum = idNum;
        this.mobileNum = mobileNum;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String showInfo() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idNum='" + idNum + '\'' +
                ", mobileNum=" + mobileNum +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String toString() {
        return name + "," +
                birthday + "," +
                gender + "," +
                idNum + "," +
                mobileNum + "," +
                email + "," +
                customerType + "," +
                address;
    }
}
