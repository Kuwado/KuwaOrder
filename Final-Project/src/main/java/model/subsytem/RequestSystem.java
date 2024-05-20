package model.subsytem;

import config.DbUtil;
import model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestSystem implements DBInterface<Request> {

    @Override
    public void insert(Request request) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "INSERT INTO requests(name, description) VALUES (?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,request.getName());
            pst.setString(2, request.getDescription());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(RequestSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Request request) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "UPDATE requests SET description = ? WHERE id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, request.getDescription());
            pst.setInt(2, request.getId());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(RequestSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM requests WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(RequestSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Request selectById(int id) {
        Request request = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM requests WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) { // Kiểm tra xem có dữ liệu trong ResultSet hay không
                String name = rs.getString("name");
                int orderQuantity = rs.getInt("order_quantity");
                String sendDate = rs.getString("send_date");
                String description = rs.getString("description");
                String status = rs.getString("status");
                request = new Request(id, name, orderQuantity, sendDate, description, status);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return request;
    }


    @Override
    public ArrayList<Request> selectAll() {
        ArrayList<Request> requests = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM requests";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int orderQuantity = rs.getInt("order_quantity");
                String sendDate = rs.getString("send_date");
                String description = rs.getString("description");
                String status = rs.getString("status");
                Request request = new Request(id,name, orderQuantity,sendDate, description, status);
                requests.add(request);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return requests;
    }

    public ArrayList<Request> selectByStatus(String status) {
        ArrayList<Request> requests = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM requests WHERE status = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, status);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int orderQuantity = rs.getInt("order_quantity");
                String sendDate = rs.getString("send_date");
                String description = rs.getString("description");
                Request request = new Request(id,name, orderQuantity,sendDate, description, status);
                requests.add(request);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return requests;
    }

    // Update status
    public void updateStatus(int id, String status) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
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
