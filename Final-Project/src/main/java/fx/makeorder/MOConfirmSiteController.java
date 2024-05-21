package fx.makeorder;

import controller.SiteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import model.tabledata.MOChosenQuantity;
import model.tabledata.MOConfirmSite;

import java.io.IOException;
import java.util.ArrayList;


public class MOConfirmSiteController {

    @FXML
    private TableView<MOConfirmSite> chosenSiteTable;

    @FXML
    private TableColumn<MOConfirmSite, Integer> stt;

    @FXML
    private TableColumn<MOConfirmSite, String> siteName;

    @FXML
    private TableColumn<MOConfirmSite, String> delivery;

    @FXML
    private TableColumn<MOConfirmSite, Integer> quantity;

    @FXML
    private TableColumn<MOConfirmSite, String> takeDate;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button backBtn;

    private final ObservableList<MOConfirmSite> confirmSites = FXCollections.observableArrayList();
    private static ArrayList<MOChosenQuantity> chosenQuantities;
    private static String sDate;
    private final SiteController siteController = new SiteController();

    @FXML
    void initialize() {

        for (MOChosenQuantity q : chosenQuantities) {
            String name = siteController.getSiteById(q.getSiteId()).getName();
            confirmSites.add(new MOConfirmSite(name, q.getDeliveryType(), q.getChosenQuantity(), sDate));
        }

        // Chèn vào table
        insertToTable();

        // Reset stt
        MOConfirmSite.setIdCounter(1);
    }

    public void insertToTable() {
        stt.setCellValueFactory(new PropertyValueFactory<MOConfirmSite, Integer>("id"));
        siteName.setCellValueFactory(new PropertyValueFactory<MOConfirmSite, String>("name"));
        delivery.setCellValueFactory(new PropertyValueFactory<MOConfirmSite, String>("deliveryType")); // Đặt lại tên thuộc tính
        quantity.setCellValueFactory(new PropertyValueFactory<MOConfirmSite, Integer>("quantity")); // Đặt lại tên thuộc tính
        takeDate.setCellValueFactory(new PropertyValueFactory<MOConfirmSite, String>("expectedDate"));
        chosenSiteTable.setItems(confirmSites);
    }

    public static void setChosenQuantities(ArrayList<MOChosenQuantity> chosenQuantities) {
        MOConfirmSiteController.chosenQuantities = chosenQuantities;
    }

    public static void setsDate(String sDate) {
        MOConfirmSiteController.sDate = sDate;
    }

    @FXML
    void back(ActionEvent event) {
        // Lấy Stage hiện tại từ ActionEvent
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Đóng Stage (popup)
        stage.close();
    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        MOOrderController.runPopUp("/view/popUp/MOExpectedSiteOrder.fxml", 700, 700);
    }
}
