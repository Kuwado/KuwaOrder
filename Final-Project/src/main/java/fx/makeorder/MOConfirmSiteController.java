package fx.makeorder;

import controller.OrderController;
import controller.ProductController;
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
import model.tabledata.ChosenQuantity;
import model.tabledata.ConfirmSite;
import model.tabledata.MOOrder;

import java.util.ArrayList;


public class MOConfirmSiteController {

    @FXML
    private TableView<ConfirmSite> chosenSiteTable;

    @FXML
    private TableColumn<ConfirmSite, Integer> stt;

    @FXML
    private TableColumn<ConfirmSite, String> siteName;

    @FXML
    private TableColumn<ConfirmSite, String> delivery;

    @FXML
    private TableColumn<ConfirmSite, Integer> quantity;

    @FXML
    private TableColumn<ConfirmSite, String> takeDate;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button backBtn;

    private final ObservableList<ConfirmSite> confirmSites = FXCollections.observableArrayList();
    private static ArrayList<ChosenQuantity> chosenQuantities = new ArrayList<>();
    private static String date;
    private final SiteController siteController = new SiteController();

    @FXML
    void initialize() {

        for (ChosenQuantity q : chosenQuantities) {
            String name = siteController.getSiteById(q.getSiteId()).getName();
            confirmSites.add(new ConfirmSite(name, q.getDeliveryType(), q.getQuantity(), date));
        }

        // Chèn vào table
        insertToTable();

        // Reset stt
        ConfirmSite.setIdCounter(1);
    }

    public void insertToTable() {
        stt.setCellValueFactory(new PropertyValueFactory<ConfirmSite, Integer>("id"));
        siteName.setCellValueFactory(new PropertyValueFactory<ConfirmSite, String>("name"));
        delivery.setCellValueFactory(new PropertyValueFactory<ConfirmSite, String>("deliveryType")); // Đặt lại tên thuộc tính
        quantity.setCellValueFactory(new PropertyValueFactory<ConfirmSite, Integer>("quantity")); // Đặt lại tên thuộc tính
        takeDate.setCellValueFactory(new PropertyValueFactory<ConfirmSite, String>("expectedDate"));
        chosenSiteTable.setItems(confirmSites);
    }

    public static void setChosenQuantities(ArrayList<ChosenQuantity> chosenQuantities) {
        MOConfirmSiteController.chosenQuantities = chosenQuantities;
    }

    public static void setDate(String date) {
        MOConfirmSiteController.date = date;
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
    void confirm(ActionEvent event) {

    }
}
