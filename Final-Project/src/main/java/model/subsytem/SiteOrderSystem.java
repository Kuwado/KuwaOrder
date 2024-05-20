package model.subsytem;

import config.DbUtil;
import model.SiteOrder;
import model.SiteOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SiteOrderSystem implements DBInterface<SiteOrder> {
    // Thêm
    @Override
    public void insert(SiteOrder siteOrder) {
//        try {
//            Connection con = DbUtil.getConnection();
//            String sql = "INSERT INTO siteOrders (siteOrder_id, quantity, unit, desired_date, note, request_id) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, siteOrder.getSiteOrderId());
//            pst.setInt(2, siteOrder.getQuantity());
//            pst.setString(3, siteOrder.getUnit());
//            pst.setString(4, siteOrder.getDesiredDate());
//            pst.setString(5, siteOrder.getNote());
//            pst.setInt(6, siteOrder.getRequestId());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Xóa
    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM siteOrders WHERE `id` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sửa
    @Override
    public void update(SiteOrder siteOrder) {
//        try {
//            Connection con = (Connection) DbUtil.getConnection();
//            String sql = "UPDATE siteOrders SET quantity = ?, unit = ?, desired_date = ?, note = ? WHERE id = ?";
//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, siteOrder.getQuantity());
//            pst.setString(2, siteOrder.getUnit());
//            pst.setString(3, siteOrder.getDesiredDate());
//            pst.setString(4, siteOrder.getNote());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteOrderSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Tìm tất cả
    @Override
    public ArrayList<SiteOrder> selectAll() {
        ArrayList<SiteOrder> siteOrders = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM siteOrders";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
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
            System.out.println(e);
        }
        return siteOrders;
    }

    // Tìm bằng ID
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
            System.out.println(e);
        }
        return siteOrder;
    }

}
