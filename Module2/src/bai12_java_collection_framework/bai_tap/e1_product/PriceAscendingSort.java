package bai12_java_collection_framework.bai_tap.e1_product;

import java.util.Comparator;

public class PriceAscendingSort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
