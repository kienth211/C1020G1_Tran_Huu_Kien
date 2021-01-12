package _models;

public abstract class Mobile {
    private int idMobile;
    private String nameMobile;
    private double priceMobile;
    private int quantityMobile;
    private String producerMobile;

    public Mobile() {
    }

    public Mobile(int idMobile, String nameMobile, double priceMobile, int quantityMobile, String producerMobile) {
        this.idMobile = idMobile;
        this.nameMobile = nameMobile;
        this.priceMobile = priceMobile;
        this.quantityMobile = quantityMobile;
        this.producerMobile = producerMobile;
    }

    public int getIdMobile() {
        return idMobile;
    }

    @Override
    public String toString() {
        return idMobile +
                "," + nameMobile +
                "," + priceMobile +
                "," + quantityMobile +
                "," + producerMobile;
    }
}
