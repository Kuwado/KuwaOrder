package SwingCaculator;
// Lưu Việt Hoàn - 20215054
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SwingCalculatorController {
    private SwingCalculatorModel model;
    private SwingCalculatorView view;
    private String currentOperator = ""; // toán tử
    private double firstOperand = 0.0; // Phần tử đầu

    public SwingCalculatorController(SwingCalculatorModel model, SwingCalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.actionCalculate(new ButtonClickListener());

    }

    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();
            switch (command) {
                case "C":
                    view.setDisplayText(""); // xóa text
                    currentOperator = "";
                    firstOperand = 0.0;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    currentOperator = command; // xác định loại toán tử
                    firstOperand = Double.parseDouble(view.getDisplayText());
                    view.setDisplayText("");
                    break;
                // Khi ấn "=" thì kết quả mới hiện ra
                case "=":
                    double secondOperand = Double.parseDouble(view.getDisplayText()); // phần tử thứ 2
                    model.calculate(firstOperand, secondOperand, currentOperator); // thực hiện tính toán
                    view.setDisplayText(Double.toString(model.getAns())); // hiển thị kết quả
                    currentOperator = "";
                    firstOperand = 0.0;
                    break;
                default:
                    view.setDisplayText(view.getDisplayText() + command); // với các số => in ra text
                    break;
            }
        }
    }

}
