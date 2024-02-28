package Baitap1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class HelloWorld extends Frame implements ActionListener {
    TextField nameField;
    Label nameLabel;
    Button enterButton;

    public HelloWorld() {
        // Thiết lập các thuộc tính của cửa sổ
        setTitle("Xin chào người dùng");
        setSize(300, 150);
        setLayout(new FlowLayout());

        // Tạo label và text field
        nameLabel = new Label("Nhập tên của bạn:");
        nameField = new TextField(20);

        // Tạo nút enter
        enterButton = new Button("Enter");

        // Đăng ký sự kiện ActionListener cho nút enter
        enterButton.addActionListener(this);

        // Thêm các thành phần vào frame
        add(nameLabel);
        add(nameField);
        add(enterButton);

        // Hiển thị cửa sổ
        setVisible(true);

        // Đăng ký sự kiện WindowListener để đóng ứng dụng khi cửa sổ được đóng
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút submit được nhấn
        String name = nameField.getText();
        if (!name.isEmpty()) {
            // Hiển thị tên trong hộp thoại thông báo
            JOptionPane.showMessageDialog(this, "Xin chào " + name);
        } else {
            // Hiển thị thông báo lỗi nếu người dùng không nhập tên
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng HelloWorld để khởi chạy ứng dụng
       new HelloWorld();
    }
}
