package model.tabledata;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Order;
import model.Product;
import model.Site;
import model.SiteProduct;

import java.io.IOException;

public class ChosenSite {
    private static int idCounter = 1;
    private int id;
    private Order order;
    private Product product;
    private Site site;
    private String name;
    private int quantity;
    private String unit;
    private int shipDate;
    private int airDate;
    private TextField action;
    private String deliveryStt;

    public ChosenSite(Order order, Product product, Site site, ChosenQuantity chosenQuantity, TextField textfield) {
        this.id = idCounter++;
        this.order = order;
        this.product = product;
        this.site = site;
        this.name = site.getName();
        this.quantity = chosenQuantity.getQuantity();
        this.unit = order.getUnit();
        this.shipDate = site.getShipDate();
        this.airDate = site.getAirDate();
        this.action = textfield;
    }



    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Site getSite() {
        return site;
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

    public int getShipDate() {
        return shipDate;
    }

    public int getAirDate() {
        return airDate;
    }

    public TextField getAction() {
        return action;
    }

    public String getDeliveryStt() {
        if(deliveryStt != null)
            return deliveryStt;
        else
            return null;
    }

    public void setDeliveryStt(String deliveryStt) {
        this.deliveryStt = deliveryStt;
    }

    public void setAction(TextField action) {
        this.action = action;
    }

    public static void setIdCounter(int idCounter) {
        ChosenSite.idCounter = idCounter;
    }
}
