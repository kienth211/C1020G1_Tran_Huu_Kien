package repository.impl;

import bean.Product;
import repository.ProductRepository;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Apple", 10.0, "Apple", "AppleProduct"));
        products.put(2, new Product(2, "Samsung", 20.0, "Samsung", "SamsungProduct"));
        products.put(3, new Product(3, "Nokia", 15.0, "Nokia", "NokiaProduct"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
