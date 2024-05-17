package model.tabledata;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import model.Order;
import solution.ButtonIntoTable;

import java.io.IOException;

public class MOOrder implements TableData {
    private static int idCounter = 1;
    private int id;
    private Order order;
    private String productName;
    private int quantity;
    private String unit;
    private String desiredDate;
    private String status;
    private HBox action;

    public MOOrder(Order order) {
        this.order = order;
        this.id = idCounter++;
        this.productName = order.getProduct().getName();
        this.quantity = order.getQuantity();
        this.unit = order.getUnit();
        this.desiredDate = order.getDesiredDate();
        this.status = order.getStatus();
        try {
            FXMLLoader loader = new FXMLLoader(ButtonIntoTable.class.getResource("/view/parts/insertitems/View.fxml"));
            this.action = loader.load();
        } catch (IOException e) {
            System.err.println("Error loading sidebar: " + e.getMessage());
            e.printStackTrace();
        };
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

    public HBox getAction() {
        return action;
    }
}
