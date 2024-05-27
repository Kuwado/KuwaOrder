package model.subsytem;

import config.DbUtil;
import model.Order;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSystem {

    // Kiểm tra type của user
    public User selectTypeByEmailAndPass(String email, String pass) {
        User user = null;
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String image = rs.getString("avatar");
                user = new User(id, name, email, pass, type, image);
            }

            DbUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
}
