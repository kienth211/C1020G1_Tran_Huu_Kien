package models.services;

import java.util.Arrays;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String id, String name, double area, double price, int maxPeople, String rentType, String freeService) {
        super(id, name, area, price, maxPeople, rentType);
        this.freeService = freeService;
    }

    @Override
    public String showInfo() {
        return super.showInfo() +
                "Room{" +
                "freeService=" + freeService +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                freeService;
    }
}
