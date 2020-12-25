package models;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> list;

    public CustomerManager(){
        list = new ArrayList<>();
    }

    public void addNewCustomer(Customer customer){
        list.add(customer);
    }

    public void showInfoCustomer(){
        for (Customer customer: list){
            System.out.println(customer.toString());
        }
    }

    private void regexName(){
        String regex = "[\\p{Lu}][\\p{Ll}]{0,8}";

    }
}
