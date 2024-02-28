package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CalculatorController {
    
    @FXML
    private TextField firstNumberField;
    
    @FXML
    private TextField secondNumberField;
    
    @FXML
    private TextField resultField;
    
    @FXML
    private void handleCalculate(ActionEvent event) {
        int firstNumber, secondNumber = 0;
        
        try {
            firstNumber = Integer.parseInt(firstNumberField.getText());
            secondNumber = Integer.parseInt(secondNumberField.getText());
            
            resultField.setText(Integer.toString(firstNumber + secondNumber));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            showErrorAlert("You Need to Enter 2 Integers");
        }
    }
    
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
