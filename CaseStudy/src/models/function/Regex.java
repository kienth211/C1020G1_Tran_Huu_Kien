package models.function;

import commons.exception.*;

import java.util.Date;
import java.util.Scanner;

public class Regex {
    private Input input = new Input();
    private boolean status;

    public String regexIdService() {
        String regex = "(SV)(VL|HO|RO)-[0-9]{4}";
        String idService;
        do {
            idService = input.inputString();
            status = idService.matches(regex);
            if (!status) {
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return idService;
    }

    public String regexServiceName() {
        String regex = "[A-Z][a-z_0-9]+";
        String serviceName;
        do {
            serviceName = input.inputString();
            status = serviceName.matches(regex);
            if (!status) {
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return serviceName;
    }

    public double regexAreaAndPoolArea() {
        double area;
        do {
            if (!status) {
                System.err.println("Value must > 30, Input again:");
            }
            area = input.inputDouble();
            status = area > 30;
        } while (!status);
        return area;
    }

    public double regexPrice() {
        double price;
        do {
            if (!status) {
                System.err.println("Value must > 0, Input again:");
            }
            price = input.inputDouble();
            status = price > 0;
        } while (!status);
        return price;
    }

    public int regexMaxPeople() {
        int maxPeople;
        do {
            if (!status) {
                System.err.println("Value must > 0 and < 20, Input again:");
            }
            maxPeople = input.inputInt();
            status = maxPeople > 0 && maxPeople < 20;
        } while (!status);
        return maxPeople;
    }

    public String regexRentType() {
        String regex = "(Year|Month|Day|Hour)";
        String rentType;
        do {
            rentType = input.inputString();
            status = rentType.matches(regex);
            if (!status) {
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return rentType;
    }

    public String regexRoomStandard() {
        String regex = "(Vip|Business|Normal)";
        String roomStandard;
        do {
            roomStandard = input.inputString();
            status = roomStandard.matches(regex);
            if (!status) {
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return roomStandard;
    }

    public String regexRoomFurniture() {
        String regex = "(Classic|Modern|Normal)";
        String roomFurniture;
        do {
            roomFurniture = input.inputString();
            status = roomFurniture.matches(regex);
            if (!status) {
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return roomFurniture;
    }

    public int regexFloors() {
        int floors;
        do {
            if (!status) {
                System.err.println("Value must > 0, Input again:");
            }
            floors = input.inputInt();
            status = floors > 0;
        } while (!status);
        return floors;
    }

    public String regexFreeService() {
        String regex = "(Massage|Karaoke|Food|Drink|Car)";
        System.out.println("Free Service:");
        String freeService;
        do {
            freeService = input.inputString();
            if (!freeService.matches(regex)) {
                status = false;
                System.err.println("Wrong format, Input again:");
            }
        } while (!status);
        return freeService;
    }

    public String regexName() throws NameException {
        String regex = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$";
        String name = input.inputString();
        if (!name.matches(regex)) {
            throw new NameException("Wrong format input, Input again:");
        }
        return name;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public String regexBirthday() throws BirthdayException {
        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        int monthNow = now.getMonth() + 1;
        int dayNow = now.getDate();
        String date = input.inputString();
        StringBuilder stringBuilder = new StringBuilder(date);
        int yearCustomer;
        int dayCustomer;
        int monthCustomer;
        if (date.matches(regex)) {
            yearCustomer = Integer.parseInt(stringBuilder.substring(6));
            dayCustomer = Integer.parseInt(stringBuilder.substring(0, 2));
            monthCustomer = Integer.parseInt(stringBuilder.substring(3, 5));
            if ((yearNow - yearCustomer) < 18) {
                throw new BirthdayException("Customer > 18 year old");
            }
            if (yearNow - yearCustomer == 18) {
                if (monthNow < monthCustomer) {
                    throw new BirthdayException("Customer > 18 year old");
                } else if (monthCustomer == monthNow) {
                    if (dayNow < dayCustomer) {
                        throw new BirthdayException("Customer > 18 year old");
                    }
                }
            }
            if (yearCustomer < 1901) {
                throw new BirthdayException("Year > 1900");
            }
            if (monthCustomer > 12) {
                throw new BirthdayException("Max month is 12");
            }
            switch (monthCustomer) {
                case 2:
                    if (checkLeapYear(yearCustomer)) {
                        if (dayCustomer > 29) {
                            throw new BirthdayException("Max days is 29");
                        }
                    } else {
                        if (dayCustomer > 28) {
                            throw new BirthdayException("Max days is 28!!");
                        }
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dayCustomer > 31) {
                        throw new BirthdayException("Max days is 31!!");
                    }
                    break;
                default:
                    if (dayCustomer > 30) {
                        throw new BirthdayException("Max days is 30!!");
                    }
            }
        } else {
            throw new BirthdayException("Wrong input format");
        }
        return date;
    }

    public String regexGender() throws GenderException {
        String regex = "(?i)(male|female|unknown)";
        String string = input.inputString();
        if (string.matches(regex)) {
            string = string.toLowerCase();
            string = string.substring(0, 1).toUpperCase() + string.substring(1);
        } else {
            throw new GenderException("Wrong format input, Input again:");
        }
        return string;
    }

    public String regexIdNumber() throws IdNumberException {
        String regex = "[0-9]{3}\\s[0-9]{3}\\s[0-9]{3}";
        String idNumber = input.inputString();
        if (!idNumber.matches(regex)) {
            throw new IdNumberException("Wrong format input, Input again:");
        }
        return idNumber;
    }

    public String regexPhoneNumber() throws PhoneNumberException {
        String regex = "(0|84)[0-9]{9}";
        String phoneNumber = input.inputString();
        if (!phoneNumber.matches(regex)) {
            throw new PhoneNumberException("Wrong format input, Input again:");
        }
        return phoneNumber;
    }

    public String regexEmail() throws EmailException {
        String regex = "\\w+@\\w+(\\.\\w+){1,5}";
        String email = input.inputString();
        if (!email.matches(regex)) {
            throw new EmailException("Wrong format input, Input again:");
        }
        return email;
    }

    public String regexCustomerType() throws CustomerTypeException {
        String regex = "(Diamond|Platinium|Gold|Silver|Member)";
        String customerType = input.inputString();
        if (!customerType.matches(regex)) {
            throw new CustomerTypeException("Wrong format input, Input again:");
        }
        return customerType;
    }
}
