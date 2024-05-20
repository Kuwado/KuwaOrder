package fx.wh;

import controller.SiteOrderController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.SiteOrder;
import model.tabledata.WHSiteOrder;

import java.util.List;

public class whListController extends whController<WHSiteOrder> {

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

    private final SiteOrderController siteOrderController = new SiteOrderController();
    private final ObservableList<WHSiteOrder> whSiteOrders = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setBreadcrumb(2, "/view/parts/breadcrumbs/warehousee.fxml");
        loadData();
        number = 9;
        startTable(table, whSiteOrders);
    }

    private void loadData() {
        List<SiteOrder> orders = siteOrderController.getAllSiteOrders();
        for (SiteOrder order : orders) {
            Button button = new Button("Action");
            whSiteOrders.add(new WHSiteOrder(order, button));
        }
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
        // Thực hiện các hành động cần thiết khi dữ liệu được chuyển từ đối tượng WHSiteOrder
    }
}
