package model;

import fx.other.ButtonIntoTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class Request {
    public int id;
    public String name;
    public int order_quantity;
    public String send_date;
    public String status;
    public ObservableList<Order> orders = FXCollections.observableArrayList();
    public HBox action;

    public Request(int id, String name, int order_quantity, String send_date, String status, ObservableList<Order> orders) {
        this.id = id;
        this.name = name;
        this.order_quantity = order_quantity;
        this.send_date = send_date;
        this.status = status;
        this.orders = orders;
        action = ButtonIntoTable.createAction("j");
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

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public HBox getHbox() {
        return action;
    }
}
