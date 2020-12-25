package models;

import java.util.Date;

public class Villa extends Services {
    int roomStandard;
    String roomFurniture;
    int poolArea;
    int floors;

    public Villa() {
    }

    public Villa(String name) {
        super(name);
    }

    public Villa(int roomStandard) {
        this.roomStandard = roomStandard;
    }


    public Villa(int roomStandard, String roomFurniture, int poolArea, int floors) {
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(String name, int area, int price, int maxPeople, Date date, int roomStandard, String roomFurniture, int poolArea, int floors) {
        super(name, area, price, maxPeople, date);
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return "Villa{" +
                "roomStandard=" + roomStandard +
                ", roomFurniture='" + roomFurniture + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }
}
