package fx.order;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Order;
import model.tabledata.VOSiteOrder;

public class SiteOrderDetailController {

    @FXML
    private TextArea note;

    @FXML
    private Label unit;

    @FXML
    private Label quantity;

    @FXML
    private Label deliveryType;

    @FXML
    private Label siteName;

    @FXML
    private Label deliveryPrice;

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Label status;




    private Stage dialogStage;
    private VOSiteOrder siteOrder;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOrder(VOSiteOrder SiteOrder) {
        this.siteOrder = SiteOrder;

        siteName.setText(siteOrder.getSiteName());
        productName.setText(siteOrder.getProductName());
        quantity.setText(String.valueOf(siteOrder.getQuantity()));
        unit.setText(siteOrder.getUnit());
        productPrice.setText(String.valueOf(siteOrder.getProductPrice()));
        deliveryType.setText(siteOrder.getDeliveryType());
        deliveryPrice.setText(String.valueOf(siteOrder.getDeliveryPrice()));
        status.setText(siteOrder.getStatus());
        note.setText(siteOrder.getNote());
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }
}