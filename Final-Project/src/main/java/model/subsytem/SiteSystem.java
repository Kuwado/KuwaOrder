package model.subsytem;

import config.DbUtil;
import model.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SiteSystem implements DBInterface<Site> {
    // Thêm
    @Override
    public void insert(Site site) {
//        try {
//            Connection con = DbUtil.getConnection();
//            String sql = "INSERT INTO sites (site_id, quantity, unit, desired_date, note, request_id) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, site.getSiteId());
//            pst.setInt(2, site.getQuantity());
//            pst.setString(3, site.getUnit());
//            pst.setString(4, site.getDesiredDate());
//            pst.setString(5, site.getNote());
//            pst.setInt(6, site.getRequestId());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Xóa
    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM sites WHERE `id` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sửa
    @Override
    public void update(Site site) {
//        try {
//            Connection con = (Connection) DbUtil.getConnection();
//            String sql = "UPDATE sites SET quantity = ?, unit = ?, desired_date = ?, note = ? WHERE id = ?";
//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, site.getQuantity());
//            pst.setString(2, site.getUnit());
//            pst.setString(3, site.getDesiredDate());
//            pst.setString(4, site.getNote());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Tìm tất cả
    @Override
    public ArrayList<Site> selectAll() {
        ArrayList<Site> sites = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM sites";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int shipDate = rs.getInt("ship_date");
                int airDate = rs.getInt("air_date");
                double shipPrice = rs.getDouble("ship_price");
                double airPrice = rs.getDouble("air_price");
                int soldQuantity = rs.getInt("sold_quantity");
                String information = rs.getString("information");
                Site site = new Site(id, name, shipDate, airDate, shipPrice, airPrice, soldQuantity, information);
                sites.add(site);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sites;
    }

    // Tìm bằng ID
    @Override
    public Site selectById(int id) {
        Site site = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM sites WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int shipDate = rs.getInt("ship_date");
                int airDate = rs.getInt("air_date");
                double shipPrice = rs.getDouble("ship_price");
                double airPrice = rs.getDouble("air_price");
                int soldQuantity = rs.getInt("sold_quantity");
                String information = rs.getString("information");
                site = new Site(id, name, shipDate, airDate, shipPrice, airPrice, soldQuantity, information);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return site;
    }

}
