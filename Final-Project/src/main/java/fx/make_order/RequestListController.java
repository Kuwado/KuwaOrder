package fx.make_order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import model.Order;
import model.Request;
import fx.other.ButtonIntoTable;

import java.io.IOException;

public class RequestListController {

    // Khởi tạo các đơn hàng (Order)
    Order order1 = new Order(1, 5, 20, "cái", "15/05/2024", "Chưa tạo");
    Order order2 = new Order(2, 6, 30, "chiếc", "12/05/2024", "Chưa tạo");
    Order order3 = new Order(3, 7, 40, "cuốn", "17/05/2024", "Chưa tạo");
    Order order4 = new Order(4, 5, 11, "cái", "18/05/2024", "Chưa tạo");

    // Khởi tạo các danh sách các đơn hàng (ObservableList<Order>)
    ObservableList<Order> orders1 = FXCollections.observableArrayList(order1, order2, order3);
    ObservableList<Order> orders2 = FXCollections.observableArrayList(order2, order3);
    ObservableList<Order> orders3 = FXCollections.observableArrayList(order4, order2, order3);
    ObservableList<Order> orders4 = FXCollections.observableArrayList(order1, order2, order3, order4);

    // Khởi tạo và thêm các yêu cầu (Request) vào danh sách requests
    Request request1 = new Request(1, "Dat hang 1", 3, "12/05/2024", "Doing", orders1);
    Request request2 = new Request(2, "Dat hang 2", 2, "11/05/2024", "Doing", orders2);
    Request request3 = new Request(3, "Dat hang 3", 3, "10/05/2024", "Doing", orders3);
    Request request4 = new Request(4, "Dat hang 4", 4, "12/05/2024", "Doing", orders4);

    // Thêm các yêu cầu vào danh sách requests
    ObservableList<Request> requests = FXCollections.observableArrayList(request1, request2, request3, request4);


    @FXML
    private HBox breadcrumb;

    @FXML
    private TableView<Request> table;

    @FXML
    private TableColumn<Request, Integer> id;

    @FXML
    private TableColumn<Request, String> name;

    @FXML
    private TableColumn<Request, Integer> quantity;

    @FXML
    private TableColumn<Request, String> send_date;

    @FXML
    private TableColumn<Request, String> status;

    @FXML
    private TableColumn<Request, HBox> action;

    @FXML
    private Pagination pagination;

    @FXML
    private Pane card;

    @FXML
    void initialize() {
        MOBreadcrumbController.number = 2;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/MakeOrder.fxml");

        insertToTable();
        table.setItems(requests); // Thêm đối tượng Request vào TableView
        //insertView();


    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<Request, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Request, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Request, Integer>("order_quantity")); // Đặt lại tên thuộc tính
        send_date.setCellValueFactory(new PropertyValueFactory<Request, String>("send_date")); // Đặt lại tên thuộc tính
        status.setCellValueFactory(new PropertyValueFactory<Request, String>("status"));
        action.setCellValueFactory(new PropertyValueFactory<Request, HBox>("hbox"));
    }

}
