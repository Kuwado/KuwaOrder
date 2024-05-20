package fx.wh;

import controller.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Order;
import model.Product;
import model.SiteOrder;
import model.tabledata.WHSiteOrder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class whListController extends whController<WHSiteOrder> {
    private WHSiteOrder selectedOrder;

    @FXML
    private TableView<WHSiteOrder> table;

    @FXML
    private TableColumn<WHSiteOrder, Integer> id;

    @FXML
    private TableColumn<WHSiteOrder, String> maDonHang;

    @FXML
    private TableColumn<WHSiteOrder, String> site;

    @FXML
    private TableColumn<WHSiteOrder, String> phuongThuc;

    @FXML
    private TableColumn<WHSiteOrder, String> trangThai;

    @FXML
    private TableColumn<WHSiteOrder, Button> action;

    @FXML
    private Pagination pagination;

    private final SiteController siteController = new SiteController();
    private final OrderController orderController = new OrderController();
    private final ProductController productController = new ProductController();
    private final SiteProductController siteProductController = new SiteProductController();
    private final SiteOrderController siteOrderController = new SiteOrderController();
    private final ObservableList<WHSiteOrder> whSiteOrders = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setBreadcrumb(1, "/view/parts/breadcrumbs/warehousee.fxml");
        loadData();
        number = 9;
        startTable(table, whSiteOrders);
    }

    private void loadData() {
        List<SiteOrder> orders = siteOrderController.getAllSiteOrders();
        for (SiteOrder order : orders) {
            Button button = new Button("Action");
            WHSiteOrder whSiteOrder = new WHSiteOrder(order, button);
            button.setOnAction(event -> {
                try {
                    selectedOrder = whSiteOrder;  // Đặt giá trị cho selectedOrder trước khi mở pop-up
                    runPopUp("/view/popUp/whDetail.fxml", 620, 438);
                    printOrderDetails(whSiteOrder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            whSiteOrders.add(whSiteOrder);
        }
    }

    public WHSiteOrder getSelectedOrder() {
        return selectedOrder;
    }

    private void printOrderDetails(WHSiteOrder order) {
        System.out.println("ID: " + order.getId());
        System.out.println("Mã Đơn Hàng: " + order.getMaDonHang());
        System.out.println("Site: " + order.getSite());
        System.out.println("Phương Thức: " + order.getPhuongThuc());
        System.out.println("Trạng Thái: " + order.getTrangThai());
    }

    @FXML
    void viewAll(ActionEvent event) {
        table.setItems(whSiteOrders);
    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        maDonHang.setCellValueFactory(new PropertyValueFactory<>("maDonHang"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        phuongThuc.setCellValueFactory(new PropertyValueFactory<>("phuongThuc"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));

        table.setItems(whSiteOrders);
    }

    @Override
    public void setDataToTrans(WHSiteOrder whSiteOrder) {
        // Implement if needed
    }

    private void runPopUp(String path, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        BorderPane pane = loader.load();

        // Lấy controller của cửa sổ pop-up
        whDetailController controller = loader.getController();

        // Khởi tạo các đối tượng cần thiết dựa trên selectedOrder
        SiteOrder sod = siteOrderController.getSiteOrderById(selectedOrder.getId());
        Order ood = orderController.getOrderById(sod.getOrderId());
        Product prd = productController.getProductById(ood.getProductId());

        // Truyền dữ liệu sang cửa sổ pop-up
        controller.setData(
                String.valueOf(selectedOrder.getId()),
                selectedOrder.getTrangThai(),
                prd.getName(),
                sod.getQuantity(),
                ood.getUnit(),
                selectedOrder.getMaDonHang(),
                selectedOrder.getPhuongThuc(),
                String.valueOf(sod.getPrice()),
                sod.getNote()
        );

        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Lấy kích thước của màn hình
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Tính toán vị trí để pop-up được hiển thị chính giữa màn hình
        double popupX = (screenWidth - width) / 2;
        double popupY = (screenHeight - height) / 2;

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/makeOrder.css")).toExternalForm());
        primaryStage.setScene(scene);

        // Đặt vị trí cho pop-up
        primaryStage.setX(popupX);
        primaryStage.setY(popupY);

        primaryStage.show();
    }
}
