package e1.service.impl;

import e1.model.Product;
import e1.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    static Map<Integer, Product> map;

    static {
        map = new HashMap<>();
        map.put(1, new Product(1, "Phone_1", 10.0));
        map.put(2, new Product(2, "Phone_2", 11.0));
        map.put(3, new Product(3, "Phone_3", 12.0));
        map.put(4, new Product(4, "Phone_4", 13.0));
        map.put(5, new Product(5, "Phone_5", 14.0));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return map.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        map.put(id, product);
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }
}
