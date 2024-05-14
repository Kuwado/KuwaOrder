package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import solution.ButtonIntoTable;

import java.io.IOException;
import java.util.List;

public class Site implements DataInterface{
    private int id;
    private String name;
    private int ship_date;
    private int air_date;
    private int sold_quantity;
    private List<SiteProduct> products;
    private String description;
    private HBox action;

    public Site(int id, String name, int ship_date, int air_date, List<SiteProduct> products) {
        int sold_quantity = 0;
        this.id = id;
        this.name = name;
        this.ship_date = ship_date;
        this.air_date = air_date;
        for (SiteProduct s : products) {
            sold_quantity += s.getSold_quantity();
        }
        this.sold_quantity = sold_quantity;
        this.products = products;
        try {
            FXMLLoader loader = new FXMLLoader(ButtonIntoTable.class.getResource("/view/parts/button_into_table/MOText.fxml"));
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

    public int getShip_date() {
        return ship_date;
    }

    public int getAir_date() {
        return air_date;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public List<SiteProduct> getProducts() {
        return products;
    }

    public String getDescription() {
        return description;
    }

    public void setProducts(List<SiteProduct> products) {
        this.products = products;
    }
}