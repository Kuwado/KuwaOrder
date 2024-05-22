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
    private TextField selectedQuantity;
    private CheckBox productSelected;

    public Reorder(int siteOrderId, int productId, String productName, int productQuantity, String unit, String status, String desiredDate, TextField selectedQuantity, CheckBox productSelected) {
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
                TextField selectedQuantity = new TextField();
                CheckBox productSelected = new CheckBox();

                list.add(new Reorder(siteOrderId, productId, productName, quantity, unit, status, desiredDate, selectedQuantity, productSelected));
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

    public TextField getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(TextField selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public CheckBox getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(CheckBox productSelected) {
        this.productSelected = productSelected;
    }
}
