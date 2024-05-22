package fx.order;

import controller.OrderController;
import controller.SiteOrderController;
import controller.SiteProductController;
import fx.breadcrumb.VOBreadcrumbController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.SiteOrder;
import model.SiteProduct;
import model.tabledata.VOSiteOrder;

import java.io.IOException;
import java.util.ArrayList;

public class VOsiteOrderListController {

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
    private Button confirmOrderButton;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private Button deliverOrderButton;

    public void setTable(TableView<VOSiteOrder> table){
        this.table = table;
    }

    private final ObservableList<VOSiteOrder> voSiteOrders = FXCollections.observableArrayList();
    private final SiteOrderController siteOrderController = new SiteOrderController();

    private final SiteProductController siteProductController = new SiteProductController();
    private final OrderController orderController = new OrderController();

    @FXML
    void initialize() {
        VOBreadcrumbController.number = 1;
        VOBreadcrumbController ob = new VOBreadcrumbController();
        ob.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/order.fxml");
        ArrayList<SiteOrder> siteOrders = siteOrderController.getAllSiteOrdersBySiteID(1);
        ArrayList<SiteProduct> siteProducts = new ArrayList<>();
        for (SiteOrder siteOrder : siteOrders) {
            siteProducts = siteProductController.getSiteproductsByProduct(orderController.getOrderById(siteOrder.getOrderId()).getProductId());
        }
        for (int i = 0; i < siteOrders.size(); i++){
            voSiteOrders.add(new VOSiteOrder(siteOrders.get(i),siteProducts.get(i)));
        }
        insertToTable();
        table.setItems(voSiteOrders);
        table.setOnMouseClicked(event -> {
            if (table.getSelectionModel().getSelectedItem() != null) {
                VOSiteOrder selectedSiteOrder = table.getSelectionModel().getSelectedItem();

                if (event.getClickCount() == 2) {
                    showOrderDetails(selectedSiteOrder);
                } else {
                    handleOrderSelection(selectedSiteOrder);

                }
            }
        });
        VOSiteOrder.setiDCounter(1);
    }
    private void showOrderDetails(VOSiteOrder SiteOrder) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/content/order/VOsiteOrderDetail.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chi tiết đơn hàng");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(table.getScene().getWindow());
            stage.setScene(new Scene(loader.load()));

            VOSiteOrderDetailController controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setOrder(SiteOrder);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOrderSelection(VOSiteOrder selectedSiteOrder) {
        String status = selectedSiteOrder.getStatus();
        switch (status) {
            case "Chờ xác nhận":
                confirmOrderButton.setVisible(true);
                cancelOrderButton.setVisible(true);
                deliverOrderButton.setVisible(false);
                break;
            case "Chờ lấy hàng":
                confirmOrderButton.setVisible(false);
                cancelOrderButton.setVisible(false);
                deliverOrderButton.setVisible(true);
                break;
            default:
                confirmOrderButton.setVisible(false);
                cancelOrderButton.setVisible(false);
                deliverOrderButton.setVisible(false);
                break;
        }
    }

    @FXML
    private void handleConfirmOrder() {
        VOSiteOrder selectedOrder = table.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            selectedOrder.setStatus("Chờ lấy hàng");
            siteOrderController.updateStatus(selectedOrder.getId(), "Chờ lấy hàng");
            table.refresh();
        }
    }

    @FXML
    private void handleCancelOrder() {
        VOSiteOrder selectedOrder = table.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            selectedOrder.setStatus("Đã hủy");
            siteOrderController.updateStatus(selectedOrder.getId(), "Đã hủy");
            table.refresh();
        }
    }

    @FXML
    private void handleDeliverOrder() {
        VOSiteOrder selectedOrder = table.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            int deliverQuantity = selectedOrder.getQuantity();
            int siteProductId = selectedOrder.getSiteProductID();
            System.out.println(siteProductId);
            siteProductController.updateQuantityAndSoldQuantity(siteProductId, deliverQuantity);
            selectedOrder.setStatus("Đang giao");
            siteOrderController.updateStatus(selectedOrder.getId(), "Đang giao");
            table.refresh();
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
