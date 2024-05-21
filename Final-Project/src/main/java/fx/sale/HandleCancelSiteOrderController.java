package fx.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.CancelSiteOrderList;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class HandleCancelSiteOrderController {

    public TableView<CancelSiteOrderList> cancelSiteOrderIdTable;
    public TableColumn<CancelSiteOrderList, Integer> siteOrderIdColumn;
    public TableColumn<CancelSiteOrderList, String> siteNameColumn;
    public TableColumn<CancelSiteOrderList, String> productNameColumn;
    public TableColumn<CancelSiteOrderList, Integer> quantityColumn;
    public TableColumn<CancelSiteOrderList, String> unitColumn;
    public TableColumn<CancelSiteOrderList, String> deliveryColumn;
    public TableColumn<CancelSiteOrderList, Date> desiredDateColumn;
    public TableColumn<CancelSiteOrderList, String> statusColumn;
    public TableColumn<CancelSiteOrderList, CheckBox> selectedColumn;
    public Button reorderButton;
    public Button cancelButton;

    @FXML
    private void initialize() {
        siteOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("siteOrderId"));
        siteNameColumn.setCellValueFactory(new PropertyValueFactory<>("siteName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        desiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        selectedColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        loadTableData();
    }

    private void loadTableData() {
//        ObservableList<ThucTestData> data = FXCollections.observableArrayList(
//                new ThucTestData(1, "Nhà sách Nhã Nam", "Đại dương đen", 10, "Cuốn", "Tàu", Date.valueOf("2025-12-25"), new CheckBox())
//        );
        cancelSiteOrderIdTable.setItems(CancelSiteOrderList.cancelSiteOrderListsData());
    }

    @FXML
    public void reorder(ActionEvent e) {
        ObservableList<CancelSiteOrderList> items = cancelSiteOrderIdTable.getItems();
        List<Integer> reorderIds = new ArrayList<>();
        for (CancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                reorderIds.add(item.getSiteOrderId());
            }
        }
        System.out.println("Reorder IDs: " + reorderIds);
        CancelSiteOrderList.updateStatus(reorderIds, "Đang đặt lại");

        for (CancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                item.setStatus("Đang đặt lại");
                item.getSelected().setSelected(false);
                item.getSelected().setDisable(true);
            }
        }
        cancelSiteOrderIdTable.refresh();
    }

    @FXML
    public void cancel() {
        ObservableList<CancelSiteOrderList> items = cancelSiteOrderIdTable.getItems();
        List<Integer> cancelIds = new ArrayList<>();
        for (CancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                cancelIds.add(item.getSiteOrderId());
            }
        }

        CancelSiteOrderList.updateStatus(cancelIds, "Đã hủy");
        System.out.println("Cancel site order IDs: " + cancelIds);

        for (CancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                item.setStatus("Đã hủy");
                item.getSelected().setSelected(false);
                item.getSelected().setDisable(true);
            }
        }

        cancelSiteOrderIdTable.refresh();
    }


}
