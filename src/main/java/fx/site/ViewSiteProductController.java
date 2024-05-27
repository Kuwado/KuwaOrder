package fx.site;

import controller.ProductController;
import controller.SiteProductController;
import fx.breadcrumb.VOBreadcrumbController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.SiteOrder;
import model.SiteProduct;
import model.tabledata.VOSiteOrder;

import java.util.ArrayList;

public class ViewSiteProductController {

    @FXML
    private TableColumn<SiteProduct, Integer> quantity;

    @FXML
    private HBox breadcrumb;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<SiteProduct, Integer> productID;

    @FXML
    private TableColumn<SiteProduct, Integer> id;

    @FXML
    private TableView<SiteProduct> table;

    @FXML
    private TableColumn<SiteProduct, String> productName;

    @FXML
    private TableColumn<SiteProduct, String> productPrice;

    @FXML
    private TableColumn<SiteProduct, Integer> soldQuantity;
    private final ObservableList<SiteProduct> siteProducts1 = FXCollections.observableArrayList();

    private final SiteProductController siteProductController = new SiteProductController();
    @FXML
    void initialize() {
        VOBreadcrumbController.number = 1;
        VOBreadcrumbController ob = new VOBreadcrumbController();
        ob.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/productSite.fxml");
        ArrayList<SiteProduct> siteProducts = siteProductController.getSiteproductsBySite(1);
        for (SiteProduct siteProduct : siteProducts){
            siteProducts1.add(new SiteProduct(siteProduct));
        }
        insertToTable();
        table.setItems(siteProducts1);

        FilteredList<SiteProduct> filteredData = new FilteredList<>(siteProducts1, p -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(siteProduct -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (siteProduct.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(siteProduct.getProductId()).contains(newValue)) {
                    return true;
                }
                return false;
            });
        });

        table.setItems(filteredData);
    }
    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        productID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        soldQuantity.setCellValueFactory(new PropertyValueFactory<>("soldQuantity"));
    }
}
