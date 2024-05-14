package fx.make_order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Pagination;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.fxml.FXML;

import model.Order;
import model.Request;
import solution.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class MORequestListController {

    // Khởi tạo các đơn hàng (Order)
    Order order1 = new Order(1, 5, 20, "cái", "15/05/2024", "Chưa tạo", "Tivi");
    Order order2 = new Order(2, 6, 30, "chiếc", "12/05/2024", "Chưa tạo", "Tủ lạnh");
    Order order3 = new Order(3, 7, 40, "cuốn", "17/05/2024", "Chưa tạo", "Điều hòa");
    Order order4 = new Order(4, 5, 11, "cái", "18/05/2024", "Chưa tạo", "Giày");

    // Khởi tạo các danh sách các đơn hàng (ObservableList<Order>)
    ObservableList<Order> orders1 = FXCollections.observableArrayList(order1, order2, order3);
    ObservableList<Order> orders2 = FXCollections.observableArrayList(order2, order1);
    ObservableList<Order> orders3 = FXCollections.observableArrayList(order4, order2, order3);
    ObservableList<Order> orders4 = FXCollections.observableArrayList(order1, order2, order3, order4);

    // Khởi tạo và thêm các yêu cầu (Request) vào danh sách requests
    Request request1 = new Request(1, "Dat hang 1", 3, "12/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request2 = new Request(2, "Dat hang 2", 2, "11/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request3 = new Request(3, "Dat hang 3", 3, "10/05/2024", "Doing", orders3, "Hau quá");
    Request request4 = new Request(4, "Dat hang 4", 4, "12/05/2024", "Doing", orders4, "kakaka");
    Request request10 = new Request(10, "Dat hang 1", 3, "12/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request12 = new Request(12, "Dat hang 2", 2, "11/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request9 = new Request(9, "Dat hang 3", 3, "10/05/2024", "Doing", orders3, "Hau quá");
    Request request11 = new Request(11, "Dat hang 4", 4, "12/05/2024", "Doing", orders4, "kakaka");
    Request request8 = new Request(8, "Dat hang 1", 3, "12/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request7 = new Request(7, "Dat hang 2", 2, "11/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request6 = new Request(6, "Dat hang 3", 3, "10/05/2024", "Doing", orders3, "Hau quá");
    Request request5 = new Request(5, "Dat hang 4", 4, "12/05/2024", "Doing", orders4, "kakaka");

    // Thêm các yêu cầu vào danh sách requests
    ObservableList<Request> requests = FXCollections.observableArrayList();


    private HBox hb;

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
    private AnchorPane previewCard;

    @FXML
    private TextArea previewCategory;

    @FXML
    private VBox previewContent;

    @FXML
    private TextArea previewDes;

    @FXML
    private Label previewExpiredDate;

    @FXML
    private Label previewName;

    @FXML
    private Label previewSendDate;

    @FXML
    private Button viewAll;

    @FXML
    private Pane hidePagination;

    private boolean viewAllStt = false;

    @FXML
    void initialize() {
        requests.add(request1);
        requests.add(request2);
        requests.add(request3);
        requests.add(request4);
        requests.add(request5);
        requests.add(request6);
        requests.add(request7);
        requests.add(request8);
        requests.add(request9);
        requests.add(request10);
        requests.add(request11);
        requests.add(request12);

        // Breadcrumbs
        MOBreadcrumbController.number = 2;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Thêm dữ liệu vào bảng
        hidePagination.setVisible(false);
        insertToTable();
        //setPagination(5);
        Paginator.setPagination(table, pagination, requests, 10);





        // Preview card
        AtomicBoolean previewStt = new AtomicBoolean(false);
        previewCard.setTranslateY(800);
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                if (!previewStt.get()) {
                    Transition.transitionXY(previewCard, 0, 0, 0.7);
                    previewStt.set(true);
                }
                Request res = table.getSelectionModel().getSelectedItem();
                if (res != null) {
                    insertToPreviewCard(res);
                }
            }
        });



    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<Request, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Request, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Request, Integer>("order_quantity")); // Đặt lại tên thuộc tính
        send_date.setCellValueFactory(new PropertyValueFactory<Request, String>("send_date")); // Đặt lại tên thuộc tính
        status.setCellValueFactory(new PropertyValueFactory<Request, String>("status"));
        action.setCellValueFactory(new PropertyValueFactory<Request, HBox>("action"));
        table.setItems(requests);
    }

    private void insertToPreviewCard(Request request) {
        StringBuilder productList = new StringBuilder();
        ObservableList<Order> orders = request.getOrders();
        String[] dates = new String[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            dates[i] = orders.get(i).getDesired_date();
        }
        DateConverter.sortDates(dates);
        String exDate = dates[orders.size() - 1];

        String[] products = new String[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            productList.append(orders.get(i).getProduct_name());
            if (i != orders.size() - 1) {
                productList.append(", ");
            }
        }

        previewName.setText(request.getName());
        previewDes.setText(request.getDescription());
        previewSendDate.setText(request.getSend_date());
        previewExpiredDate.setText(exDate);
        previewCategory.setText(String.valueOf(productList));
    }

    @FXML
    void viewAll(ActionEvent event) {
        Button buttonClicked = (Button) event.getSource();
        if (!viewAllStt) {
            buttonClicked.setText("Phân trang");
            hidePagination.setVisible(true);
            table.setItems(requests);

        } else {
            buttonClicked.setText("Xem tất cả");
            hidePagination.setVisible(false);
            Paginator.setPagination(table, pagination, requests, 10);
        }
        viewAllStt = !viewAllStt;
    }
}
