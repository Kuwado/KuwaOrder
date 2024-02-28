package Baitap1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class HelloWorld extends Frame implements ActionListener {
    TextField nameField;
    Label nameLabel;
    Button submitButton;

    public HelloWorld() {
        // Thiết lập các thuộc tính của cửa sổ
        setTitle("Enter your name:");
        setSize(300, 150);
        setLayout(new FlowLayout());

        // Tạo label và text field
        nameLabel = new Label("Name:");
        nameField = new TextField(20);

        // Tạo nút submit
        submitButton = new Button("Submit");

        // Đăng ký sự kiện ActionListener cho nút submit
        submitButton.addActionListener(this);

        // Thêm các thành phần vào frame
        add(nameLabel);
        add(nameField);
        add(submitButton);

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
            JOptionPane.showMessageDialog(this, "Hello " + name + "!");
        } else {
            // Hiển thị thông báo lỗi nếu người dùng không nhập tên
            JOptionPane.showMessageDialog(this, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng HelloWorld để khởi chạy ứng dụng
       new HelloWorld();
    }
}