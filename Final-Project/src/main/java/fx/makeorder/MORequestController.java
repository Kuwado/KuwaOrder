package fx.makeorder;

import controller.OrderController;
import controller.ProductController;
import controller.SiteProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;
import model.tabledata.ChosenQuantity;
import model.tabledata.MOOrder;
import solution.DateConverter;
import solution.Transition;

import java.io.IOException;
import java.util.ArrayList;

public class MORequestController extends MOController<MOOrder> {
    @FXML
    private TableView<MOOrder> table;

    @FXML
    private TableColumn<MOOrder, Integer> id;

    @FXML
    private TableColumn<MOOrder, Integer> quantity;

    @FXML
    private TableColumn<MOOrder, String> unit;

    @FXML
    private TableColumn<MOOrder, String> expired_date;

    @FXML
    private TableColumn<MOOrder, String> status;

    @FXML
    private TableColumn<MOOrder, String> action;

    @FXML
    private Label requestName;

    @FXML
    private Label orderName;

    @FXML
    private TextArea orderNote;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Button quickMakeOrderBtn;

    @FXML
    void viewAll(ActionEvent event) {
        viewAllTable(table, moOrders);
    }

    private static Request request;
    private final OrderController orderController = new OrderController();
    private final ProductController productController = new ProductController();
    private final SiteProductController siteProductController = new SiteProductController();
    private final ObservableList<MOOrder> moOrders = FXCollections.observableArrayList();
    private Order order;
    private int date;

    @FXML
    void initialize() {
        ArrayList<Order> orders = orderController.getWaitOrdersInRequest(request.getId());

        for (int i = 0; i < orders.size(); i++) {
            Button button = makeButton(table, i, "/view/content/makeorder/MOOrder.fxml");
            moOrders.add(new MOOrder(orders.get(i), button));
        }

        // Set breadcrumbs
        setBreadcrumb(3, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Table
        number = 9;
        startTable(table, moOrders);

        // Preview card
        requestName.setText(request.getName());
        previewCard.setTranslateY(800);
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                if (!previewStt) {
                    Transition.transitionXY(previewCard, 0, 0, 0.7);
                    previewStt = true;
                }
                MOOrder item = table.getSelectionModel().getSelectedItem();
                if (item != null) {
                    insertToPreviewCard(item);
                    order = orderController.getOrderById(item.getOrder().getId());
                    date = DateConverter.roundedDaysDifferenceFromToday(order.getDesiredDate());
                    ArrayList<ChosenQuantity> siteProducts = siteProductController.getSiteToMakeOrder(order.getProductId(), date);
                    if (siteProducts.isEmpty()) {
                        quickMakeOrderBtn.setDisable(true);
                    }
                }
            }
        });

        // Reset stt
        MOOrder.setIdCounter(1);
    }

    @Override
    public void setDataToTrans(MOOrder moOrder) {
        MOOrderController.setOrder(orderController.getOrderById(moOrder.getOrder().getId()));
    }

    public static void setRequest(Request request) {
        MORequestController.request = request;
    }

    @Override
    public void insertToTable(ObservableList<MOOrder> mos) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        expired_date.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(mos);
    }

    @Override
    public void insertToPreviewCard(MOOrder moOrder) {
        Order order = moOrder.getOrder();
        orderNote.setText(order.getNote() != null ? order.getNote() : "Không có");
        orderName.setText(productController.getProductById(order.getProductId()).getName());
        orderQuantity.setText(String.valueOf(order.getQuantity()));
        orderUnit.setText(order.getUnit());
        orderExpiredDate.setText(order.getDesiredDate());
    }

    @FXML
    void makeQuicklyOrder(ActionEvent event) throws IOException {
        ArrayList<ChosenQuantity> chosenQuantities = new ArrayList<>();
        MOExpectedSiteOrderController.setDate(date);
        MOExpectedSiteOrderController.setOrder(order);
        MOExpectedSiteOrderController.setChosenSites(chosenQuantities);
        // Gửi stage đến success
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MOSuccessController.setStageOrder(stage);
        MOOrderController.runPopUp("/view/popUp/MOExpectedSiteOrder.fxml", 700, 700);

    }

}
