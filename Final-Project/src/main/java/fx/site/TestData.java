package fx.site;

public class TestData {
    private int siteOrderId;
    private int orderId;
    private String productName;
    private String unit;
    private int quantity;
    private String delivery;
    private String status;

    public TestData(String productName, String unit, int quantity) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
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
}
