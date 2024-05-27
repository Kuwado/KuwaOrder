package fx.makeorder;

import controller.OrderController;
import controller.ProductController;
import controller.RequestController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;

import model.*;
import model.tabledata.MOOrder;
import model.tabledata.MORequest;
import solution.*;

import java.util.ArrayList;
import java.util.List;

public class MORequestListController extends MOController<MORequest> {
    @FXML
    private TableView<MORequest> table;

    @FXML
    private TableColumn<MORequest, Integer> id;

    @FXML
    private TableColumn<MORequest, Integer> quantity;

    @FXML
    private TableColumn<MORequest, String> send_date;

    @FXML
    private TableColumn<MORequest, String> status;

    @FXML
    private TableColumn<MORequest, String> action;

    @FXML
    private TextArea previewCategory;

    @FXML
    private TextArea previewDes;

    @FXML
    private Label previewExpiredDate;

    @FXML
    private Label previewName;

    @FXML
    private Label previewSendDate;

    private final RequestController requestController = new RequestController();
    private final OrderController orderController = new OrderController();
    private final ProductController productController = new ProductController();
    private final ObservableList<MORequest> moRequests = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        ArrayList<Request> requests = requestController.getWaitRequests();

        String buttonPath = "/view/content/makeorder/MORequest.fxml";
        for (Request request : requests) {
            Button button = new Button();
            button.getStyleClass().add("table-view-btn");
            MORequest moRequest = new MORequest(request, button);
            button.setOnAction(event -> {
                viewRequestDetail(moRequest, event, buttonPath);
            });
            moRequests.add(moRequest);
        }

        // Breadcrumbs
        setBreadcrumb(2, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Thêm dữ liệu vào bảng
        startTable(table, moRequests);

        // Preview card
        makeAppearPreviewCard(table);

        // Reset stt
        MORequest.setIdCounter(1);
    }

    @Override
    public boolean setDataToTrans(MORequest moRequest) {
        Request res = requestController.getRequestById(moRequest.getRequest().getId());
        ArrayList<Order> resOrders = orderController.getWaitOrdersInRequest(res.getId());
        if (resOrders.size() > 0) {
            MORequestController.setRequest(res);
            return true;
        } else
            return false;
    }

    @Override
    public void insertToTable(ObservableList<MORequest> mos) {
        id.setCellValueFactory(new PropertyValueFactory<MORequest, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<MORequest, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<MORequest, Integer>("orderQuantity")); // Đặt lại tên thuộc tính
        send_date.setCellValueFactory(new PropertyValueFactory<MORequest, String>("sendDate")); // Đặt lại tên thuộc tính
        status.setCellValueFactory(new PropertyValueFactory<MORequest, String>("status"));
        action.setCellValueFactory(new PropertyValueFactory<MORequest, String>("action"));
        table.setItems(mos);
    }

    @Override
    public void insertToPreviewCard(MORequest moRequest) {
        Request request = moRequest.getRequest();
        StringBuilder productList = new StringBuilder();
        List<Order> orders = orderController.getWaitOrdersInRequest(request.getId());
        String exDate;
        if (orders.size() > 0) {
            String[] dates = new String[orders.size()];
            for (int i = 0; i < orders.size(); i++) {
                dates[i] = orders.get(i).getDesiredDate();
            }
            DateConverter.sortDates(dates);
            exDate = dates[0];
        } else {
            exDate = "Chưa có";
        }

        for (int i = 0; i < orders.size(); i++) {
            productList.append(productController.getProductById(orders.get(i).getProductId()).getName());
            if (i != orders.size() - 1) {
                productList.append(", ");
            }
        }

        previewName.setText(request.getName());
        previewDes.setText(request.getDescription());
        previewSendDate.setText(request.getSendDate());
        previewExpiredDate.setText(exDate);
        previewCategory.setText(String.valueOf(productList));
    }

    @FXML
    void viewAll(ActionEvent event) {
        viewAllTable(table, moRequests);
    }
}
