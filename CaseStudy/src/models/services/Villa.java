package models.services;

public class Villa extends Services {
    private String roomStandard;
    private String roomFurniture;
    private double poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String id, String name, double area,
                 double price, int maxPeople, String rentType, String roomStandard, String roomFurniture, double poolArea, int floors) {
        super(id, name, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return super.showInfo() +
                "Villa{" +
                "roomStandard=" + roomStandard +
                ", roomFurniture='" + roomFurniture + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                roomStandard + "," +
                roomFurniture + "," +
                poolArea + "," +
                floors;
    }
}
