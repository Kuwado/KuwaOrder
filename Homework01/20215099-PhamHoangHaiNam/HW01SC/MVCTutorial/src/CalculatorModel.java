// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private double calculationValue;
	

    public void addTwoNumbers(double firstNumber, double secondNumber) {
        calculationValue = firstNumber + secondNumber;
    }

    public void subTwoNumbers(double firstNumber, double secondNumber) {
        calculationValue = firstNumber - secondNumber;
    }

    public void mulTwoNumbers(double firstNumber, double secondNumber) {
        calculationValue = firstNumber * secondNumber;
    }

    public void divTwoNumbers(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }if (firstNumber < secondNumber) {
        	calculationValue = (double) firstNumber / secondNumber;
        }else {
        	calculationValue = firstNumber / secondNumber;
    
        }
    }
	public double getCalculationValue(){
		
		return calculationValue;
		
	}
	
}