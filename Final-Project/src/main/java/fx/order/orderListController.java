package fx.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Order;
import java.io.IOException;

public class orderListController {
    Order od1 = new Order(1, 123, 5, "Chiếc", "2024/05/25", "Đang xử lí", "Tivi");
    Order od2 = new Order(2, 324, 10, "Cái", "2024/04/21", "Giao đủ", "Bàn");
    Order od3 = new Order(3, 165, 7, "Chiếc", "2024/03/25", "Hủy", "Tủ lạnh");
    Order od4 = new Order(4, 342, 8, "Chiếc", "2024/4/25", "Thiếu", "Giường");
    Order od5 = new Order(5, 786, 21, "Thùng", "2024/06/25", "Giao muộn", "Khẩu trang");

    ObservableList<Order> od = FXCollections.observableArrayList(od1, od2, od3, od4, od5);

        @FXML
        private TableColumn<Order, String> tenSanPham;

        @FXML
        private TableColumn<Order, String> donVi;

        @FXML
        private Pagination pagination;

        @FXML
        private HBox breadcrumb;

        @FXML
        private TableColumn<Order, Integer> maSanPham;

        @FXML
        private TableColumn<Order, String> trangThai;

        @FXML
        private TableColumn<Order, Integer> id;

        @FXML
        private TableColumn<Order, String> ngayMongMuon;

        @FXML
        private TableView<Order> table;

        @FXML
        private TableColumn<Order, Integer> soLuong;
    @FXML
    void initialize() {
        OBreadcrumbController.number = 1;
        OBreadcrumbController ob = new OBreadcrumbController();
        ob.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/order.fxml");
        insertToTable();
        table.setItems(od); // Thêm đối tượng Request vào TableView
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && table.getSelectionModel().getSelectedItem() != null) {
                Order selectedOrder = table.getSelectionModel().getSelectedItem();
                showOrderDetails(selectedOrder);
            }
        });
    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        maSanPham.setCellValueFactory(new PropertyValueFactory<Order, Integer>("product_id"));
        soLuong.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
        donVi.setCellValueFactory(new PropertyValueFactory<Order, String>("unit"));
        ngayMongMuon.setCellValueFactory(new PropertyValueFactory<Order, String>("desired_date"));
        trangThai.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        tenSanPham.setCellValueFactory(new PropertyValueFactory<Order, String>("product_name"));

    }
    private void showOrderDetails(Order order) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/content/order/orderDetail.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chi tiết đơn hàng");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(table.getScene().getWindow());
            stage.setScene(new Scene(loader.load()));

            OrderDetailController controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setOrder(order);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
