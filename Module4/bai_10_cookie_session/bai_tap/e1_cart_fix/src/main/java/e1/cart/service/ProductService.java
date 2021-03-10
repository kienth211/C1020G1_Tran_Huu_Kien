package e1.cart.service;

import e1.cart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void save(Product product);
    void removeById(Integer id);
}
