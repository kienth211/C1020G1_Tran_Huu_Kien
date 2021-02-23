package bean;

public class Employee {
    String product_id;
    String product_name;
    String product_price;
    String product_discount;
    String product_not_sold;

    public Employee() {
    }

    public Employee(String product_id, String product_name, String product_price, String product_discount, String product_not_sold) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
        this.product_not_sold = product_not_sold;
    }

    public Employee(String product_name, String product_price, String product_discount, String product_not_sold) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
        this.product_not_sold = product_not_sold;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_not_sold() {
        return product_not_sold;
    }

    public void setProduct_not_sold(String product_not_sold) {
        this.product_not_sold = product_not_sold;
    }
}

