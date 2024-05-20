package fx.makeorder;

import controller.OrderController;
import controller.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import model.tabledata.MOOrder;

import java.util.ArrayList;

public class MORequestController extends MOController<MOOrder> {
    @FXML
    private TableView<MOOrder> table;

    @FXML
    private TableColumn<MOOrder, Integer> id;

    @FXML
    private TableColumn<MOOrder, String> productName;

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
    private final ObservableList<MOOrder> moOrders = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        ArrayList<Order> orders = orderController.getOrdersInRequest(request.getId());

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
        makeAppearPreviewCard(table);

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
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        expired_date.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(moOrders);
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

}
