package FXCalculator;

import SwingCaculator.SwingCalculatorModel;
import SwingCaculator.SwingCalculatorView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXCalculatorController {

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonX;

    @FXML
    private Button buttondiv;

    @FXML
    private Button buttonequal;

    @FXML
    private Button buttonsub;

    @FXML
    private Button buttonsum;

    @FXML
    private TextField text;
    
    @FXML
    private TextField OPtext;
    
    private FXCalculatorModel model;
    private String currentOperator = ""; // toán tử
    private double firstOperand = 0.0; // Phần tử đầu
    

    public FXCalculatorController(FXCalculatorModel model) {
		super();
		this.model = model;
	}
    
    @FXML
    void initialize() {
        text.setEditable(false); // Tắt quyền chỉnh sửa của TextField
        OPtext.setEditable(false); // Tắt quyền chỉnh sửa của TextField
    }

	@FXML
    void button0Click(ActionEvent event) {
    	text.appendText("0");
    }

    @FXML
    void button1Click(ActionEvent event) {
    	text.appendText("1");
    }

    @FXML
    void button2Click(ActionEvent event) {
    	text.appendText("2");
    }

    @FXML
    void button3Click(ActionEvent event) {
    	text.appendText("3");
    }

    @FXML
    void button4Click(ActionEvent event) {
    	text.appendText("4");
    }

    @FXML
    void button5Click(ActionEvent event) {
    	text.appendText("5");
    }

    @FXML
    void button6Click(ActionEvent event) {
    	text.appendText("6");
    }

    @FXML
    void button7Click(ActionEvent event) {
    	text.appendText("7");
    }

    @FXML
    void button8Click(ActionEvent event) {
    	text.appendText("8");
    }

    @FXML
    void button9Click(ActionEvent event) {
    	text.appendText("9");
    }

    @FXML
    void buttonCClick(ActionEvent event) {
    	text.clear();
        currentOperator = "";
        firstOperand = 0.0;
    }

    @FXML
    void buttonXClick(ActionEvent event) {
    	if(!OPtext.getText().isEmpty()) {
    		OPtext.clear();
        	OPtext.appendText("*");
    	}
    	else {
    		OPtext.clear();
        	OPtext.appendText("*");
            firstOperand = Double.parseDouble(text.getText());
            text.clear();
    	}
    }

    @FXML
    void buttondivClick(ActionEvent event) {
    	if(!OPtext.getText().isEmpty()) {
    		OPtext.clear();
        	OPtext.appendText("/");
    	}
    	else {
    		OPtext.clear();
        	OPtext.appendText("/");
            firstOperand = Double.parseDouble(text.getText());
            text.clear();
    	}
    }

    @FXML
    void buttonequalClick(ActionEvent event) {
    	double secondOperand = Double.parseDouble(text.getText());
    	currentOperator = OPtext.getText();
    	model.calculate(firstOperand, secondOperand, currentOperator);
    	text.clear();
    	text.setText(Double.toString(model.getAns()));
    	OPtext.clear();
    	currentOperator = "";
        firstOperand = 0.0;
    }

    @FXML
    void buttonsubClick(ActionEvent event) {
    	if(!OPtext.getText().isEmpty()) {
    		OPtext.clear();
        	OPtext.appendText("-");
    	}
    	else {
    		OPtext.clear();
        	OPtext.appendText("-");
            firstOperand = Double.parseDouble(text.getText());
            text.clear();
    	}
    }

    @FXML
    void buttonsumClick(ActionEvent event) {
    	if(!OPtext.getText().isEmpty()) {
    		OPtext.clear();
        	OPtext.appendText("+");
    	}
    	else {
    		OPtext.clear();
        	OPtext.appendText("+");
            firstOperand = Double.parseDouble(text.getText());
            text.clear();
    	}
    }

}
