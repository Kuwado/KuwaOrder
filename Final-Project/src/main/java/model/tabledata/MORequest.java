package model.tabledata;

import javafx.scene.control.Button;
import model.Request;
import solution.DateConverter;

public class MORequest {
    private static int idCounter = 1;
    private int id;
    private Request request;
    public String name;
    public int orderQuantity;
    public String sendDate;
    public String status;
    public String description;
    private Button action;

    public MORequest(Request request, Button button) {
        this.id = idCounter++;
        this.request = request;
        this.name = request.getName();
        this.orderQuantity = request.getOrderQuantity();
        this.sendDate = DateConverter.convertDateTime(request.getSendDate());
        this.status = request.getStatus();
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

    public String getDescription() {
        return description;
    }

    public Button getAction() {
        return action;
    }

    public static void setIdCounter(int idCounter) {
        MORequest.idCounter = idCounter;
    }
}
