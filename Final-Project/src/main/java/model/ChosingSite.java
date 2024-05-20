package model;

public class ChosingSite {
    private int id;
    private int siteId;
    private String deliveryType;
    private double deliveryPrice;
    private double productPrice;
    private int quantity;

    public ChosingSite(int siteId, String deliveryType, double deliveryPrice, double productPrice, int quantity) {
        this.siteId = siteId;
        this.deliveryType = deliveryType;
        this.deliveryPrice = deliveryPrice;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }


}
