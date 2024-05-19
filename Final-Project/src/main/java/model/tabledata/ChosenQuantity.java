package model.tabledata;

public class ChosenQuantity {
    private int siteId;
    private int quantity;
    private String deliveryType;

    public ChosenQuantity(int siteId, int quantity, String deliveryType) {
        this.siteId = siteId;
        this.quantity = quantity;
        this.deliveryType = deliveryType;
    }

    public int getSiteId() {
        return siteId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
