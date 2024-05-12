package model;

import javafx.scene.layout.HBox;

public class Order {
    public int id;
    public int product_id;
    public int quantity;
    public String unit;
    public String desired_date;
    public String status;


    public Order(int id, int product_id, int quantity, String unit, String desired_date, String status) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit = unit;
        this.desired_date = desired_date;
        this.status = status;
    }
}
