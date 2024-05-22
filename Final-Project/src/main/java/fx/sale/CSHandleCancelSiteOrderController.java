package fx.sale;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tabledata.CSCancelSiteOrderList;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class CSHandleCancelSiteOrderController {

    public TableView<CSCancelSiteOrderList> cancelSiteOrderIdTable;
    public TableColumn<CSCancelSiteOrderList, Integer> siteOrderIdColumn;
    public TableColumn<CSCancelSiteOrderList, String> siteNameColumn;
    public TableColumn<CSCancelSiteOrderList, String> productNameColumn;
    public TableColumn<CSCancelSiteOrderList, Integer> quantityColumn;
    public TableColumn<CSCancelSiteOrderList, String> unitColumn;
    public TableColumn<CSCancelSiteOrderList, String> deliveryColumn;
    public TableColumn<CSCancelSiteOrderList, Date> desiredDateColumn;
    public TableColumn<CSCancelSiteOrderList, String> statusColumn;
    public TableColumn<CSCancelSiteOrderList, CheckBox> selectedColumn;
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
        cancelSiteOrderIdTable.setItems(CSCancelSiteOrderList.cancelSiteOrderListsData());
    }

    @FXML
    public void reorder(ActionEvent e) {
        ObservableList<CSCancelSiteOrderList> items = cancelSiteOrderIdTable.getItems();
        List<Integer> reorderIds = new ArrayList<>();
        for (CSCancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                reorderIds.add(item.getSiteOrderId());
            }
        }
        System.out.println("Reorder IDs: " + reorderIds);
        CSCancelSiteOrderList.updateStatus(reorderIds, "Đang đặt lại");

        for (CSCancelSiteOrderList item : items) {
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
        ObservableList<CSCancelSiteOrderList> items = cancelSiteOrderIdTable.getItems();
        List<Integer> cancelIds = new ArrayList<>();
        for (CSCancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                cancelIds.add(item.getSiteOrderId());
            }
        }

        CSCancelSiteOrderList.updateStatus(cancelIds, "Đã hủy");
        System.out.println("Cancel site order IDs: " + cancelIds);

        for (CSCancelSiteOrderList item : items) {
            if(item.getSelected().isSelected()) {
                item.setStatus("Đã hủy");
                item.getSelected().setSelected(false);
                item.getSelected().setDisable(true);
            }
        }

        cancelSiteOrderIdTable.refresh();
    }


}
