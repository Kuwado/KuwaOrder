package fx.warehouse;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.LamTest;
import solution.DateConverter;
import solution.Paginator;
import solution.PaginatorLamTest;

import java.util.concurrent.atomic.AtomicBoolean;

public class WaitIntoWHListController {
    LamTest lamTest1 = new LamTest(1, "ABC123", "Site A", "2024-05-13", "Đã nhận");
    LamTest lamTest2 = new LamTest(2, "DEF456", "Site B", "2024-05-14", "Chưa nhận");
    LamTest lamTest3 = new LamTest(3, "GHI789", "Site C", "2024-05-15", "Đã nhận");
    LamTest lamTest4 = new LamTest(4, "JKL012", "Site D", "2024-05-16", "Chưa nhận");
    LamTest lamTest5 = new LamTest(5, "MNO345", "Site E", "2024-05-17", "Đã nhận");
    LamTest lamTest6 = new LamTest(6, "ABC123", "Site A", "2024-05-13", "Đã nhận");
    LamTest lamTest7 = new LamTest(7, "DEF456", "Site B", "2024-05-14", "Chưa nhận");
    LamTest lamTest8 = new LamTest(8, "GHI789", "Site C", "2024-05-15", "Đã nhận");
    LamTest lamTest9 = new LamTest(9, "JKL012", "Site D", "2024-05-16", "Chưa nhận");
    LamTest lamTest10 = new LamTest(10, "MNO345", "Site E", "2024-05-17", "Đã nhận");
    LamTest lamTest11 = new LamTest(11, "ABC123", "Site A", "2024-05-13", "Đã nhận");
    LamTest lamTest12 = new LamTest(12, "DEF456", "Site B", "2024-05-14", "Chưa nhận");
    LamTest lamTest13 = new LamTest(13, "GHI789", "Site C", "2024-05-15", "Đã nhận");
    LamTest lamTest14 = new LamTest(14, "JKL012", "Site D", "2024-05-16", "Chưa nhận");
    LamTest lamTest15 = new LamTest(15, "MNO345", "Site E", "2024-05-17", "Đã nhận");


    ObservableList<LamTest> lamtest = FXCollections.observableArrayList(lamTest1,lamTest2, lamTest3, lamTest4, lamTest5, lamTest6,lamTest7, lamTest8, lamTest9, lamTest10, lamTest11,lamTest12, lamTest13, lamTest14, lamTest15);

    @FXML
    private HBox breadcrumb;

    @FXML
    private TableView<LamTest> table;

    @FXML
    private TableColumn<LamTest, Integer> id;

    @FXML
    private TableColumn<LamTest, String> maDonHang;

    @FXML
    private TableColumn<LamTest, String> site;

    @FXML
    private TableColumn<LamTest, String> ngayNhanHang;

    @FXML
    private TableColumn<LamTest, String> trangThai;

    @FXML
    private TableColumn<LamTest, HBox> action;

    @FXML
    private Pagination pagination;



    @FXML
    void initialize() {
        WHBreadcrumbController.number = 2;
        WHBreadcrumbController wh = new WHBreadcrumbController();
        wh.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/warehousee.fxml");


        insertToTable();
    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("stt"));
        maDonHang.setCellValueFactory(new PropertyValueFactory<>("maDonHang"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        ngayNhanHang.setCellValueFactory(new PropertyValueFactory<>("ngayNhanHang"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(lamtest);
    }




}
