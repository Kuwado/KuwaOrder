package SwingCaculator;
//Lưu Việt Hoàn - 20215054
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculatorView extends JFrame {
	private JTextField display;
    private String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "=", "C", "/"
        };
    private JButton[] buttons;

    public SwingCalculatorView() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // thoát khi ấn X

        display = new JTextField();
        display.setEditable(false); // Tắt quyền edit trên text
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        
        // Thêm các phím 
        buttons = new JButton[buttonLabels.length]; 
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }
    
    // Hành động khi click button
    void actionCalculate(ActionListener a) {
    	 for (int i = 0; i < buttonLabels.length; i++) {
             buttons[i].addActionListener(a);
         }

    }
}
