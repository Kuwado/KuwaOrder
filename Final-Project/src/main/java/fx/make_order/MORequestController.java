package fx.make_order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MORequestController {

    @FXML
    private TableColumn<?, ?> action;

    @FXML
    private HBox breadcrumb;

    @FXML
    private TableColumn<?, ?> expired_date;

    @FXML
    private Pane hidePagination;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Label orderName;

    @FXML
    private TextArea orderNote;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Pagination pagination;

    @FXML
    private AnchorPane previewCard;

    @FXML
    private VBox previewContent;

    @FXML
    private TableColumn<?, ?> productName;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private Button quickMakeOrder;

    @FXML
    private Label requestName;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> unit;

    @FXML
    private Button viewAll;

    @FXML
    void viewAll(ActionEvent event) {

    }

}
