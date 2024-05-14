package fx.order;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Order;

public class OrderDetailController {

    @FXML
    private TextField idField;

    @FXML
    private TextField product_idField;

    @FXML
    private TextField product_nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField unitField;

    @FXML
    private TextField desired_dateField;

    @FXML
    private TextField statusField;

    private Stage dialogStage;
    private Order order;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOrder(Order order) {
        this.order = order;
        idField.setText(String.valueOf(order.getId()));
        product_idField.setText(String.valueOf(order.getProduct_id()));
        product_nameField.setText(order.getProduct_name());
        quantityField.setText(String.valueOf(order.getQuantity()));
        unitField.setText(order.getUnit());
        desired_dateField.setText(order.getDesired_date());
        statusField.setText(order.getStatus());
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }
}
