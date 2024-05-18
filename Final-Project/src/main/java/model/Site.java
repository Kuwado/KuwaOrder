package model;

import java.util.List;

public class Site {
    private int id;
    private String name;
    private int shipDate;
    private int airDate;
    private double shipPrice;
    private double airPrice;
    private List<SiteProduct> products;
    private int soldQuantity;
    private String description;

    public Site(int id, String name, int shipDate, int airDate, double shipPrice, double airPrice, List<SiteProduct> products, String description) {
        this.id = id;
        this.name = name;
        this.shipDate = shipDate;
        this.airDate = airDate;
        this.shipPrice = shipPrice;
        this.airPrice = airPrice;
        this.products = products;
        this.description = description;
        int quan = 0;
        for (SiteProduct product : products) {
            quan += product.getSoldQuantity();
        }
        this.soldQuantity = quan;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getShipDate() {
        return shipDate;
    }

    public int getAirDate() {
        return airDate;
    }

    public double getShipPrice() {
        return shipPrice;
    }

    public double getAirPrice() {
        return airPrice;
    }

    public List<SiteProduct> getProducts() {
        return products;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public String getDescription() {
        return description;
    }
}