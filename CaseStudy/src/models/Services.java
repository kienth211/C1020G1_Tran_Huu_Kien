package models;

import java.util.Date;

public abstract class Services {
    private String name;
    private int area;
    private int price;
    private int maxPeople;
    private Date date;

    public Services() {
    }

    public Services(String name) {
        this.name = name;
    }

    public Services(String name, int area, int price, int maxPeople, Date date) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public abstract String showInfo();
}
