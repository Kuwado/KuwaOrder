package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import model.tabledata.TableData;
import solution.ButtonIntoTable;

import java.io.IOException;

public class Order {
    private int id;
    private Product product;
    private int productId;
    private String productName;
    private int quantity;
    private String unit;
    private String desiredDate;
    private String status;
    private String note;

    public Order(int id, Product product, int quantity, String unit, String desiredDate, String status, String note) {
        this.id = id;
        this.product = product;
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = quantity;
        this.unit = unit;
        this.desiredDate = desiredDate;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductId() {
        return productId;
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

    public String getNote() {
        return note;
    }
}
