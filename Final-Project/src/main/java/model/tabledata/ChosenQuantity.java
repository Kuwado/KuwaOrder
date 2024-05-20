package model.tabledata;

import controller.SiteController;

public class ChosenQuantity {
    private int siteId;
    private int chosenQuantity;
    private String deliveryType;
    private double deliveryPrice;
    private double productPrice;
    private int quantity;
    private boolean stt;

    private final SiteController siteController = new SiteController();


    public ChosenQuantity(int siteId, int chosenQuantity, String deliveryType) {
        this.siteId = siteId;
        this.chosenQuantity = chosenQuantity;
        this.deliveryType = deliveryType;
        if (deliveryType.equals("Đường thủy")) {
            this.deliveryPrice = siteController.getSiteById(siteId).getShipPrice();
        }
        else if (deliveryType.equals("Hàng không")) {
            this.deliveryPrice = siteController.getSiteById(siteId).getAirPrice();
        }
        this.stt = true;
    }

    public ChosenQuantity(int siteId, int chosenQuantity, String deliveryType, double deliveryPrice, double productPrice, int quantity) {
        this.siteId = siteId;
        this.chosenQuantity = chosenQuantity;
        this.deliveryType = deliveryType;
        this.deliveryPrice = deliveryPrice;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getSiteId() {
        return siteId;
    }

    public int getChosenQuantity() {
        return chosenQuantity;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isStt() {
        return stt;
    }

    public void setChosenQuantity(int chosenQuantity) {
        this.chosenQuantity = chosenQuantity;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }
}
