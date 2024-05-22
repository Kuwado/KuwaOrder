package fx.site;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.CSSiteOrdersList;

import java.util.ArrayList;
import java.util.List;

public class CSHandleSiteOrderController {


    public TableView<CSSiteOrdersList> siteOrderTable;
    public TableColumn<CSSiteOrdersList, Integer> idColumn;
    public TableColumn<CSSiteOrdersList, Integer> orderIdColumn;
    public TableColumn<CSSiteOrdersList, Integer> siteIdColumn;
    public TableColumn<CSSiteOrdersList, String> productNameColumn;
    public TableColumn<CSSiteOrdersList, Integer> quantityColumn;
    public TableColumn<CSSiteOrdersList, String> unitColumn;
    public TableColumn<CSSiteOrdersList, String> deliveryColumn;
    public TableColumn<CSSiteOrdersList, String> statusColumn;
    public TableColumn<CSSiteOrdersList, CheckBox> selectColumn;
    public Button confirmButton;
    public Button cancelButton;

    @FXML
    private void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        siteIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        loadTableData();
    }

    private void loadTableData() {
//        ObservableList<TestData> details = FXCollections.observableArrayList(
//                new TestData(1, 1, "Thùy Dung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(2, 2, "Lê Nhung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(3, 3, "Thùy Dung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(4, 4, "Lê Nhung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(5, 5, "Thùy Dung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(6, 6, "Lê Nhung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(7, 7, "Thùy Dung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(8, 9, "Lê Nhung", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox()),
//                new TestData(9, 10, "Cao Phong", "Điểm", 10 , "Hàng Không", "Đang xử lý", new CheckBox())
//        );
        siteOrderTable.setItems(CSSiteOrdersList.siteOrdersListsData());
    }

    @FXML
    public List<Integer> cancelSiteOrder(ActionEvent e) {
        ObservableList<CSSiteOrdersList> items = siteOrderTable.getItems();
        List<Integer> cancelSiteOrderIds = new ArrayList<>();
        for (CSSiteOrdersList item : items) {
            if (item.getSelected().isSelected()) {
                cancelSiteOrderIds.add(item.getSiteOrderId());
            }
        }
        System.out.println("Cancel site order IDs: " + cancelSiteOrderIds);
        CSSiteOrdersList.updateStatus(cancelSiteOrderIds, "Đang hủy");

        for (CSSiteOrdersList item : items) {
            if (item.getSelected().isSelected()) {
                item.setStatus("Đang hủy");
                item.getSelected().setSelected(false);
                item.getSelected().setDisable(true);
            }
        }
        siteOrderTable.refresh();


        return cancelSiteOrderIds;
    }

    @FXML
    public List<Integer> confirmSiteOrder(ActionEvent e) {
        ObservableList<CSSiteOrdersList> items = siteOrderTable.getItems();
        List<Integer> confirmSiteOrderIds = new ArrayList<>();
        for (CSSiteOrdersList item : items) {
            if (item.getSelected().isSelected()) {
                confirmSiteOrderIds.add(item.getSiteOrderId());
            }
        }

        CSSiteOrdersList.updateStatus(confirmSiteOrderIds, "Đã xác nhận");
        System.out.println("Confirm site order IDs: " + confirmSiteOrderIds);

        for (CSSiteOrdersList item : items) {
            if (item.getSelected().isSelected()) {
                item.setStatus("Đã xác nhận");
                item.getSelected().setSelected(false);
                item.getSelected().setDisable(true);
            }
        }
        siteOrderTable.refresh();

        return confirmSiteOrderIds;
    }
}
