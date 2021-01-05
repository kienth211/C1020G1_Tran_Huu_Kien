package models.services;

public abstract class Services {
    private String id;
    private String name;
    private double area;
    private double price;
    private int maxPeople;
    private String rentType;

    public Services() {
    }

    public Services(String id, String name, double area, double price, int maxPeople, String rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String showInfo(){
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPeople=" + maxPeople +
                ", date='" + rentType + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return id + "," +
                name + "," +
                area + "," +
                price + "," +
                maxPeople + "," +
                rentType;
    }
}
