package fx.make_order;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MOConfirmSiteController {

    @FXML
    private Button backBtn;

    @FXML
    private TableView<?> chosenSiteTable;

    @FXML
    private Button confirmBtn;

    @FXML
    private TableColumn<?, ?> delivery;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableColumn<?, ?> siteName;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TableColumn<?, ?> takeDate;

}
