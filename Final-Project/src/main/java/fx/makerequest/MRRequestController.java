package fx.makerequest;

import controller.OrderController;
import controller.ProductController;
import controller.RequestController;
import fx.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Request;
import model.tabledata.MROrder;
import model.Product;
import model.Order;
import solution.DateConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MRRequestController extends MRMOController<MROrder> {

    @FXML
    private HBox breadcrumb;

    @FXML
    private TableColumn<MROrder, String> desired_date;

    @FXML
    private TableColumn<MROrder, Integer> id;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Label orderName;

    @FXML
    private TextArea orderNote;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private AnchorPane previewCard;

    @FXML
    private VBox previewContent;

    @FXML
    private TableColumn<MROrder, Integer> productID;

    @FXML
    private TableColumn<MROrder, String> productName;

    @FXML
    private TableColumn<MROrder, Integer> quantity;

    @FXML
    private Button chooseProductBtn;

    @FXML
    private Button makeOrderBtn;

    @FXML
    private TableView<MROrder> table;

    @FXML
    private TableColumn<MROrder, String> unit;

    @FXML
    private TextField requestName;

    @FXML
    private TextArea requestDes;

    @FXML
    void chooseProduct(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MRChooseProductController.setStage(stage);
        if (orders != null) {
            MRChooseProductController.setOrders(orders);
        } else {
            MRChooseProductController.setOrders(new ArrayList<>());
        }
        runPopUp("view/content/makerequest/MRChooseProduct.fxml", 1250, 700);
    }

    private final ObservableList<MROrder> mrOrders = FXCollections.observableArrayList();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();
    private final RequestController requestController = new RequestController();
    private static ArrayList<Order> orders;

    public static void setOrders(ArrayList<Order> orders) {
        MRRequestController.orders = orders;
    }

    @FXML
    void initialize() {
        orderNote.setEditable(false);
        if (orders != null) {
            for (Order o : orders) {
                mrOrders.add(new MROrder(productController.getProductById(o.getProductId()), o));
            }
        }

        setBreadcrumb(1, "/view/parts/breadcrumbs/MRbreadcrumb.fxml");
        insertToTable();
        makeAppearPreviewCard(table);

    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        desired_date.setCellValueFactory(new PropertyValueFactory<>("desired_date"));
        table.setItems(mrOrders);
    }

    @Override
    public void setDataToTrans(MROrder confirmSite) {

    }

    @Override
    public void insertToPreviewCard(MROrder mrOrder) {
        Order order = mrOrder.getOrder();
        orderNote.setText(order.getNote() != null ? order.getNote() : "Không có");
        orderName.setText(productController.getProductById(order.getProductId()).getName());
        orderQuantity.setText(String.valueOf(order.getQuantity()));
        orderUnit.setText(order.getUnit());
        orderExpiredDate.setText(order.getDesiredDate());
    }

    private void runPopUp(String path, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/content/makerequest/MRChooseProduct.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        HBox pane = loader.load();

        // Lấy kích thước của màn hình
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();


        // Tính toán vị trí để pop-up được hiển thị chính giữa màn hình
        double popupX = (screenWidth - width) / 2;
        double popupY = (screenHeight - height) / 2;

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        primaryStage.setScene(scene);

        // Đặt vị trí cho pop-up
        primaryStage.setX(popupX);
        primaryStage.setY(popupY);

        primaryStage.show();
    };

    @FXML
    void makeRequest(ActionEvent event) throws IOException {
        Request request = new Request(requestName.getText(), requestDes.getText());
        requestController.insert(request);
        request = requestController.getLastRequest();
        for (Order o : orders) {
            Order od = new Order(o.getProductId(), o.getQuantity(), DateConverter.convertDateFormat2(o.getDesiredDate()), o.getNote(), request.getId());
            orderController.insert(od);
        }

        orders = new ArrayList<>();

        Node source = (Node) event.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();
        MainController mc = new MainController();
        mc.setSidebarPath("/view/parts/sidebar/MRsidebar.fxml");
        mc.setContentPath("/view/content/makerequest/MakeRequest.fxml");
        mc.setAvatarPath("/images/avatar.jpg");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        fxmlLoader.setController(mc);
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();

    }
}