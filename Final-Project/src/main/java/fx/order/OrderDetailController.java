package fx.order;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Order;

public class OrderDetailController {

    @FXML
    private Label orderId;

    @FXML
    private Label productName;

    @FXML
    private Label quantity;

    @FXML
    private Label unit;

    @FXML
    private Label desiredDate;

    @FXML
    private Label status;

    @FXML
    private TextArea note;

    private Stage dialogStage;
    private Order order;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOrder(Order order) {
        this.order = order;

        orderId.setText(String.valueOf(order.getId()));
        productName.setText(order.getProductName());
        quantity.setText(String.valueOf(order.getQuantity()));
        unit.setText(order.getUnit());
        desiredDate.setText(order.getDesiredDate());
        status.setText(order.getStatus());
        note.setText(order.getNote());
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }
}
