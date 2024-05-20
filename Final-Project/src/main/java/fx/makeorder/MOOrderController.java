package fx.makeorder;

import controller.ProductController;
import controller.SiteController;
import controller.SiteProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import model.tabledata.ChosenQuantity;
import model.tabledata.ChosenSite;
import model.SiteProduct;
import model.tabledata.ConfirmSite;
import model.tabledata.MOOrder;
import solution.DateConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class MOOrderController extends MOController<ChosenSite> {
    @FXML
    private TableView<ChosenSite> table;

    @FXML
    private TableColumn<ChosenSite, Integer> id;

    @FXML
    private TableColumn<ChosenSite, String> siteName;

    @FXML
    private TableColumn<ChosenSite, Integer> siteQuantity;

    @FXML
    private TableColumn<ChosenSite, String> unit;

    @FXML
    private TableColumn<ChosenSite, Integer> shipDate;

    @FXML
    private TableColumn<ChosenSite, Integer> airDate;

    @FXML
    private TableColumn<ChosenSite, String> numberInput;

    @FXML
    private Label productName;

    @FXML
    private Label siteNameCard;

    @FXML
    private Label soldQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Button shipBtn;

    @FXML
    private Button airBtn;

    @FXML
    private TextField cardNumberInput;

    @FXML
    private Label airPrice;

    @FXML
    private Label shipPrice;

    @FXML
    private Label slcm;

    @FXML
    private Label slcc;

    @FXML
    private Button makeOrderBtn;

    @FXML
    void viewAll(ActionEvent event) {
        viewAllTable(table, chosenSites);
    }

    private static Order order;
    private static boolean backStt = false;
    private final SiteController siteController = new SiteController();
    private final ProductController productController = new ProductController();
    private final SiteProductController siteProductController = new SiteProductController();
    private ArrayList<ChosenQuantity> chosenQuantities = new ArrayList<>();
    private ObservableList<ChosenSite> chosenSites = FXCollections.observableArrayList();
    private int needQuantity = order.getQuantity();
    private boolean sttQuantity;
    private int date = DateConverter.roundedDaysDifferenceFromToday(order.getDesiredDate());

    @FXML
    void initialize() {

        // Load dữ liệu
        ArrayList<ChosenQuantity> siteProducts = siteProductController.getSiteToMakeOrder(order.getProductId(), date);
        ArrayList<Site> sites = siteProductController.getSitesFromSiteProduct(order.getProductId());
        Product product = productController.getProductById(order.getProductId());

        // Thêm input vào data table
        for (ChosenQuantity sp : siteProducts) {
            TextField tf = new TextField();
            tf.getStyleClass().add("number-input");
            Site site = siteController.getSiteById(sp.getSiteId());
            chosenSites.add(new ChosenSite(order, product, site, sp, tf));
        }

        // Set breadcrumbs
        setBreadcrumb(4, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Table
        startTable(table, chosenSites);

        // Preview card
        cardNumberInput.setEditable(false);
        slcm.setText(String.valueOf(order.getQuantity()));
        slcc.setText(String.valueOf(order.getQuantity()));
        productName.setText(productController.getProductById(order.getProductId()).getName());
        insertDataToChosenQuantities();
        makeAppearPreviewCard(table);

        // Reset stt
        ChosenSite.setIdCounter(1);
        if (backStt) {
            backStt = false;
            ActionEvent event = new ActionEvent();
            ChosenSite cs = null;
            viewRequestDetail(cs, event,"/view/content/makeorder/MORequest.fxml");
        }
    }

    public static void setOrder(Order order) {
        MOOrderController.order = order;
    }

    public static void setBackStt(boolean backStt) {
        MOOrderController.backStt = backStt;
    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        siteName.setCellValueFactory(new PropertyValueFactory<>("name"));
        siteQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        shipDate.setCellValueFactory(new PropertyValueFactory<>("shipDate"));
        airDate.setCellValueFactory(new PropertyValueFactory<>("airDate"));
        numberInput.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(chosenSites);
    }

    private void addActiveClass(Button button, String name) {
        if (!button.getStyleClass().contains(name)) {
            button.getStyleClass().add(name);
        }
    }

    @Override
    public void insertToPreviewCard(ChosenSite chosenSite) {
        Site site = chosenSite.getSite();
        Product product = chosenSite.getProduct();
        SiteProduct siteProduct = siteProductController.getSiteproductFromProductAndSite(product.getId(), site.getId());
        siteNameCard.setText(site.getName());
        soldQuantity.setText(String.valueOf(siteProduct.getSoldQuantity()));
        airPrice.setText(String.format("%,d", Math.round(site.getAirPrice())));
        shipPrice.setText(String.format("%,d", Math.round(site.getShipPrice())));
        orderUnit.setText(order.getUnit());
        cardNumberInput.setText(chosenSite.getAction().getText());
        // Setup button delivery khi chọn
        addActiveClass(shipBtn, "option-btn");
        shipBtn.getStyleClass().remove("hidden-option-btn");
        shipBtn.getStyleClass().remove("option-btn-active");
        addActiveClass(airBtn, "option-btn");
        airBtn.getStyleClass().remove("hidden-option-btn");
        airBtn.getStyleClass().remove("option-btn-active");
        // Check điều kiện các button
        if (chosenSite.getDeliveryStt() != null && chosenSite.getDeliveryStt().equals("Đường thủy")) {
            addActiveClass(shipBtn, "option-btn-active");
            airBtn.getStyleClass().remove("option-btn-active");
        }
        else if (chosenSite.getDeliveryStt() != null && chosenSite.getDeliveryStt().equals("Hàng không")) {
            addActiveClass(airBtn, "option-btn-active");
            shipBtn.getStyleClass().remove("option-btn-active");
        }

        if (chosenSite.getShipDate() > date) {
            shipBtn.getStyleClass().remove("option-btn");
            addActiveClass(shipBtn, "hidden-option-btn");
        } else {
            //Gán sự kiện nhấn cho nút Ship
            shipBtn.setOnAction(event -> {
                addActiveClass(shipBtn, "option-btn-active");
                airBtn.getStyleClass().remove("option-btn-active");
                String shipDeli = "Đường thủy";
                chosenSite.setDeliveryStt(shipDeli);
                updateChosenQuantities(new ChosenQuantity(chosenSite.getSite().getId(), changeFromTextIntoInteger(chosenSite), shipDeli, chosenSite.getSite().getShipPrice()));
            });
        }
        if (chosenSite.getAirDate() > date ) {
            airBtn.getStyleClass().remove("option-btn");
            addActiveClass(airBtn, "hidden-option-btn");
        } else {
            // Gán sự kiện nhấn cho nút Air
            airBtn.setOnAction(event -> {
                addActiveClass(airBtn, "option-btn-active");
                shipBtn.getStyleClass().remove("option-btn-active");
                String airDeli = "Hàng không";
                chosenSite.setDeliveryStt(airDeli);
                updateChosenQuantities(new ChosenQuantity(chosenSite.getSite().getId(), changeFromTextIntoInteger(chosenSite), airDeli, chosenSite.getSite().getAirPrice()));
            });
        }
    }

    private void insertDataToChosenQuantities() {
        for (ChosenSite chosenSite : chosenSites) {
            chosenSite.getAction().textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    chosenSite.getAction().setText(newValue.replaceAll("[^\\d]", ""));
                }

                if (checkQuantitySite(chosenSite)) {
                    cardNumberInput.setText(chosenSite.getAction().getText());
                    updateChosenQuantities(new ChosenQuantity(chosenSite.getSite().getId(), changeFromTextIntoInteger(chosenSite), chosenSite.getDeliveryStt(), 50));
                    if (!sttQuantity) {
                        chosenSite.getAction().deleteText(chosenSite.getAction().getLength() - 1, chosenSite.getAction().getLength());
                    }
                    slcc.setText(String.valueOf(needQuantity));
                } else {
                    quantityError2();
                    chosenSite.getAction().deleteText(chosenSite.getAction().getLength() - 1, chosenSite.getAction().getLength());
                }
            });
        }
    }

    private int changeFromTextIntoInteger(ChosenSite chosenSite) {
        String text = chosenSite.getAction().getText(); // Trim để loại bỏ khoảng trắng
        if (text.isEmpty()) {
            return 0;
        } else
            return Integer.parseInt(text);
    }

    private boolean checkQuantitySite(ChosenSite chosenSite) {
        int quan = changeFromTextIntoInteger(chosenSite);
        if (quan > chosenSite.getQuantity()) {
            return false;
        } else
            return true;
    }

    private void updateChosenQuantities(ChosenQuantity chosenQuantity) {
        Optional<ChosenQuantity> existingCq = chosenQuantities.stream()
                .filter(cq -> cq.getSiteId() == chosenQuantity.getSiteId())
                .findFirst();

        int bu = needQuantity;

        if (chosenQuantity.getChosenQuantity() > 0) {
            if (existingCq.isPresent()) {
                needQuantity = needQuantity - chosenQuantity.getChosenQuantity() + existingCq.get().getChosenQuantity();
            } else {
                needQuantity -= chosenQuantity.getChosenQuantity();
            }
        } else {
            if (existingCq.isPresent()) {
                needQuantity += existingCq.get().getChosenQuantity();
            }
        }

        if (needQuantity >= 0) {
            if (chosenQuantity.getChosenQuantity() > 0) {
                if (existingCq.isPresent()) {
                    existingCq.get().setChosenQuantity(chosenQuantity.getChosenQuantity());
                    if (chosenQuantity.getDeliveryType() != null) {
                        existingCq.get().setDeliveryType(chosenQuantity.getDeliveryType());
                        existingCq.get().setDeliveryPrice(chosenQuantity.getDeliveryPrice());
                    }
                } else {
                    chosenQuantities.add(chosenQuantity);
                }
            } else if (existingCq.isPresent()) {
                chosenQuantities.remove(existingCq.get());
            }
            sttQuantity = true;
        } else {
            quantityError();
            needQuantity = bu;
            if (existingCq.isPresent()) {
                needQuantity = bu + existingCq.get().getChosenQuantity();
                chosenQuantities.remove(existingCq.get());
            } else {
                needQuantity = bu;
            }
            sttQuantity = false;
        }
    }

    private void quantityError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Số lượng quá lớn");
        alert.setHeaderText(null);
        alert.setContentText("Số lượng bạn nhập vượt quá số lượng còn thiếu! Vui lòng nhập lại");
        alert.showAndWait();
    }

    private void quantityError2() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Số lượng quá lớn");
        alert.setHeaderText(null);
        alert.setContentText("Số lượng bạn nhập vượt quá số lượng còn trong kho của site! Vui lòng nhập lại");
        alert.showAndWait();
    }

    @FXML
    void makeSiteOrder(ActionEvent event) throws IOException {
        MOExpectedSiteOrderController.setDate(date);
        MOExpectedSiteOrderController.setOrder(order);
        MOExpectedSiteOrderController.setChosenSites(chosenQuantities);
        if (!chosenQuantities.isEmpty()) {
            MOConfirmSiteController.setChosenQuantities(chosenQuantities);
            MOConfirmSiteController.setsDate(order.getDesiredDate());
            runPopUp("/view/popUp/MOConfirmSite.fxml", 620, 450);
        } else {
            runPopUp("/view/popUp/MOExpectedSiteOrder.fxml", 620, 700);
        }
    }

    @Override
    public void setDataToTrans(ChosenSite chosenSite) {
    }

    public static void runPopUp(String path, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(MOOrderController.class.getResource(path));
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        BorderPane pane = loader.load();

        // Lấy kích thước của màn hình
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();


        // Tính toán vị trí để pop-up được hiển thị chính giữa màn hình
        double popupX = (screenWidth - width) / 2;
        double popupY = (screenHeight - height) / 2;

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(Objects.requireNonNull(MOOrderController.class.getResource("/css/styles.css")).toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(MOOrderController.class.getResource("/css/makeOrder.css")).toExternalForm());
        primaryStage.setScene(scene);

        // Đặt vị trí cho pop-up
        primaryStage.setX(popupX);
        primaryStage.setY(popupY);

        primaryStage.show();
    }



}
