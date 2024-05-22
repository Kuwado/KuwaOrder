package fx.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.CSReorder;

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


        System.out.println(CSReorder.siteData());




        loadSiteTableData();

    }

    private class ReorderSiteList {
        private int siteId;
        private String siteName;
        private int productId;
        private String delivery;
        private String expectedDate;
        private int quantityInStock;
        private TextField quantity;
        private CheckBox selected;

        public ReorderSiteList(int siteId, String siteName, String delivery, String expectedDate, int quantityInStock, TextField quantity, CheckBox selected) {
            this.siteId = siteId;
            this.siteName = siteName;
            this.delivery = delivery;
            this.expectedDate = expectedDate;
            this.quantityInStock = quantityInStock;
            this.quantity = quantity;
            this.selected = selected;
        }

        public ReorderSiteList(int siteId, String siteName, int productId, String delivery, String expectedDate, int quantityInStock, TextField quantity, CheckBox selected) {
            this.siteId = siteId;
            this.siteName = siteName;
            this.productId = productId;
            this.delivery = delivery;
            this.expectedDate = expectedDate;
            this.quantityInStock = quantityInStock;
            this.quantity = quantity;
            this.selected = selected;
        }

        public int getSiteId() {
            return siteId;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getDelivery() {
            return delivery;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }

        public String getExpectedDate() {
            return expectedDate;
        }

        public void setExpectedDate(String expectedDate) {
            this.expectedDate = expectedDate;
        }

        public int getQuantityInStock() {
            return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        public TextField getQuantity() {
            return quantity;
        }

        public void setQuantity(TextField quantity) {
            this.quantity = quantity;
        }

        public CheckBox getSelected() {
            return selected;
        }

        public void setSelected(CheckBox selected) {
            this.selected = selected;
        }
    }

    private void loadSiteTableData() {
        Integer selectedProductId = productIdComboBox.getValue();

        if(selectedProductId == null) {
            sitesTable.setItems(FXCollections.observableArrayList());
            return;
        }

        ObservableList<CSReorder> allSites = CSReorder.siteData();
        ObservableList<CSReorder> filteredSites = FXCollections.observableArrayList();

        for(CSReorder site : allSites) {
            if(site.getProductId() == selectedProductId) {
                filteredSites.add(site);
            }
        }

        ObservableList<ReorderSiteList> list = FXCollections.observableArrayList();

        for(CSReorder site : filteredSites) {

            int siteId = site.getSiteId();
            String siteName = site.getSiteName();
            int quantityInStock = site.getQuantityInStock();
            TextField quantity = new TextField();
            CheckBox selected = new CheckBox();
            String delivery = "Tàu";
            String expectedDate =  java.time.LocalDate.now().toString();
            list.add(new ReorderSiteList(siteId, siteName, delivery, expectedDate, quantityInStock, quantity, selected));

        }

        //sitesTable.setItems(list);

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
        for(CSReorder item : items) {
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
