package MVCCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CalculatorController {

    @FXML
    private TextField firstNumberField;

    @FXML
    private TextField secondNumberField;

    @FXML
    private Button addButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divideButton;

    @FXML
    private Label resultLabel;

    private CalculatorModel model;

    public void initialize() {
        model = new CalculatorModel();
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        calculate('+');
    }

    @FXML
    void handleSubtractButton(ActionEvent event) {
        calculate('-');
    }

    @FXML
    void handleMultiplyButton(ActionEvent event) {
        calculate('*');
    }

    @FXML
    void handleDivideButton(ActionEvent event) {
        calculate('/');
    }

    private void calculate(char operator) {
        try {
            int firstNumber = Integer.parseInt(firstNumberField.getText());
            int secondNumber = Integer.parseInt(secondNumberField.getText());
            int result = 0;
            switch (operator) {
                case '+':
                    result = model.add(firstNumber, secondNumber);
                    break;
                case '-':
                    result = model.subtract(firstNumber, secondNumber);
                    break;
                case '*':
                    result = model.multiply(firstNumber, secondNumber);
                    break;
                case '/':
                    double divisionResult = model.divide(firstNumber, secondNumber);
                    showAlert("Result", "Division Result: " + divisionResult);
                    return;
            }
            showAlert("Result", "Result: " + result);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid input");
        } catch (ArithmeticException e) {
            showAlert("Error", e.getMessage());
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}