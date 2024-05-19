package model.tabledata;

public class ConfirmSite {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String deliveryType;
    private int quantity;
    private String expectedDate;

    public ConfirmSite(String name, String deliveryType, int quantity, String expectedDate) {
        this.id = idCounter++;
        this.name = name;
        this.deliveryType = deliveryType;
        this.quantity = quantity;
        this.expectedDate = expectedDate;
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

    public String getExpectedDate() {
        return expectedDate;
    }
}
