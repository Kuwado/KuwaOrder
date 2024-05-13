package model;

import javafx.scene.layout.HBox;

public class Order {
    public int id;
    public int product_id;
    public String product_name;
    public int quantity;
    public String unit;
    public String desired_date;
    public String status;


    public Order(int id, int product_id, int quantity, String unit, String desired_date, String status, String product_name) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit = unit;
        this.desired_date = desired_date;
        this.status = status;
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getDesired_date() {
        return desired_date;
    }

    public String getStatus() {
        return status;
    }

    public String getProduct_name() {
        return product_name;
    }
}
