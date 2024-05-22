package fx.makerequest;

import controller.ProductController;
import fx.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Order;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MRChooseProductController {

    @FXML
    private Button actionBtn;

    @FXML
    private DatePicker date;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private TextArea noteInput;

    @FXML
    private VBox previewContent;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField quantityInput;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchInput;

    @FXML
    void makeOrder(ActionEvent event) {
        int quantity = Integer.parseInt(quantityInput.getText());
        String dateString = date.getValue().toString();
        String note = noteInput.getText();
        Order order = new Order(product.getId(), quantity, dateString, note);
        orders.add(order);
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        if (orders != null) {
            MRRequestController.setOrders(orders);
        } else {
            MRRequestController.setOrders(new ArrayList<>());
        }
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
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void setChosenProduct(Product product) {
        boolean exist = false;
        for (Order order : orders) {
            if (product.getId() == order.getProductId()) {
                previewContent.setVisible(false);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Đã chọn");
                alert.setHeaderText(null);
                alert.setContentText("Sản phẩm này bạn đã chọn");
                alert.showAndWait();
                exist = true;
                break;
            }
        }
        if(!exist) {
            previewContent.setVisible(true);
            name.setText(product.getName());
            Image imageProduct = new Image(getClass().getResourceAsStream(product.getImage()));
            image.setImage(imageProduct);
        }
    }

    private static Stage stage;
    private final ProductController productController = new ProductController();
    private Product product;
    private static ArrayList<Order> orders = new ArrayList<>();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private MRMyListener myListener;

    @FXML
    void initialize() {
        ArrayList<Product> productList = productController.getAllProducts();
        previewContent.setVisible(false);
        myListener = new MRMyListener() {
            @Override
            public void onClickListener(Product p) {
                setChosenProduct(p);
                product = p;
            }
        };
        int column = 0;
        int row = 1;
        try {
            for (Product product : productList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/content/makerequest/ProductCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                MRProductCardController controller = fxmlLoader.getController();
                controller.setProduct(product, myListener);

                if (column == 4) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row); //(child,column,row)
                //set productList width
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_PREF_SIZE);

                //set productList height
                gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setStage(Stage stage) {
        MRChooseProductController.stage = stage;
    }

    public static void setOrders(ArrayList<Order> orders) {
        MRChooseProductController.orders = orders;
    }
}


