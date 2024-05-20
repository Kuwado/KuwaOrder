package fx.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;


public class HandleCancelSiteOrderController {

    public TableView<ThucTestData> cancelSiteOrderIdTable;
    public TableColumn<ThucTestData, Integer> siteOrderIdColumn;
    public TableColumn<ThucTestData, String> siteNameColumn;
    public TableColumn<ThucTestData, String> productNameColumn;
    public TableColumn<ThucTestData, Integer> quantityColumn;
    public TableColumn<ThucTestData, String> unitColumn;
    public TableColumn<ThucTestData, String> deliveryColumn;
    public TableColumn<ThucTestData, Date> desiredDateColumn;
    public TableColumn<ThucTestData, CheckBox> selectedColumn;
    public Button reorderButton;
    public Button cancelButton;

    @FXML
    private void initialize() {
        siteOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        siteNameColumn.setCellValueFactory(new PropertyValueFactory<>("siteName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        desiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        selectedColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        loadTableData();
    }

    private void loadTableData() {
        ObservableList<ThucTestData> data = FXCollections.observableArrayList(
                new ThucTestData(1, "Nhà sách Nhã Nam", "Đại dương đen", 10, "Cuốn", "Tàu", Date.valueOf("2025-12-25"), new CheckBox())
        );
        cancelSiteOrderIdTable.setItems(data);
    }

}
