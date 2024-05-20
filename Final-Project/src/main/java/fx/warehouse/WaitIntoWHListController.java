package fx.warehouse;

import fx.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.LamTest;
import model.SanPham;
import model.tabledata.LamTestOrder;
import solution.PaginatorLamTest;

import java.util.ArrayList;
import java.util.List;

public class WaitIntoWHListController {

    private List<SanPham> danhSachSanPham1;
    private List<SanPham> danhSachSanPham2;

    private MainController mc;

    // Constructor để thiết lập MainController
    public WaitIntoWHListController(MainController mainController) {
        this.mc = mainController;
    }




    private ObservableList<LamTestOrder> lamTestOrders;

    @FXML
    private HBox breadcrumb;

    @FXML
    private TableView<LamTestOrder> table;

    @FXML
    private TableColumn<LamTestOrder, Integer> id;

    @FXML
    private TableColumn<LamTestOrder, String> maDonHang;

    @FXML
    private TableColumn<LamTestOrder, String> site;

    @FXML
    private TableColumn<LamTestOrder, String> ngayNhanHang;

    @FXML
    private TableColumn<LamTestOrder, String> trangThai;

    @FXML
    private TableColumn<LamTestOrder, Button> action;

    @FXML
    private Pagination pagination;

    public WaitIntoWHListController() {

        // Tạo các đối tượng SanPham
        SanPham sanPham1 = new SanPham("SP001", "Sản phẩm A", 2, 10.99);
        SanPham sanPham2 = new SanPham("SP002", "Sản phẩm B", 1, 15.49);
        SanPham sanPham3 = new SanPham("SP003", "Sản phẩm C", 3, 8.25);

        // Tạo danh sách sản phẩm cho mỗi đơn hàng
        danhSachSanPham1 = new ArrayList<>();
        danhSachSanPham1.add(sanPham1);
        danhSachSanPham1.add(sanPham2);

        danhSachSanPham2 = new ArrayList<>();
        danhSachSanPham2.add(sanPham3);
        danhSachSanPham2.add(sanPham2);

        // Tạo các đối tượng LamTest và chuyển thành LamTestOrder
        lamTestOrders = FXCollections.observableArrayList();
        List<LamTest> lamTestList = createLamTestData();
        for (LamTest lamTest : lamTestList) {
            Button actionButton = new Button("View");
            actionButton.setOnAction(event -> handleAction(lamTest));
            lamTestOrders.add(new LamTestOrder(lamTest, actionButton));
        }
    }

    private List<LamTest> createLamTestData() {
        List<LamTest> lamTestList = new ArrayList<>();
        lamTestList.add(new LamTest(1, "ABC123", "Site A", "2024-05-13", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(2, "DEF456", "Site B", "2024-05-14", "Chưa nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(3, "GHI789", "Site C", "2024-05-15", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(4, "JKL012", "Site D", "2024-05-16", "Chưa nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(5, "MNO345", "Site E", "2024-05-17", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(6, "ABC123", "Site A", "2024-05-13", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(7, "DEF456", "Site B", "2024-05-14", "Chưa nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(8, "GHI789", "Site C", "2024-05-15", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(9, "JKL012", "Site D", "2024-05-16", "Chưa nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(10, "MNO345", "Site E", "2024-05-17", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(11, "ABC123", "Site A", "2024-05-13", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(12, "GHI789", "Site C", "2024-05-15", "Đã nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(13, "JKL012", "Site D", "2024-05-16", "Chưa nhận", danhSachSanPham1));
        lamTestList.add(new LamTest(14, "MNO345", "Site E", "2024-05-17", "Đã nhận", danhSachSanPham1));
        return lamTestList;
    }

    @FXML
    void initialize() {
        WHBreadcrumbController.number = 2;
        WHBreadcrumbController wh = new WHBreadcrumbController();
        wh.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/warehousee.fxml");

        insertToTable();
        PaginatorLamTest.setPagination(table, pagination, lamTestOrders, 10);
    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("stt"));
        maDonHang.setCellValueFactory(new PropertyValueFactory<>("maDonHang"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        ngayNhanHang.setCellValueFactory(new PropertyValueFactory<>("ngayNhanHang"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(lamTestOrders);
    }

    private void handleAction(LamTest lamTest) {
        System.out.println("Action button clicked for order: " + lamTest.getMaDonHang());
    }
}
