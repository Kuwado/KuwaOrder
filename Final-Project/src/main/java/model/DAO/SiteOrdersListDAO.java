package model.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import model.tabledata.SiteOrdersList;

import java.sql.*;

public class SiteOrdersListDAO {
    public static ObservableList<SiteOrdersList> siteOrdersListsData() {
        ObservableList<SiteOrdersList> list = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuwaorder", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT so.id, so.order_id, so.site_id, p.name, so.quantity, o.unit, so.delivery_type, so.status FROM siteorders AS so JOIN orders AS o ON so.order_id = o.id JOIN products AS p ON o.product_id = p.id")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int orderId = resultSet.getInt("order_id");
                int siteId = resultSet.getInt("site_id");
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String unit = resultSet.getString("unit");
                String deliveryType = resultSet.getString("delivery_type");
                String status = resultSet.getString("status");
                list.add(new SiteOrdersList(id, orderId, siteId, productName, quantity, unit, deliveryType, status, new CheckBox()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
