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
    private TableView<TestData> detailTable;
    @FXML
    private Button cancelButton;
    @FXML
    private TableColumn<TestData, String> productNameColumn;
    @FXML
    private TableColumn<TestData, String> unitColumn;
    @FXML
    private TableColumn<TestData, Integer> quantityColumn;

    @FXML
    private void initialize() {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        loadDetailData();
    }

    private void loadDetailData() {
        ObservableList<TestData> details = FXCollections.observableArrayList(
                new TestData("Thùy Dung", "Điểm", 10),
                new TestData("Lê Nhung", "Điểm", 10),
                new TestData("Cao Phong", "Điểm", 10)
        );
        detailTable.setItems(details);
    }

    @FXML
    private void cancelSiteOrder(ActionEvent actionEvent) {
        System.out.println("Cancel this site order");
    }
}
