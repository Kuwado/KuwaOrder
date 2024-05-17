package model;

import model.tabledata.TableData;
import solution.ButtonIntoTable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class Request{
    public int id;
    public String name;
    public int orderQuantity;
    public String sendDate;
    public String status;
    public List<Order> orders;
    public String description;

    public Request(int id, String name, String sendDate, String status, List<Order> orders, String description) {
        this.id = id;
        this.name = name;
        this.orderQuantity = orders.size();
        this.sendDate = sendDate;
        this.status = status;
        this.orders = orders;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getSendDate() {
        return sendDate;
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
}
