package fx.site;

import javafx.scene.control.CheckBox;

public class TestData {
    private int siteOrderId;
    private int orderId;
    private String productName;
    private String unit;
    private int quantity;
    private String delivery;
    private String status;
    private CheckBox selected;

    public TestData(String productName, String unit, int quantity) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public TestData(int siteOrderId, int orderId, String productName, int quantity, String unit, String delivery, String status, CheckBox selected) {
        this.siteOrderId = siteOrderId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
        this.status = status;
        this.selected = selected;
    }

    public TestData(int siteOrderId, int orderId, String productName, String unit, int quantity, String delivery, String status) {
        this.siteOrderId = siteOrderId;
        this.orderId = orderId;
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
        this.delivery = delivery;
        this.status = status;
    }

    public TestData(int siteOrderId, int orderId, String productName, String unit, int quantity, String delivery, String status, CheckBox selected) {
        this.siteOrderId = siteOrderId;
        this.orderId = orderId;
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
        this.delivery = delivery;
        this.status = status;
        this.selected = selected;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getSiteOrderId() {
        return siteOrderId;
    }

    public void setSiteOrderId(int siteOrderId) {
        this.siteOrderId = siteOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }
}
