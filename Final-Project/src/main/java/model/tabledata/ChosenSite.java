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
    private SiteProduct siteProduct;
    private String name;
    private int quantity;
    private String unit;
    private int shipDate;
    private int airDate;
    //private int soldQuantity;
    //private HBox action;
    private TextField action;

//    public ChosenSite(Order order, Product product, Site site, SiteProduct siteProduct) {
//        this.id = idCounter++;
//        this.order = order;
//        this.product = product;
//        this.site = site;
//        this.siteProduct = siteProduct;
//        this.name = site.getName();
//        this.quantity = siteProduct.getQuantity();
//        this.unit = order.getUnit();
//        this.shipDate = site.getShipDate();
//        this.airDate = site.getAirDate();
//        this.soldQuantity = siteProduct.getSoldQuantity();
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/parts/insertitems/MOText.fxml"));
//            this.action = loader.load();
//        } catch (IOException e) {
//            System.err.println("Error loading sidebar: " + e.getMessage());
//            e.printStackTrace();
//        };
//    }

    public ChosenSite(Order order, Product product, Site site, SiteProduct siteProduct, TextField textfield) {
        this.id = idCounter++;
        this.order = order;
        this.product = product;
        this.site = site;
        this.siteProduct = siteProduct;
        this.name = site.getName();
        this.quantity = siteProduct.getQuantity();
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

    public SiteProduct getSiteProduct() {
        return siteProduct;
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

//    public int getSoldQuantity() {
//        return soldQuantity;
//    }
//
////    public HBox getAction() {
////        return action;
////    }


    public TextField getAction() {
        return action;
    }
}
