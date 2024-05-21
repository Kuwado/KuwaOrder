package fx.makeorder;

import controller.OrderController;
import controller.ProductController;
import controller.SiteOrderController;
import controller.SiteProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Order;
import model.SiteOrder;
import model.tabledata.MOChosenQuantity;
import model.tabledata.MOConfirmSite;
import model.tabledata.MOExpectedSiteOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class MOExpectedSiteOrderController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button makeOrderBtn;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Label orderId;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Label productName;

    @FXML
    private Label requestId;

    @FXML
    private Label boughtQuantity;

    @FXML
    private TableView<MOExpectedSiteOrder> table;

    @FXML
    private TableColumn<MOExpectedSiteOrder, String> delivery;

    @FXML
    private TableColumn<MOExpectedSiteOrder, Integer> quantity;

    @FXML
    private TableColumn<MOExpectedSiteOrder, String> siteName;

    @FXML
    private TableColumn<MOExpectedSiteOrder, Integer> stt;

    @FXML
    private TableColumn<MOExpectedSiteOrder, String> price;

    @FXML
    private TableColumn<MOExpectedSiteOrder, String> takeDate;

    private final SiteProductController siteProductController = new SiteProductController();
    private final SiteOrderController siteOrderController = new SiteOrderController();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();

    private ObservableList<MOExpectedSiteOrder> expectedSiteOrders = FXCollections.observableArrayList();
    private ArrayList<MOChosenQuantity> chosingSites;
    private ArrayList<SiteOrder> siteOrders;
    private int chosenNumber;
    private String status;

    private static ArrayList<MOChosenQuantity> chosenSites;
    private static int date;
    private static Order order;

    @FXML
    void initialize() {
        chosingSites = siteProductController.getSiteToMakeOrder(order.getProductId(), date);
        if (!chosenSites.isEmpty()) {
            for (MOChosenQuantity chosenQuantity : chosenSites) {
                Optional<MOChosenQuantity> existingCq = chosingSites.stream()
                        .filter(cq -> cq.getSiteId() == chosenQuantity.getSiteId())
                        .findFirst();
                if (existingCq.isPresent()) {
                    existingCq.get().setChosenQuantity(chosenQuantity.getChosenQuantity());
                      if (chosenQuantity.getDeliveryType() != null) {
                          existingCq.get().setDeliveryPrice(chosenQuantity.getDeliveryPrice());
                          existingCq.get().setDeliveryType(chosenQuantity.getDeliveryType());
                    }
                    existingCq.get().setStt(true);
                }
            }
        }

        // Tạo siteorder thử nghiệm
        siteOrders = siteOrderController.getExpectedSiteOrders(chosingSites, order);

        // Chèn vào kiểu dữ liệu cho bảng
        for (SiteOrder siteOrder: siteOrders) {
            expectedSiteOrders.add(new MOExpectedSiteOrder(siteOrder, date));
            chosenNumber += siteOrder.getQuantity();
        }

        // Chèn vào table
        insertToTable();

        // Thêm các thông tin phụ
        requestId.setText(String.valueOf(order.getRequestId()));
        orderId.setText(String.valueOf(order.getId()));
        productName.setText(String.valueOf(productController.getProductById(order.getProductId()).getName()));
        orderQuantity.setText(String.valueOf(order.getQuantity()));
        orderUnit.setText(String.valueOf(order.getUnit()));
        orderExpiredDate.setText(String.valueOf(order.getDesiredDate()));
        boughtQuantity.setText(String.valueOf((chosenNumber)));

        // Reset stt
        MOConfirmSite.setIdCounter(1);

        // Nếu thiếu hàng
        if (chosenNumber < order.getQuantity()) {
            quantityError();
            status = "Tạo đơn thiếu";
        } else {
            status = "Đã tạo đơn";
        }
    }

    private void quantityError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Số lượng quá lớn");
        alert.setHeaderText(null);
        alert.setContentText("Tổng số lượng hàng còn lại của các site không đủ " + chosenNumber + "/" + order.getQuantity());
        alert.showAndWait();
    }

    public static void setChosenSites(ArrayList<MOChosenQuantity> chosenSites) {
        MOExpectedSiteOrderController.chosenSites = chosenSites;
    }

    public static void setDate(int date) {
        MOExpectedSiteOrderController.date = date;
    }

    public static void setOrder(Order order) {
        MOExpectedSiteOrderController.order = order;
    }

    public void insertToTable() {
        stt.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, Integer>("id"));
        siteName.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, String>("name"));
        delivery.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, String>("deliveryType")); // Đặt lại tên thuộc tính
        quantity.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, Integer>("quantity")); // Đặt lại tên thuộc tính
        takeDate.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, String>("expectedDate"));
        price.setCellValueFactory(new PropertyValueFactory<MOExpectedSiteOrder, String>("price"));
        table.setItems(expectedSiteOrders);
    }

    @FXML
    void cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
        // insert to database
        for (SiteOrder siteOrder: siteOrders) {
            siteOrderController.insert(siteOrder);
        }
        orderController.updateStatus(order.getId(), status);

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        MOOrderController.runPopUp("/view/popUp/MOSuccess.fxml", 500, 216);
    }

}
