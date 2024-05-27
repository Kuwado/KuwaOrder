package config;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbUtil {
    public static Connection getConnection() {
        Connection result = null;
        try {
            // Đăng ký MySQL Driver với DriverManager
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Các thông số
            String url = "jdbc:mysql://localhost:3306/kuwaorder";
            String userName = "root";
            String password = "";
            // Tạo kết nối
            result = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM sites";
        try (Connection con = DbUtil.getConnection()) {
            System.out.println("Connected to MySQL Server.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            showInfor(rs);
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
            ex.printStackTrace();
        }
    }

    private static void showInfor(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // In tiêu đề cột
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();

            // In dữ liệu của từng dòng
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
