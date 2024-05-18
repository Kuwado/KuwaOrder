package model.tabledata;

import controller.OrderController;
import controller.ProductController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Order;
import model.Product;
import solution.ButtonIntoTable;

import java.io.IOException;

public class MOOrder {
    private static int idCounter = 1;
    private int id;
    private Order order;
    private String productName;
    private int quantity;
    private String unit;
    private String desiredDate;
    private String status;
    private Button action;

    private final OrderController orderController = new OrderController();
    private final ProductController productController = new ProductController();

    public MOOrder(Order order, Button button) {
        this.order = order;
        this.id = idCounter++;
        Product product = productController.getProductById(order.getProductId());
        this.productName = product.getName();
        this.quantity = order.getQuantity();
        this.unit = order.getUnit();
        this.desiredDate = order.getDesiredDate();
        this.status = order.getStatus();
        this.action = button;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getDesiredDate() {
        return desiredDate;
    }

    public String getStatus() {
        return status;
    }

    public Button getAction() {
        return action;
    }
}
