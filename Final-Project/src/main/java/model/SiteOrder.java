package model;

public class SiteOrder {
    private int id;
    private int orderId;
    private int siteId;
    private String deliveryType;
    private double price;
    private String status;
    private String note;

    public SiteOrder() {
    }

    public SiteOrder(int id, int orderId, int siteId, String deliveryType, double price, String status, String note) {
        this.id = id;
        this.orderId = orderId;
        this.siteId = siteId;
        this.deliveryType = deliveryType;
        this.price = price;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSiteId() {
        return siteId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }
}
