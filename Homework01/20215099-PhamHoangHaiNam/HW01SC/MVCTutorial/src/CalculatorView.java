// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 

import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JFrame{

    private JTextField firstNumber = new JTextField(10);
    private JLabel operatorLabel = new JLabel("");
    private JTextField secondNumber = new JTextField(10);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    //private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);
	
	CalculatorView(){
		
		// Sets up the view and adds the components
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(firstNumber);
        calcPanel.add(operatorLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(addButton);
        calcPanel.add(subtractButton);
        calcPanel.add(multiplyButton);
        calcPanel.add(divideButton);
        //calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
		// End of setting up the components --------
		
	}
	

    public int getFirstNumber() {
        return Integer.parseInt(firstNumber.getText());
    }

    public int getSecondNumber() {
        return Integer.parseInt(secondNumber.getText());
    }

    public void setCalcSolution(double solution) {
        calcSolution.setText(String.valueOf(solution));
    }

    public void setOperatorLabel(String operator) {
        operatorLabel.setText(operator);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		addButton.addActionListener(listenForCalcButton);
		subtractButton.addActionListener(listenForCalcButton);
		multiplyButton.addActionListener(listenForCalcButton);
		divideButton.addActionListener(listenForCalcButton);
		
	}
	
	// Open a popup that contains the error message passed
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}