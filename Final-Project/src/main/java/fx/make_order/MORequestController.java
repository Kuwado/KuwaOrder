package fx.make_order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.Order;
import model.Request;

public class MORequestController extends MOController<Order> {

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private TableColumn<Order, String> productName;

    @FXML
    private TableColumn<Order, Integer> quantity;

    @FXML
    private TableColumn<Order, String> unit;

    @FXML
    private TableColumn<Order, String> expired_date;

    @FXML
    private TableColumn<Order, String> status;

    @FXML
    private TableColumn<Order, HBox> action;

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
        viewAllTable(table, orders);
    }

    // Initialize orders
    ObservableList<Order> orders = FXCollections.observableArrayList(
            new Order(1, 5, 20, "cái", "15/05/2024", "Chưa tạo", "Tivi"),
            new Order(2, 6, 30, "chiếc", "12/05/2024", "Chưa tạo", "Tủ lạnh"),
            new Order(3, 7, 40, "cuốn", "17/05/2024", "Chưa tạo", "Điều hòa"),
            new Order(4, 5, 11, "cái", "18/05/2024", "Chưa tạo", "Giày"),
            new Order(5, 5, 20, "cái", "15/05/2024", "Chưa tạo", "Tivi"),
            new Order(6, 6, 30, "chiếc", "12/05/2024", "Chưa tạo", "Tủ lạnh", "Day la not cua order"),
            new Order(7, 7, 40, "cuốn", "17/05/2024", "Chưa tạo", "Điều hòa"),
            new Order(8, 5, 11, "cái", "18/05/2024", "Chưa tạo", "Giày"),
            new Order(9, 5, 20, "cái", "15/05/2024", "Chưa tạo", "Tivi"),
            new Order(10, 6, 30, "chiếc", "12/05/2024", "Chưa tạo", "Tủ lạnh"),
            new Order(11, 7, 40, "cuốn", "17/05/2024", "Chưa tạo", "Điều hòa"),
            new Order(12, 5, 11, "cái", "18/05/2024", "Chưa tạo", "Giày", "Mua cua site X")
    );

    // Initialize requests
    Request request = new Request(1, "Dat hang 1", 3, "12/05/2024", "Doing", orders, "Mô tả công việc");

    @FXML
    void initialize() {
        // Set breadcrumbs
        setBreadcrumb(3);

        // Table
        startTable(table, orders);

        // Preview card
        requestName.setText(request.getName());
        makeAppearPreviewCard(table);
    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        expired_date.setCellValueFactory(new PropertyValueFactory<>("desired_date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(orders);
    }

    @Override
    public void insertToPreviewCard(Order order) {
        orderNote.setText(order.getNote() != null ? order.getNote() : "Không có");
        orderName.setText(order.getProduct_name());
        orderQuantity.setText(String.valueOf(order.getQuantity()));
        orderUnit.setText(order.getUnit());
        orderExpiredDate.setText(order.getDesired_date());
    }

}
