package fx.makerequest;

import controller.OrderController;
import controller.ProductController;
import fx.makeorder.MOController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.tabledata.MROrder;
import model.Product;
import model.Order;

public class MakeRequestController extends MOController<MROrder> {

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
    private Button makeOrderBtn;

    @FXML
    private TableView<MROrder> table;

    @FXML
    private TableColumn<MROrder, String> unit;

    private final ObservableList<MROrder> mrOrders = FXCollections.observableArrayList();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();
    @FXML
    void initialize() {
        orderNote.setEditable(false);
        Product product1 = productController.getProductById(3);
        Order order1 = orderController.getOrderById(1);
        mrOrders.add(new MROrder(product1, order1));
        mrOrders.add(new MROrder(product1, order1));
        mrOrders.add(new MROrder(product1, order1));
        mrOrders.add(new MROrder(product1, order1));
        mrOrders.add(new MROrder(product1, order1));

        setBreadcrumb(1, "/view/content/makerequest/MRbreadcrumb.fxml");
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

}