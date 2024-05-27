package controller;

import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ProductControllerTest {

    private ProductController productController;

    @BeforeEach
    public void setUp() {
        productController = new ProductController();
    }

    @Test
    public void testGetAllProducts() {
        ArrayList<Product> products = productController.getAllProducts();

        // Ensure that the list of products is not null and not empty
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    public void testGetProductById() {
        // Insert a product
        Product product = new Product(1, "Tivi", "/images/products/1-tivi.jpg", "Điện máy", "Tivi thì để sờ em chứ còn làm gì");
        productController.insert(product);

        // Retrieve the product by ID and check if it matches the inserted product
        Product retrievedProduct = productController.getProductById(1);
        assertNotNull(retrievedProduct);
        assertEquals(product.getId(), retrievedProduct.getId());
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getDescription(), retrievedProduct.getDescription());
        assertEquals(product.getImage(), retrievedProduct.getImage());
    }
}
