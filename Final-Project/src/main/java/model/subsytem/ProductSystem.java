package model.subsytem;

import config.DbUtil;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductSystem implements DBInterface<Product> {
    // Thêm
    @Override
    public void insert(Product product) {
//        try {
//            Connection con = DbUtil.getConnection();
//            String sql = "INSERT INTO products (product_id, quantity, unit, desired_date, note, request_id) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, product.getProductId());
//            pst.setInt(2, product.getQuantity());
//            pst.setString(3, product.getUnit());
//            pst.setString(4, product.getDesiredDate());
//            pst.setString(5, product.getNote());
//            pst.setInt(6, product.getRequestId());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Xóa
    @Override
    public void delete(int id) {
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "DELETE FROM products WHERE `id` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ProductSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sửa
    @Override
    public void update(Product product) {
//        try {
//            Connection con = (Connection) DbUtil.getConnection();
//            String sql = "UPDATE products SET quantity = ?, unit = ?, desired_date = ?, note = ? WHERE id = ?";
//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, product.getQuantity());
//            pst.setString(2, product.getUnit());
//            pst.setString(3, product.getDesiredDate());
//            pst.setString(4, product.getNote());
//            pst.executeUpdate();
//            DbUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Tìm tất cả
    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection con = (Connection) DbUtil.getConnection();
            String sql = "SELECT * FROM products";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
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

    // Tìm bằng ID
    @Override
    public Product selectById(int id) {
        Product product = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                String category = rs.getString("category");
                String description = rs.getString("description");
                product = new Product(id, name, image, category, description);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

}
