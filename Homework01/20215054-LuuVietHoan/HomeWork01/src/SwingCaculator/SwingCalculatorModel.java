package SwingCaculator;

import javax.swing.JOptionPane;

//Lưu Việt Hoàn - 20215054
public class SwingCalculatorModel {
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
                	JOptionPane.showMessageDialog(null,"Số bị chia phải khác 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
