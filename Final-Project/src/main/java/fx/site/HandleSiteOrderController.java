package fx.site;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HandleSiteOrderController {

    @FXML
    public TableColumn commonIdColumn;
    @FXML
    public TableColumn commonOrderIdColumn;
    @FXML
    public TableColumn commonProductNameColumn;
    @FXML
    public TableColumn commonUnitColumn;
    @FXML
    public TableColumn commonQuantityColumn;
    @FXML
    public TableColumn commonDeliveryColumn;
    @FXML
    public TableColumn commonStatusColumn;
    @FXML
    private TableView<TestData> detailTable;
    @FXML
    private TableView<TestData> commonTable;
    @FXML
    private Button cancelButton;
    @FXML
    private TableColumn<TestData, String> detailProductNameColumn;
    @FXML
    private TableColumn<TestData, String> detailUnitColumn;
    @FXML
    private TableColumn<TestData, Integer> detailQuantityColumn;

    @FXML
    private void initialize() {
        detailProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        detailUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        detailQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        commonIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        commonOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        commonProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        commonUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        commonDeliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        commonStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadDetailData();
        loadCommonData();
    }

    private void loadDetailData() {
        ObservableList<TestData> details = FXCollections.observableArrayList(
                new TestData("Thùy Dung", "Điểm", 10),
                new TestData("Lê Nhung", "Điểm", 10),
                new TestData("Cao Phong", "Điểm", 10)
        );
        detailTable.setItems(details);
    }

    private void loadCommonData() {
        ObservableList<TestData> commons = FXCollections.observableArrayList(
                new TestData(1, 1, "Thùy Dung", "Chị", 1, "Tay", "Chưa có ny"),
                new TestData(2, 2, "Lê Nhung", "Chị", 1, "Tay", "Đoán xem"),
                new TestData(3, 3, "Cao Phong", "Chị", 1, "None", "Ai quan tâm")
        );
        commonTable.setItems(commons);
    }

    @FXML
    private void cancelSiteOrder(ActionEvent actionEvent) {
        System.out.println("Cancel this site order");
    }
}
