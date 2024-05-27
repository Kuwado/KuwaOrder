package model.tabledata;

import model.Order;
import model.Product;

public class MROrder {
    private static int id_counter = 1;
    private int id;
    private int productID;
    private String productName;
    private int quantity;
    private String unit;
    private String desired_date;
    private Order order;

    public MROrder(Product product, Order order) {
        this.id = id_counter++;
        this.productID = product.getId();
        this.productName = product.getName();
        this.quantity = order.getQuantity();
        this.unit = order.getUnit();
        this.desired_date = order.getDesiredDate();
        this.order = order;

    }

    public int getId() {
        return id;
    }

    public int getProductID() {
        return productID;
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

    public String getDesired_date() {
        return desired_date;
    }

    public Order getOrder() {
        return order;
    }
}
