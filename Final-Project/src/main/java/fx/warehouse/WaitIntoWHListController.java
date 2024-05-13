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
import model.Request;
import solution.DateConverter;

import java.util.concurrent.atomic.AtomicBoolean;

public class WaitIntoWHListController {
    LamTest lamTest1 = new LamTest(1, "ABC123", "Site A", "2024-05-13", "Đã nhận");
    LamTest lamTest2 = new LamTest(2, "DEF456", "Site B", "2024-05-14", "Chưa nhận");
    LamTest lamTest3 = new LamTest(3, "GHI789", "Site C", "2024-05-15", "Đã nhận");
    LamTest lamTest4 = new LamTest(4, "JKL012", "Site D", "2024-05-16", "Chưa nhận");
    LamTest lamTest5 = new LamTest(5, "MNO345", "Site E", "2024-05-17", "Đã nhận");

    ObservableList<LamTest> lamtest = FXCollections.observableArrayList(lamTest1,lamTest2, lamTest3, lamTest4, lamTest5);

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
        table.setItems(lamtest); // Thêm đối tượng Request vào TableView


    }

    private void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<LamTest, Integer>("stt"));
        maDonHang.setCellValueFactory(new PropertyValueFactory<LamTest, String>("maDonHang"));
        site.setCellValueFactory(new PropertyValueFactory<LamTest, String>("site"));
        ngayNhanHang.setCellValueFactory(new PropertyValueFactory<LamTest, String>("ngayNhanHang"));
        trangThai.setCellValueFactory(new PropertyValueFactory<LamTest, String>("trangThai"));
        action.setCellValueFactory(new PropertyValueFactory<LamTest, HBox>("action"));
    }




}
