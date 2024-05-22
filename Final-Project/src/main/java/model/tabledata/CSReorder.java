package model.tabledata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import net.synedra.validatorfx.Check;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSReorder {

    private int siteOrderId;
    private int productId;
    private String productName;
    private int productQuantity;
    private String unit;
    private String status;
    private String desiredDate;
    private int selectedQuantity;
    private CheckBox productSelected;

    public CSReorder(int siteOrderId, int productId, String productName, int productQuantity, String unit, String status, String desiredDate, int selectedQuantity, CheckBox productSelected) {
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
    private TextField quantity;
    private CheckBox selected;

    public CSReorder(int siteId, String siteName, int siteProductId, String delivery, String expectedDate, int quantityInStock, TextField quantity, CheckBox selected) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteProductId = siteProductId;
        this.delivery = delivery;
        this.expectedDate = expectedDate;
        this.quantityInStock = quantityInStock;
        this.quantity = quantity;
        this.selected = selected;
    }


    public static ObservableList<CSReorder> productData() {
        ObservableList<CSReorder> list = FXCollections.observableArrayList();
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

                list.add(new CSReorder(siteOrderId, productId, productName, quantity, unit, status, desiredDate, selectedQuantity, productSelected));
                //System.out.println("Added product " + productName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    public static ObservableList<CSReorder> siteData() {
        ObservableList<CSReorder> list = FXCollections.observableArrayList();
        String sqlQuery = "SELECT sp.site_id, s.name, o.product_id, s.ship_date, s.air_date, sp.quantity - sp.sold_quantity as quantity_in_stock " +
                "FROM siteorders AS so " +
                "JOIN orders AS o on so.order_id = o.id " +
                "JOIN siteproducts AS sp ON o.product_id = sp.product_id " +
                "JOIN sites as s ON sp.site_id = s.id WHERE so.status = 'Đang đặt lại';";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "")) {
            //System.out.println("Connected to the database.");

            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                //System.out.println("Executed query: " + sqlQuery);

                while (resultSet.next()) {
                    int siteId = resultSet.getInt("site_id");
                    String siteName = resultSet.getString("name");
                    int siteProductId = resultSet.getInt("product_id");
                    int shipDate = resultSet.getInt("ship_date");
                    int airDate = resultSet.getInt("air_date");
                    String delivery1 = "Tàu";
                    String delivery2 = "Máy bay";
                    LocalDate today = LocalDate.now();
                    String expectedDate1 = today.plusDays(shipDate).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    String expectedDate2 = today.plusDays(airDate).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    int quantityInStock = resultSet.getInt("quantity_in_stock");

                    TextField quantity1 = new TextField();
                    TextField quantity2 = new TextField();
                    CheckBox selected = new CheckBox();


                    list.add(new CSReorder(siteId, siteName, siteProductId, delivery1, expectedDate1, quantityInStock, quantity1, selected));
                    list.add(new CSReorder(siteId, siteName, siteProductId, delivery2, expectedDate2, quantityInStock, quantity2, selected));
                    //System.out.println("Added site: " + siteName);
                }
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

    public TextField getQuantity() {
        return quantity;
    }

    public void setQuantity(TextField quantity) {
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
