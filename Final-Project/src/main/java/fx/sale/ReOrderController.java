package fx.sale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.Reorder;

public class ReOrderController {
    public TableView<Reorder> productTable;
    public TableColumn<Reorder, Integer> productIdColumn;
    public TableColumn<Reorder, String> productNameColumn;
    public TableColumn<Reorder, Integer> productQuantityColumn;
    public TableColumn<Reorder, String> unitColumn;
    public TableColumn<Reorder, String> statusColumn;
    public TableColumn<Reorder, String> desiredDateColumn;
    public TableColumn<Reorder, TextField> selectedQuantityColumn;


    public Button cancelButton;
    public Button fastReorderButton;


    public TableView<Reorder> sitesTable;
    public TableColumn<Reorder, Integer> siteIdColumn;
    public TableColumn<Reorder, String> siteNameColumn;
    public TableColumn<Reorder, String> deliveryColumn;
    public TableColumn<Reorder, String> expectedDateColumn;
    public TableColumn<Reorder, Integer> quantityInStockColumn;
    public TableColumn<Reorder, Integer> quantityColumn;
    public TableColumn<Reorder, CheckBox> selectedColumn;
    public Button reorderButton;

    @FXML
    private void initialize() {
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        desiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        selectedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("selectedQuantity"));
        loadProductTableData();
    }

    private void loadProductTableData() {
        productTable.setItems(Reorder.productData());
    }

    public void cancel() {

    }

    public void fastReorder() {

    }

    public void reorder() {

    }

}
