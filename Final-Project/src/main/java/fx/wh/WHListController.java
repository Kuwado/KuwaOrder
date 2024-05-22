package fx.wh;

import controller.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class WHListController extends WHController<WHSiteOrder> {
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

    @FXML
    private TextField searchInput;

    private final SiteController siteController = new SiteController();
    private final OrderController orderController = new OrderController();
    private final ProductController productController = new ProductController();
    private final SiteProductController siteProductController = new SiteProductController();
    private final SiteOrderController siteOrderController = new SiteOrderController();
    private final ObservableList<WHSiteOrder> whSiteOrders = FXCollections.observableArrayList();
    private final ObservableList<WHSiteOrder> filteredOrders = FXCollections.observableArrayList();  // Thêm danh sách lọc

    @FXML
    public void initialize() {
        setBreadcrumb(1, "/view/parts/breadcrumbs/Warehouse.fxml");
        loadData();
        number = 7;
        startTable(table, whSiteOrders);
        setSearchFunctionality();
    }

    private void loadData() {
        whSiteOrders.clear();  // Clear the list before loading new data
        List<SiteOrder> orders = siteOrderController.getAllSiteOrders();
        for (SiteOrder order : orders) {
            Button button = new Button("Action");
            WHSiteOrder whSiteOrder = new WHSiteOrder(order, button);
            button.setOnAction(event -> {
                try {
                    selectedOrder = whSiteOrder;  // Đặt giá trị cho selectedOrder trước khi mở pop-up
                    runPopUp("/view/popUp/WHDetail.fxml", 620, 438);
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

    @Override
    public void insertToTable(ObservableList<WHSiteOrder> items) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        maDonHang.setCellValueFactory(new PropertyValueFactory<>("maDonHang"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        phuongThuc.setCellValueFactory(new PropertyValueFactory<>("phuongThuc"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));

        table.setItems(items);
    }

    @Override
    public void setDataToTrans(WHSiteOrder whSiteOrder) {
        // Implement if needed
    }

    public void runPopUp(String path, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        BorderPane pane = loader.load();
        // Lấy controller của cửa sổ pop-up
        WHDetailController controller = loader.getController();

        controller.setWHListController(this);
        // Khởi tạo các đối tượng cần thiết dựa trên selectedOrder
        SiteOrder sod = siteOrderController.getSiteOrderById(selectedOrder.getId());

        // Kiểm tra nếu sod là null
        if (sod == null) {
            System.out.println("SiteOrder with id " + selectedOrder.getId() + " not found.");
            return;
        }

        Order ood = orderController.getOrderById(sod.getOrderId());

        // Kiểm tra nếu ood là null
        if (ood == null) {
            System.out.println("Order with id " + sod.getOrderId() + " not found.");
            return;
        }

        Product prd = productController.getProductById(ood.getProductId());

        // Kiểm tra nếu prd là null
        if (prd == null) {
            System.out.println("Product with id " + ood.getProductId() + " not found.");
            return;
        }

        // Truyền dữ liệu sang cửa sổ pop-up
        controller.setData(
                String.valueOf(selectedOrder.getId()),
                selectedOrder.getTrangThai(),
                prd.getName(),
                sod.getQuantity(),
                ood.getUnit(),
                selectedOrder.getMaDonHang(),
                selectedOrder.getPhuongThuc(),
                sod.getPrice(),
                sod.getNote(),
                prd.getImage(), // Truyền URL hình ảnh
                prd.getId(),
                selectedOrder.getId()
        );
        controller.setWHListController(this);

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
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/lam.css")).toExternalForm());
        primaryStage.setScene(scene);

        // Đặt vị trí cho pop-up
        primaryStage.setX(popupX);
        primaryStage.setY(popupY);

        primaryStage.show();
    }


    private void setSearchFunctionality() {
        searchInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredOrders.clear();
            if (newValue == null || newValue.isEmpty()) {
                filteredOrders.addAll(whSiteOrders);
            } else {
                String lowerCaseFilter = newValue.toLowerCase();
                for (WHSiteOrder order : whSiteOrders) {
                    if (order.getMaDonHang().toLowerCase().contains(lowerCaseFilter) ||
                            order.getSite().toLowerCase().contains(lowerCaseFilter) ||
                            order.getPhuongThuc().toLowerCase().contains(lowerCaseFilter) ||
                            order.getTrangThai().toLowerCase().contains(lowerCaseFilter)) {
                        filteredOrders.add(order);
                    }
                }
            }
            insertToTable(filteredOrders);
        });
    }

    public void refreshTable() {
        System.out.println("Refreshing table...");  // Debug message
        loadData();
        number = 7;
        startTable(table, whSiteOrders); // Ensure table items are updated
        table.refresh();
    }
}
