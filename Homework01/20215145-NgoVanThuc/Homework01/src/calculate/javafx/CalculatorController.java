package calculate.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML
    private Button btnCalculate;

    @FXML
    private TextField tfFirstNumber;

    @FXML
    private TextField tfSecondNumber;

    @FXML
    private TextField tfSolution;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void calculate() {
        int firstNumber = Integer.parseInt(tfFirstNumber.getText());
        int secondNumber = Integer.parseInt(tfSecondNumber.getText());
        int solution = firstNumber + secondNumber;

        tfSolution.setText(Integer.toString(solution));
    }

}
