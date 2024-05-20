package model.tabledata;

import config.DbUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteOrdersList {

    private int siteOrderId;
    private int orderId;
    private int siteId;
    private String productName;
    private int quantity;
    private String unit;
    private String delivery;
    private String status;
    private CheckBox selected;

    public SiteOrdersList(int siteOrderId, int orderId, int siteId, String productName, int quantity, String unit, String delivery, String status, CheckBox selected) {
        this.siteOrderId = siteOrderId;
        this.orderId = orderId;
        this.siteId = siteId;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
        this.status = status;
        this.selected = selected;
    }

//    public static ObservableList<SiteOrdersList> siteOrdersListsData() {
////        ObservableList<SiteOrdersList> list = FXCollections.observableArrayList(
////                new SiteOrdersList(1, 1, 1, "Thùy Dung", 10, "Điểm", "Hàng Không", "Đang xử lý", new CheckBox()),
////                new SiteOrdersList(1, 1, 1, "Meo Meo", 10, "Điểm", "Hàng Không", "Đang xử lý", new CheckBox())
////        );
////        return list;
//        ObservableList<SiteOrdersList> list = FXCollections.observableArrayList();
//
//        try {
//            Connection connection = DbUtil.getConnection();
//            String sqlQuery = "SELECT so.id, so.order_id, so.site_id, p.name, so.quantity, o.unit, so.delivery_type, so.status " +
//                    "FROM siteorders AS so " +
//                    "JOIN orders AS o ON so.order_id = o.id " +
//                    "JOIN products AS p ON o.product_id = p.id;";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()) {
//                int siteOrderId = resultSet.getInt("id");
//                int orderId = resultSet.getInt("order_id");
//                int siteId = resultSet.getInt("site_id");
//                String productName = resultSet.getString("name");
//                int quantity = resultSet.getInt("quantity");
//                String unit = resultSet.getString("unit");
//                String delivery = resultSet.getString("delivery_type");
//                String status = resultSet.getString("status");
//                CheckBox selected = new CheckBox();
//            }
//            DbUtil.closeConnection(connection);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }




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

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }
}
