package model.tabledata;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
    private HBox action2;
    private Button action;

    public MORequest(Request request, Button button) {
        this.id = idCounter++;
        this.request = request;
        this.name = request.getName();
        this.orderQuantity = request.getOrderQuantity();
        this.sendDate = request.getSendDate();
        this.status = request.getStatus();
        this.orders = request.getOrders();
        this.description = request.getDescription();
        this.action = button;
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

    public Button getAction() {
        return action;
    }

    public void resetIdCounter() {
        idCounter = 1;
    }


}
