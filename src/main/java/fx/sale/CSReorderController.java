package fx.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.CSCancelSiteOrderList;
import model.tabledata.CSReorder;

import java.util.HashSet;
import java.util.Set;

public class CSReorderController {
    public TableView<CSReorder> productTable;
    public TableColumn<CSReorder, Integer> siteOrderIdColumn;
    public TableColumn<CSReorder, Integer> productIdColumn;
    public TableColumn<CSReorder, String> productNameColumn;
    public TableColumn<CSReorder, Integer> productQuantityColumn;
    public TableColumn<CSReorder, String> unitColumn;
    public TableColumn<CSReorder, String> statusColumn;
    public TableColumn<CSReorder, String> desiredDateColumn;
    public TableColumn<CSReorder, TextField> selectedQuantityColumn;
    public ComboBox<Integer> productIdComboBox;
    public TableColumn<CSReorder, CheckBox> productSelectedColumn;

    public Button updateButton;
    public Button cancelButton;
    public Button fastReorderButton;

    public TableView<CSReorder> sitesTable;
    public TableColumn<CSReorder, Integer> siteIdColumn;
    public TableColumn<CSReorder, String> siteNameColumn;
    public TableColumn<CSReorder, String> deliveryColumn;
    public TableColumn<CSReorder, String> expectedDateColumn;
    public TableColumn<CSReorder, Integer> quantityInStockColumn;
    public TableColumn<CSReorder, TextField> quantityColumn;
    public TableColumn<CSReorder, CheckBox> selectedColumn;
    public Button reorderButton;
    public TableColumn<CSReorder, Integer> siteProductIdColumn;

    public TextField sumProduct;

    @FXML
    private void initialize() {
        //System.out.println("Initializing CSReorderController");

        siteOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        desiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        selectedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("selectedQuantity"));
        productSelectedColumn.setCellValueFactory(new PropertyValueFactory<>("productSelected"));

        siteIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteId"));
        siteNameColumn.setCellValueFactory(new PropertyValueFactory<>("siteName"));
        siteProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteProductId"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        expectedDateColumn.setCellValueFactory(new PropertyValueFactory<>("expectedDate"));
        quantityInStockColumn.setCellValueFactory(new PropertyValueFactory<>("quantityInStock"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        selectedColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));

        loadProductIdComboBoxData();
        productIdComboBox.setOnAction(e -> {
            loadProductTableData();
            loadSiteTableData();
        });


        loadProductTableData();
        loadSiteTableData();
    }



    private void loadSiteTableData() {
        Integer selectedProductId = productIdComboBox.getValue();

        if (selectedProductId == null) {
            sitesTable.setItems(FXCollections.observableArrayList());
            return;
        }

        ObservableList<CSReorder> allSites = CSReorder.siteData();
        ObservableList<CSReorder> filteredSites = FXCollections.observableArrayList();
        Set<Integer> addedSiteIds = new HashSet<>();

        int cnt = 0;

        for (CSReorder site : allSites) {
            if (site.getSiteProductId() == selectedProductId && !addedSiteIds.contains(site.getSiteId())) {
                filteredSites.add(site);
                if(++cnt == 1) continue;
                else {
                    addedSiteIds.add(site.getSiteId());
                    cnt = 0;
                }
            }
        }

        sitesTable.setItems(filteredSites);
    }


    private void loadProductTableData() {
        Integer selectedProductId = productIdComboBox.getValue();

        if(selectedProductId == null) {
            productTable.setItems(FXCollections.observableArrayList());
            return;
        }

        ObservableList<CSReorder> allProducts = CSReorder.productData();
        ObservableList<CSReorder> filteredProducts = FXCollections.observableArrayList();

        for (CSReorder product : allProducts) {
            if (product.getProductId() == selectedProductId) {
                filteredProducts.add(product);
            }
        }

        productTable.setItems(filteredProducts);

    }

    private void loadProductIdComboBoxData() {
        ObservableList<CSReorder> items = CSReorder.productData();
        Set<Integer> uniqueProductIds = new HashSet<>();

        for (CSReorder item : items) {
            uniqueProductIds.add(item.getProductId());
        }

        productIdComboBox.getItems().setAll(uniqueProductIds);
    }

    public void update() {
        ObservableList<CSReorder> items = sitesTable.getItems();
        int sum = 0;
        for (CSReorder item : items) {
            String quantityText = item.getQuantity().getText();
            if (quantityText != null && !quantityText.isEmpty()) {
                try {
                    int newValue = Integer.parseInt(quantityText);
                    sum += newValue;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid quantity value: " + quantityText);
                }
            }
        }
        System.out.println("Sum = " + sum);
        sumProduct.setText(String.valueOf(sum));
    }


    public void cancel() {

    }

    public void fastReorder() {

    }

    public void reorder() {
        update();
        ObservableList<CSReorder> items = productTable.getItems();
        CSReorder tmp = null;
        int quantity = -1;

        for(CSReorder item : items) {
            if(item.getProductSelected().isSelected()) {
                quantity = item.getProductQuantity();
                tmp = item;
            }
        }

        if(quantity == -1) return;
        System.out.println("quantity = " + quantity);

        if(quantity != Integer.parseInt(sumProduct.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Thông báo");
            alert.setContentText("Vui lòng chọn đúng số lượng cần đặt lại");
            alert.showAndWait();
            return;
        }

        ObservableList<CSReorder> sites = sitesTable.getItems();
        for (CSReorder site : sites) {
            String quantityText = site.getQuantity().getText();
            if (quantityText != null && !quantityText.isEmpty()) {
                try {
                    int qtt = Integer.parseInt(quantityText);
                    if(qtt > site.getQuantityInStock()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Không đủ số lượng");
                        alert.setContentText("Vui lòng nhập số lượng nhỏ hơn hoặc bằng số lượng đang có trong kho");
                        alert.showAndWait();
                        return;
                    }
                    CSReorder.reorder(CSReorder.getOrderId(tmp.getSiteOrderId()), site.getSiteId(), quantity, site.getDelivery());
                    CSCancelSiteOrderList.updateStatus(tmp.getSiteOrderId(), "Đã đặt lại");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Thông báo");
                    alert.setContentText("Đặt lại thành công");
                    alert.showAndWait();
                    loadProductTableData();
                    loadProductIdComboBoxData();
                } catch (NumberFormatException e) {
                    System.err.println("Invalid quantity value: " + quantityText);
                }
            }
        }

        //CSReorder.reorder(orderId, siteId, quantity, delivery);


    }




}