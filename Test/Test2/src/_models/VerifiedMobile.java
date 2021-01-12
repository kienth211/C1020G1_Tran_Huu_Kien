package _models;

public class VerifiedMobile extends Mobile {
    private int date;
    private String area;

    public VerifiedMobile(int idMobile, String nameMobile, double priceMobile,
                          int quantityMobile, String producerMobile, int date, String area) {
        super(idMobile, nameMobile, priceMobile, quantityMobile, producerMobile);
        this.date = date;
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() +
                        "," + date +
                        "," + area;
    }
}

