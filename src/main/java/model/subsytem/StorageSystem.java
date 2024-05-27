package model.subsytem;

import config.DbUtil;
import model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StorageSystem implements DBInterface<Storage> {

    @Override
    public void insert(Storage storage) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "INSERT INTO storage (product_id, quantity) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, storage.getProductId());
            pst.setInt(2, storage.getQuantity());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "DELETE FROM storage WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Storage storage) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "UPDATE storage SET quantity = ? WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, storage.getQuantity());
            pst.setInt(2, storage.getProductId());
            pst.executeUpdate();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Storage> selectAll() {
        ArrayList<Storage> storages = new ArrayList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM storage";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                Storage storage = new Storage(productId, quantity);
                storages.add(storage);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, e);
        }
        return storages;
    }

    @Override
    public Storage selectById(int id) {
        Storage storage = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM storage WHERE product_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                storage = new Storage(productId, quantity);
            }
            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, e);
        }
        return storage;
    }

    // Update quantity by adding the new quantity to the current quantity
    public void updateQuantity(int productId, int quantity) {
        try {
            Connection con = DbUtil.getConnection();

            // Lấy số lượng hiện tại từ cơ sở dữ liệu
            String selectSql = "SELECT quantity FROM storage WHERE product_id = ?";
            PreparedStatement selectPst = con.prepareStatement(selectSql);
            selectPst.setInt(1, productId);
            ResultSet rs = selectPst.executeQuery();

            if (rs.next()) {
                int currentQuantity = rs.getInt("quantity");

                // Cộng thêm số lượng mới vào số lượng hiện tại
                int newQuantity = currentQuantity + quantity;

                // Cập nhật lại cơ sở dữ liệu với số lượng mới
                String updateSql = "UPDATE storage SET quantity = ? WHERE product_id = ?";
                PreparedStatement updatePst = con.prepareStatement(updateSql);
                updatePst.setInt(1, newQuantity);
                updatePst.setInt(2, productId);
                updatePst.executeUpdate();
            }

            rs.close();
            selectPst.close();
            DbUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(StorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
