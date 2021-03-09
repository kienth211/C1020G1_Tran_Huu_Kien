package e1.cart.model;

public class Cart {
    private Integer iphoneCount = 0;
    private Integer samsungCount = 0;
    private Integer nokiaCount = 0;
    private Integer total = 0;

    public Integer getIphoneCount() {
        return iphoneCount;
    }

    public void setIphoneCount(Integer iphoneCount) {
        this.iphoneCount = iphoneCount;
    }

    public Integer getSamsungCount() {
        return samsungCount;
    }

    public void setSamsungCount(Integer samsungCount) {
        this.samsungCount = samsungCount;
    }

    public Integer getNokiaCount() {
        return nokiaCount;
    }

    public void setNokiaCount(Integer nokiaCount) {
        this.nokiaCount = nokiaCount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
