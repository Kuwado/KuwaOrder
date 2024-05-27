package model.subsytem;

import config.DbUtil;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderSystem implements DBInterface<Order> {

    // Thêm
    @Override
    public void insert(Order order) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "INSERT INTO orders (product_id, quantity, desired_date, note, request_id) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, order.getProductId());
            pst.setInt(2, order.getQuantity());
            pst.setString(3, order.getDesiredDate());
            pst.setString(4, order.getNote());
            pst.setInt(5, order.getRequestId());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Xóa
    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM orders WHERE `id` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sửa
    @Override
    public void update(Order order) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "UPDATE orders SET quantity = ?, unit = ?, desired_date = ?, note = ? WHERE id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, order.getQuantity());
            pst.setString(2, order.getUnit());
            pst.setString(3, order.getDesiredDate());
            pst.setString(4, order.getNote());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Tìm tất cả
    @Override
    public ArrayList<Order> selectAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM orders";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String desiredDate = rs.getString("desired_date");
                String status = rs.getString("status");
                String note = rs.getString("note");
                int request_id = rs.getInt("request_id");
                Order order = new Order(id, productId, quantity, unit, desiredDate, status, note, request_id);
                orders.add(order);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orders;
    }

    // Tìm bằng ID
    @Override
    public Order selectById(int id) {
        Order order = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM orders WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String desiredDate = rs.getString("desired_date");
                String status = rs.getString("status");
                String note = rs.getString("note");
                int request_id = rs.getInt("request_id");
                order = new Order(id, productId, quantity, unit, desiredDate, status, note, request_id);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    // Tìm bằng trạng thái
    public ArrayList<Order> selectByStatus(String status) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM orders WHERE status = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, status);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String desiredDate = rs.getString("desired_date");
                String note = rs.getString("note");
                int request_id = rs.getInt("request_id");
                Order order = new Order(id, productId, quantity, unit, desiredDate, status, note, request_id);
                orders.add(order);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orders;
    }

    // Tìm bằng request id
    public ArrayList<Order> selectByRequestId(int request_id) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM orders WHERE request_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, request_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String desiredDate = rs.getString("desired_date");
                String status = rs.getString("status");
                String note = rs.getString("note");
                Order order = new Order(id, productId, quantity, unit, desiredDate, status, note, request_id);
                orders.add(order);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orders;
    }

    // Update status
    public void updateStatus(int id, String status) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "UPDATE orders SET status = ? WHERE id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(2, id);
            pst.setString(1, status);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Tìm bằng trạng thái
    public ArrayList<Order> selectByStatusInRequest(int request_id, String status) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM orders WHERE status = ? AND request_id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, status);
            pst.setInt(2, request_id);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String desiredDate = rs.getString("desired_date");
                String note = rs.getString("note");
                Order order = new Order(id, productId, quantity, unit, desiredDate, status, note, request_id);
                orders.add(order);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orders;
    }


}
