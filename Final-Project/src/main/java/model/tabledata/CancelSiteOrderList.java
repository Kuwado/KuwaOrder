package model.tabledata;

import config.DbUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancelSiteOrderList {

    private int siteOrderId;
    private String siteName;
    private String productName;
    private int quantity;
    private String unit;
    private String delivery;
    private String desiredDate;
    private String status;
    private CheckBox selected;

    public CancelSiteOrderList(int siteOrderId, String siteName, String productName, int quantity, String unit, String delivery, String desiredDate, String status, CheckBox selected) {
        this.siteOrderId = siteOrderId;
        this.siteName = siteName;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
        this.desiredDate = desiredDate;
        this.status = status;
        this.selected = selected;
    }

    public static ObservableList<CancelSiteOrderList> cancelSiteOrderListsData() {
        ObservableList<CancelSiteOrderList> list = FXCollections.observableArrayList();
        String sqlQuery = "SELECT so.id, s.name, p.name, so.quantity, o.unit, so.delivery_type, o.desired_date, so.status " +
                "FROM siteorders AS so " +
                "JOIN sites as s ON so.site_id = s.id " +
                "JOIN orders AS o ON so.order_id = o.id " +
                "JOIN products AS p ON o.product_id = p.id " +
                "WHERE so.status = 'Đang hủy'";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String siteName = resultSet.getString("s.name");
                String productName = resultSet.getString("p.name");
                int quantity = resultSet.getInt("quantity");
                String unit = resultSet.getString("unit");
                String delivery = resultSet.getString("delivery_type");
                String desiredDate = resultSet.getString("desired_date");
                String status = resultSet.getString("status");
                CheckBox selected = new CheckBox();
                if (!"Đang hủy".equals(status)) {
                    selected.setDisable(true);
                }
                list.add(new CancelSiteOrderList(id, siteName, productName, quantity, unit, delivery, desiredDate, status, selected));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void updateStatus(int siteOrderId, String newStatus) {
        String sqlQuery = "UPDATE siteorders SET status = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, siteOrderId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStatus(List<Integer> siteOrderIds, String newStatus) {
        String sqlQuery = "UPDATE siteorders SET status = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            for (int siteOrderId : siteOrderIds) {
                preparedStatement.setString(1, newStatus);
                preparedStatement.setInt(2, siteOrderId);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public String getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(String desiredDate) {
        this.desiredDate = desiredDate;
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
