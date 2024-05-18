package model.subsytem;

import config.DbUtil;
import model.Site;
import model.SiteProduct;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SiteProductSystem implements DBInterface<SiteProduct> {
    // Thêm
    @Override
    public void insert(SiteProduct siteproduct) {
//        try {
//            Connection con = DbUtil.getConnection();
//            String sql = "INSERT INTO siteproducts (id, quantity, unit, desired_date, note, request_id) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, siteproduct.getSiteProductId());
//            pst.setInt(2, siteproduct.getQuantity());
//            pst.setString(3, siteproduct.getUnit());
//            pst.setString(4, siteproduct.getDesiredDate());
//            pst.setString(5, siteproduct.getNote());
//            pst.setInt(6, siteproduct.getRequestId());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteProductSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Xóa
    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM siteproducts WHERE `id` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SiteProductSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sửa
    @Override
    public void update(SiteProduct siteproduct) {
//        try {
//            Connection con = (Connection) DbUtil.getConnection();
//            String sql = "UPDATE siteproducts SET quantity = ?, unit = ?, desired_date = ?, note = ? WHERE id = ?";
//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, siteproduct.getQuantity());
//            pst.setString(2, siteproduct.getUnit());
//            pst.setString(3, siteproduct.getDesiredDate());
//            pst.setString(4, siteproduct.getNote());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(SiteProductSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Tìm tất cả
    @Override
    public ArrayList<SiteProduct> selectAll() {
        ArrayList<SiteProduct> siteproducts = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM siteproducts";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int siteId = rs.getInt("site_id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                SiteProduct siteproduct = new SiteProduct(id, siteId, productId, quantity, soldQuantity, price);
                siteproducts.add(siteproduct);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return siteproducts;
    }

    // Tìm bằng ID
    @Override
    public SiteProduct selectById(int id) {
        SiteProduct siteproduct = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM siteproducts WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int siteId = rs.getInt("site_id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                siteproduct = new SiteProduct(id, siteId, productId, quantity, soldQuantity, price);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return siteproduct;
    }

    // Tìm kiếm bằng site id
    public ArrayList<SiteProduct> selectBySiteId(int siteId) {
        ArrayList<SiteProduct> siteproducts = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM siteproducts WHERE site_id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, siteId);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                SiteProduct siteproduct = new SiteProduct(id, siteId, productId, quantity, soldQuantity, price);
                siteproducts.add(siteproduct);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return siteproducts;
    }

    public ArrayList<SiteProduct> selectByProductId(int productId) {
        ArrayList<SiteProduct> siteproducts = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM siteproducts WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int siteId = rs.getInt("site_id");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                SiteProduct siteproduct = new SiteProduct(id, siteId, productId, quantity, soldQuantity, price);
                siteproducts.add(siteproduct);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return siteproducts;
    }

    // Lấy các site có bán product
    public ArrayList<Site> selectSiteByProductId(int productId) {
        ArrayList<Site> sites = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM sites JOIN siteproducts ON sites.id = siteproducts.site_id WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();

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

    // Lấy các product mà site có bán
    public ArrayList<Product> selectProductBySiteId(int siteId) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM products JOIN siteproducts ON products.id = siteproducts.site_id WHERE site_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, siteId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String category = rs.getString("category");
                String description = rs.getString("description");
                Product product = new Product(id, name, image, category, description);
                products.add(product);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    // Lấy siteproduct từ site và product
    public SiteProduct selectByProductAndSite(int productId, int siteId) {
        SiteProduct siteproduct = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM siteproducts WHERE product_id = ? AND site_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, productId);
            pst.setInt(2, siteId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                siteproduct = new SiteProduct(id, siteId, productId, quantity, soldQuantity, price);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return siteproduct;
    }


}
