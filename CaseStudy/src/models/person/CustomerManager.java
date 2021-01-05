package models.person;

import commons.exception.*;
import models.function.Input;
import models.function.Regex;

import java.io.*;
import java.util.*;

public class CustomerManager {
    private Regex regex = new Regex();
    private Input input = new Input();
    private boolean status;
    private List<Customer> list;

    public CustomerManager() {
        list = new ArrayList<>();
    }

    public void addNewCustomer() {
        System.out.println("Input Customer's name:");
        String name = null;
        do {
            try {
                name = regex.regexName();
                status = true;
            } catch (NameException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's birthday:");
        String birthday = null;
        do {
            try {
                birthday = regex.regexBirthday();
                status = true;
            } catch (BirthdayException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's gender:");
        String gender = null;
        do {
            try {
                gender = regex.regexGender();
                status = true;
            } catch (GenderException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's idNumber:");
        String idNumber = null;
        do {
            try {
                idNumber = regex.regexIdNumber();
                status = true;
            } catch (IdNumberException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's phoneNumber:");
        String phoneNumber = null;
        do {
            try {
                phoneNumber = regex.regexPhoneNumber();
                System.out.println(phoneNumber);
                status = true;
            } catch (PhoneNumberException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's email:");
        String email = null;
        do {
            try {
                email = regex.regexEmail();
                status = true;
            } catch (EmailException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's customerType:");
        String customerType = null;
        do {
            try {
                customerType = regex.regexCustomerType();
                status = true;
            } catch (CustomerTypeException e) {
                status = false;
                System.err.println(e.getMessage());
            }
        } while (!status);

        System.out.println("Input Customer's address:");
        String address = input.inputString();

        Customer customer = new Customer(name, birthday, gender, idNumber, phoneNumber, email, customerType, address);
        writeCustomer(customer);
        list.add(customer);
    }

    public void showInfoCustomer() {
        SortByName sortByName = new SortByName();
        Collections.sort(list, sortByName);
        for (Customer customer : list) {
            System.out.println(customer.showInfo());
        }
    }

    private void writeCustomer(Customer customer) {
        try {
            writeCustomerCheck(customer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCustomerCheck(Customer customer) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/Customer.csv", true));
        bufferedWriter.write(customer.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void readCustomer() {
        try {
            readCustomerCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCustomerCheck() throws IOException {
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(
                new FileReader("src/data/Customer.csv"));
        String line;
        String[] lineInfo;
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            list.add(new Customer(
                    lineInfo[0],
                    lineInfo[1],
                    lineInfo[2],
                    lineInfo[3],
                    lineInfo[4],
                    lineInfo[5],
                    lineInfo[6],
                    lineInfo[7]));
        }
    }

    public void showListInfoCustomer() {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(index + "." + list.get(index).showInfo());
        }
    }

    public Customer getCustomerByIndex() {
        Customer customer = null;

        do {
            try {
                status = true;
                int index = input.inputInt();
                customer = getCustomerByIndexCheck(index);
            } catch (NullPointerException e){
                status = false;
                System.err.println("Customer not exist, Input again:");
            }
        } while (!status);
        return customer;
    }

    private Customer getCustomerByIndexCheck(int index) {
        Customer customer = null;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                customer = list.get(i);
            }
        }
        if (customer == null){
            throw new NullPointerException();
        }
        return customer;
    }
}
