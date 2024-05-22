package fx.order;

import controller.OrderController;
import controller.SiteOrderController;
import controller.SiteProductController;
import fx.breadcrumb.VOBreadcrumbController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import model.tabledata.VOSiteOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VOorderListController {

    @FXML
    private TableColumn<VOSiteOrder, String> unit;

    @FXML
    private TableColumn<VOSiteOrder, Integer> quantity;

    @FXML
    private Pagination pagination;

    @FXML
    private HBox breadcrumb;

    @FXML
    private TableColumn<VOSiteOrder, String> deliveryType;

    @FXML
    private TableColumn<VOSiteOrder, String> siteName;

    @FXML
    private TableColumn<VOSiteOrder, Integer> id;

    @FXML
    private TableColumn<VOSiteOrder, Double> deliveryPrice;

    @FXML
    private TableView<VOSiteOrder> table;

    @FXML
    private TableColumn<VOSiteOrder, String> productName;

    @FXML
    private TableColumn<VOSiteOrder, Double> productPrice;

    @FXML
    private TableColumn<VOSiteOrder, String> status;

    @FXML
    private TextField searchField;

    private final ObservableList<VOSiteOrder> voSiteOrders = FXCollections.observableArrayList();
    private final SiteOrderController siteOrderController = new SiteOrderController();

    @FXML
    void initialize() {
        VOBreadcrumbController.number = 1;
        VOBreadcrumbController ob = new VOBreadcrumbController();
        ob.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/order.fxml");
        ArrayList<SiteOrder> siteOrders = siteOrderController.getAllSiteOrders();
        for (SiteOrder siteOrder : siteOrders){
            voSiteOrders.add(new VOSiteOrder(siteOrder));
        }
        insertToTable();
        table.setItems(voSiteOrders);
        FilteredList<VOSiteOrder> filteredData = new FilteredList<>(voSiteOrders, p -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(voSiteOrder -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (voSiteOrder.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (voSiteOrder.getSiteName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        table.setItems(filteredData);
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && table.getSelectionModel().getSelectedItem() != null) {
                VOSiteOrder selectedSiteOrder = table.getSelectionModel().getSelectedItem();
                showOrderDetails(selectedSiteOrder);
            }
        });
        VOSiteOrder.setiDCounter(1);
    }

    private void showOrderDetails(VOSiteOrder SiteOrder) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/content/order/VOorderDetail.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chi tiết đơn hàng");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(table.getScene().getWindow());
            stage.setScene(new Scene(loader.load()));

            VOOrderDetailController controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setOrder(SiteOrder);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        deliveryPrice.setCellValueFactory(new PropertyValueFactory<>("deliveryPrice"));
        deliveryType.setCellValueFactory(new PropertyValueFactory<>("deliveryType"));
        siteName.setCellValueFactory(new PropertyValueFactory<>("siteName"));


    }
}

