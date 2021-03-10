package e1.cart.service.impl;

import e1.cart.model.Product;
import e1.cart.repository.ProductRepository;
import e1.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
//        Product product = productRepository.findById(id).orElse(null);
//        product.setQuantity(product.getQuantity() + 1);
        productRepository.save(product);
    }

    @Override
    public void removeById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);
    }


}
