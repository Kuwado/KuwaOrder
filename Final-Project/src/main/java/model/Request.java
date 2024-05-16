package model;

import solution.ButtonIntoTable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class Request implements TableData {
    public int id;
    public String name;
    public int order_quantity;
    public String send_date;
    public String status;
    public List<Order> orders;
    public String description;
    public HBox action;

    public Request(int id, String name, int order_quantity, String send_date, String status, List<Order> orders, String description) {
        this.id = id;
        this.name = name;
        this.order_quantity = order_quantity;
        this.send_date = send_date;
        this.status = status;
        this.description = description;
        this.orders = orders;
        try {
            FXMLLoader loader = new FXMLLoader(ButtonIntoTable.class.getResource("/view/parts/insert_items/view.fxml"));
            this.action = loader.load();
        } catch (IOException e) {
            System.err.println("Error loading sidebar: " + e.getMessage());
            e.printStackTrace();
        };

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public String getSend_date() {
        return send_date;
    }

    public String getStatus() {
        return status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getDescription() {
        return description;
    }

    public HBox getAction() {
        return action;
    }
}
