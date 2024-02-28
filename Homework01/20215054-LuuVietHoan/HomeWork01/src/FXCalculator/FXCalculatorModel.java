package FXCalculator;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FXCalculatorModel {
	private double ans;
	
    public void calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                ans = num1 + num2;
                break;
            case "-":
                ans = num1 - num2;
                break;
            case "*":
                ans = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    ans = num1 / num2;
                } else {
                	Alert alert = new Alert(AlertType.ERROR);
                	alert.setTitle("Lỗi");
                	alert.setHeaderText("Lỗi số bị chia = 0");
                	alert.setContentText("Vui lòng nhập giá trị khác 0");

                	alert.showAndWait();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
    
    public double getAns() {
    	return ans;
    }
}
