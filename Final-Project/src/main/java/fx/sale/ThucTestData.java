package fx.sale;

import javafx.scene.control.CheckBox;

import java.sql.Date;

public class ThucTestData {
    private int siteOrderId;
    private String siteName;
    private String productName;
    private int quantity;
    private String unit;
    private String delivery;
    private Date desiredDate;
    private CheckBox selected;

    public ThucTestData(int siteOrderId, String siteName, String productName, int quantity, String unit, String delivery, Date desiredDate, CheckBox selected) {
        this.siteOrderId = siteOrderId;
        this.siteName = siteName;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
        this.desiredDate = desiredDate;
        this.selected = selected;
    }

    public int getSiteOrderId() {
        return siteOrderId;
    }

    public void setSiteOrderId(int siteOrderId) {
        this.siteOrderId = siteOrderId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }
}
