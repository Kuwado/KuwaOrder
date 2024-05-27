package model;

import java.util.List;

public class Request{
    public int id;
    public String name;
    public int orderQuantity;
    public String sendDate;
    public List<Order> orders;
    public String description;
    public String status;

    public Request(int id, String name, String sendDate, String status, List<Order> orders, String description) {
        this.id = id;
        this.name = name;
        this.orderQuantity = orders.size();
        this.sendDate = sendDate;
        this.status = status;
        this.orders = orders;
        this.description = description;
    }

    public Request() {
    }

    public Request(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Request(int id, String name, int orderQuantity, String sendDate, String description, String status) {
        this.id = id;
        this.name = name;
        this.orderQuantity = orderQuantity;
        this.sendDate = sendDate;
        this.description = description;
        this.status = status;
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
