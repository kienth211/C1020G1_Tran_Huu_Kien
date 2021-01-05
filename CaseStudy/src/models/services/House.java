package models.services;

public class House extends Services {
    private String roomStandard;
    private String roomFurniture;
    private int floors;

    public House() {
    }

    public House(String id, String name, double area, double price, int maxPeople, String rentType, String roomStandard, String roomFurniture, int floors) {
        super(id, name, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return super.showInfo() +
                "House{" +
                "roomStandard=" + roomStandard +
                ", roomFurniture='" + roomFurniture + '\'' +
                ", floors=" + floors +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                roomStandard + "," +
                roomFurniture + "," +
                floors;
    }
}
