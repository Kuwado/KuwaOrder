package model.tabledata;

import controller.SiteController;
import model.SiteOrder;
import solution.DateConverter;

public class ExpectedSiteOrder {
    private static int idCounter = 1;
    private  int id;
    private String name;
    private String deliveryType;
    private int quantity;
    private String price;
    private String expectedDate;

    private SiteController siteController = new SiteController();

    public ExpectedSiteOrder(SiteOrder siteOrder, int date) {
        this.id = idCounter++;
        this.name = siteController.getSiteById(siteOrder.getSiteId()).getName();
        this.deliveryType = siteOrder.getDeliveryType();
        this.quantity = siteOrder.getQuantity();
        this.price = String.format("%,d", Math.round(siteOrder.getPrice()));
        this.expectedDate = DateConverter.addDaysToDate(date);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public static void setIdCounter(int idCounter) {
        ExpectedSiteOrder.idCounter = idCounter;
    }
}
