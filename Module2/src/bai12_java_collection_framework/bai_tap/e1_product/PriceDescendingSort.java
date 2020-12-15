package bai12_java_collection_framework.bai_tap.e1_product;

import java.util.Comparator;

public class PriceDescendingSort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
