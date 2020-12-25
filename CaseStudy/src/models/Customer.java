package models;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private int idNum;
    private int mobileNum;
    private String email;
    private String customerType;
    private String address;
    private Services services;

    public Customer() {
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, String birthday, String gender,
                    int idNum, int mobileNum, String email, String customerType, String address, Services services) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNum = idNum;
        this.mobileNum = mobileNum;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.services = services;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idNum=" + idNum +
                ", mobileNum=" + mobileNum +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }
}
