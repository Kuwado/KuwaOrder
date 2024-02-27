package calculate.swing;

import calculate.swing.CalculatorController;
import calculate.swing.CalculatorModel;
import calculate.swing.CalculatorView;

public class MVCCalculator {
    public static void main(String[] args) {

        CalculatorView theView = new CalculatorView();

        CalculatorModel theModel = new CalculatorModel();

        CalculatorController theController = new CalculatorController(theView, theModel);

        theView.setVisible(true);

    }
}
