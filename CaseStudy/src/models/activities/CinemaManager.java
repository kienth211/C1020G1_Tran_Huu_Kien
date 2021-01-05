package models.activities;

import models.person.Customer;

import java.util.ArrayDeque;
import java.util.Queue;

public class CinemaManager {
    Queue<Customer> queue;

    public CinemaManager(){
        queue = new ArrayDeque<>();
    }

    public void addCustomerQueueCinema(Customer customer){
        queue.add(customer);
    }

    public void showCustomerQueueCinema(){
        for (Customer customer: queue){
            System.out.println(customer.showInfo());
        }
    }
}
