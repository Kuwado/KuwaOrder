package controller;

import model.Product;
import model.Product;
import model.subsytem.ProductSystem;

import java.util.ArrayList;

public class ProductController {
    private final ProductSystem productSystem = new ProductSystem();
    public ArrayList<Product> products;
    public Product product;

    public ProductController() {

    }

    public void insert(Product product) {
        productSystem.insert(product);
    }

    // Lấy tất cả products
    public ArrayList<Product> getAllProducts() {
        products = productSystem.selectAll();
        return products;
    }

    // Lấy product bằng id
    public Product getProductById(int product_id) {
        product = productSystem.selectById(product_id);
        return product;
    }
}
