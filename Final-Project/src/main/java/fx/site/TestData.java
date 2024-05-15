package fx.site;

public class TestData {
    private String productName;
    private String unit;
    private int quantity;

    public TestData(String productName, String unit, int quantity) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
