package model.subsytem;

import config.DbUtil;
import model.SiteOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SiteOrderSystem implements DBInterface<SiteOrder> {
    // Add new SiteOrder
    @Override
    public void insert(SiteOrder siteOrder) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "INSERT INTO siteOrders (order_id, site_id, quantity, delivery_type, price, note) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, siteOrder.getOrderId());
            pst.setInt(2, siteOrder.getSiteId());
            pst.setInt(3, siteOrder.getQuantity());
            pst.setString(4, siteOrder.getDeliveryType());
            pst.setDouble(5, siteOrder.getPrice());
            pst.setString(6, siteOrder.getNote());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Delete SiteOrder by ID
    @Override
    public void delete(int id) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "DELETE FROM siteOrders WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Update SiteOrder
    @Override
    public void update(SiteOrder siteOrder) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "UPDATE siteOrders SET order_id = ?, site_id = ?, quantity = ?, delivery_type = ?, price = ?, status = ?, note = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, siteOrder.getOrderId());
            pst.setInt(2, siteOrder.getSiteId());
            pst.setInt(3, siteOrder.getQuantity());
            pst.setString(4, siteOrder.getDeliveryType());
            pst.setDouble(5, siteOrder.getPrice());
            pst.setString(6, siteOrder.getStatus());
            pst.setString(7, siteOrder.getNote());
            pst.setInt(8, siteOrder.getId());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Retrieve all SiteOrders
    @Override
    public ArrayList<SiteOrder> selectAll() {
        ArrayList<SiteOrder> siteOrders = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM siteOrders";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int orderId = rs.getInt("order_id");
                int siteId = rs.getInt("site_id");
                int quantity = rs.getInt("quantity");
                String deliveryType = rs.getString("delivery_type");
                double price = rs.getDouble("price");
                String status = rs.getString("status");
                String note = rs.getString("note");
                SiteOrder siteOrder = new SiteOrder(id, orderId, siteId, quantity, deliveryType, price, status, note);
                siteOrders.add(siteOrder);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, e);
        }
        return siteOrders;
    }

    // Retrieve a SiteOrder by ID
    @Override
    public SiteOrder selectById(int id) {
        SiteOrder siteOrder = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM siteOrders WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("order_id");
                int siteId = rs.getInt("site_id");
                int quantity = rs.getInt("quantity");
                String deliveryType = rs.getString("delivery_type");
                double price = rs.getDouble("price");
                String status = rs.getString("status");
                String note = rs.getString("note");
                siteOrder = new SiteOrder(id, orderId, siteId, quantity, deliveryType, price, status, note);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, e);
        }
        return siteOrder;
    }

    // Update status
    public void updateStatus(int id, String status) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "UPDATE siteorders SET status = ? WHERE id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, status);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
