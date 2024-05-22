package fx.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.Reorder;

public class ReOrderController {
    public TableView<Reorder> productTable;
    public TableColumn<Reorder, Integer> siteOrderIdColumn;
    public TableColumn<Reorder, Integer> productIdColumn;
    public TableColumn<Reorder, String> productNameColumn;
    public TableColumn<Reorder, Integer> productQuantityColumn;
    public TableColumn<Reorder, String> unitColumn;
    public TableColumn<Reorder, String> statusColumn;
    public TableColumn<Reorder, String> desiredDateColumn;
    public TableColumn<Reorder, TextField> selectedQuantityColumn;
    public ComboBox<Integer> productIdComboBox;
    public TableColumn<Reorder, CheckBox> productSelectedColumn;

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
        siteOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        desiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        selectedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("selectedQuantity"));
        productSelectedColumn.setCellValueFactory(new PropertyValueFactory<>("productSelected"));


        loadProductIdComboBoxData();
        productIdComboBox.setOnAction(e -> loadProductTableData());
        loadProductTableData();
    }

    private void loadProductTableData() {
        Integer selectedProductId = productIdComboBox.getValue();

        if(selectedProductId == null) {
            productTable.setItems(FXCollections.observableArrayList());
            return;
        }

        ObservableList<Reorder> allProducts = Reorder.productData();
        ObservableList<Reorder> filteredProducts = FXCollections.observableArrayList();

        for (Reorder product : allProducts) {
            if (product.getProductId() == selectedProductId) {
                filteredProducts.add(product);
            }
        }

        productTable.setItems(filteredProducts);

    }

    private void loadProductIdComboBoxData() {
        ObservableList<Reorder> items = Reorder.productData();
        for(Reorder item : items) {
            productIdComboBox.getItems().add(item.getProductId());
        }
    }


    public void cancel() {

    }

    public void fastReorder() {

    }

    public void reorder() {

    }

}
