package fx.makeorder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.tabledata.ConfirmSite;

public class MOExpectedSiteOrderController {

    @FXML
    private Button cancelBtn;

    @FXML
    private TableView<?> chosenSiteTable;

    @FXML
    private TableColumn<?, ?> delivery;

    @FXML
    private Button makeOrderBtn;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Label orderId;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Label productName;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private Label requestId;

    @FXML
    private TableColumn<?, ?> siteName;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TableColumn<?, ?> takeDate;

}
