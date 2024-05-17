package model.tabledata;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import model.Order;
import model.Request;
import solution.ButtonIntoTable;

import java.io.IOException;
import java.util.List;

public class MORequest  implements TableData {
    private static int idCounter = 1;
    private int id;
    private Request request;
    public String name;
    public int orderQuantity;
    public String sendDate;
    public String status;
    public List<Order> orders;
    public String description;
    private HBox action;

    public MORequest(Request request) {
        this.id = idCounter++;
        this.request = request;
        this.name = request.getName();
        this.orderQuantity = request.getOrderQuantity();
        this.sendDate = request.getSendDate();
        this.status = request.getStatus();
        this.orders = request.getOrders();
        this.description = request.getDescription();
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

    public Request getRequest() {
        return request;
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

    public HBox getAction() {
        return action;
    }

    public void resetIdCounter() {
        idCounter = 1;
    }
}
