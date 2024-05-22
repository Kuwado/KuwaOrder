package model.tabledata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.sql.*;

public class Reorder {

    private int siteOrderId;
    private int productId;
    private String productName;
    private int productQuantity;
    private String unit;
    private String status;
    private String desiredDate;
    private int selectedQuantity;
    private CheckBox productSelected;

    public Reorder(int siteOrderId, int productId, String productName, int productQuantity, String unit, String status, String desiredDate, int selectedQuantity, CheckBox productSelected) {
        this.siteOrderId = siteOrderId;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.unit = unit;
        this.status = status;
        this.desiredDate = desiredDate;
        this.selectedQuantity = selectedQuantity;
        this.productSelected = productSelected;
    }

    private int siteId;
    private String siteName;
    private int siteProductId;
    private String delivery;
    private int shipDate;
    private int airDate;
    private String expectedDate;
    private int quantityInStock;
    private int quantity;
    private CheckBox selected;

    public Reorder(int siteId, String siteName, int siteProductId, String delivery, String expectedDate, int quantityInStock, int quantity, CheckBox selected) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteProductId = siteProductId;
        this.delivery = delivery;
        this.expectedDate = expectedDate;
        this.quantityInStock = quantityInStock;
        this.quantity = quantity;
        this.selected = selected;
    }

    public static ObservableList<Reorder> productData() {
        ObservableList<Reorder> list = FXCollections.observableArrayList();
        String sqlQuery = "SELECT so.id AS siteOrderId, p.id, p.name, so.quantity, o.unit, o.desired_date, so.status " +
                "FROM products AS p " +
                "JOIN orders AS o ON p.id = o.product_id " +
                "JOIN siteorders AS so ON so.order_id = o.id " +
                "WHERE so.status = 'Đang đặt lại';";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                int siteOrderId = resultSet.getInt("siteOrderId");
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String unit = resultSet.getString("unit");
                String desiredDate = resultSet.getString("desired_date");
                String status = resultSet.getString("status");
                int selectedQuantity = 0;
                CheckBox productSelected = new CheckBox();

                list.add(new Reorder(siteOrderId, productId, productName, quantity, unit, status, desiredDate, selectedQuantity, productSelected));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    public static ObservableList<Reorder> siteData() {
        ObservableList<Reorder> list = FXCollections.observableArrayList();
        String sqlQuery = "SELECT s.id, s.name, sp.product_id, s.ship_date, s.air_date, sp.quantity-sp.sold_quantity AS quantity_in_stock " +
                "FROM sites AS s JOIN siteproducts AS sp ON s.id = sp.site_id;";


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                int siteId = resultSet.getInt("id");
                String sitename = resultSet.getString("name");
                int siteProductId = resultSet.getInt("product_id");
                int shipDate = resultSet.getInt("ship_date");
                int airdate = resultSet.getInt("air_date");
                int quantityInStock = resultSet.getInt("quantity_in_stock");

                list.add(new Reorder());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }




    public int getSiteOrderId() {
        return siteOrderId;
    }

    public void setSiteOrderId(int siteOrderId) {
        this.siteOrderId = siteOrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(String desiredDate) {
        this.desiredDate = desiredDate;
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public CheckBox getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(CheckBox productSelected) {
        this.productSelected = productSelected;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
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

    public int getSiteProductId() {
        return siteProductId;
    }

    public void setSiteProductId(int siteProductId) {
        this.siteProductId = siteProductId;
    }

    public int getShipDate() {
        return shipDate;
    }

    public void setShipDate(int shipDate) {
        this.shipDate = shipDate;
    }

    public int getAirDate() {
        return airDate;
    }

    public void setAirDate(int airDate) {
        this.airDate = airDate;
    }
}
