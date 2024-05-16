package model;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ChosenSite implements TableData {
    private int id;
    private String name;
    private int quantity;
    private String unit;
    private int ship_date;
    private int air_date;
    private int sold_quantity;
    private HBox action;

    public ChosenSite(int id, String name, int quantity, String unit, int ship_date, int air_date, int sold_quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.ship_date = ship_date;
        this.air_date = air_date;
        this.sold_quantity = sold_quantity;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/parts/insert_items/MOText.fxml"));
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

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public int getShip_date() {
        return ship_date;
    }

    public int getAir_date() {
        return air_date;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public HBox getAction() {
        return action;
    }
}
