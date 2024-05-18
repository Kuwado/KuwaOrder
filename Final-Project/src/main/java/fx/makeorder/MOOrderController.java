package fx.makeorder;

import controller.ProductController;
import controller.SiteController;
import controller.SiteProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import model.*;
import model.tabledata.ChosenSite;
import model.SiteProduct;

import java.util.ArrayList;

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
    private Button makeOrderBtn;

    @FXML
    private Button viewAll;

    @FXML
    void viewAll(ActionEvent event) {
        viewAllTable(table, chosenSites);
    }

    private static Order order;
    private final SiteController siteController = new SiteController();
    private final ProductController productController = new ProductController();
    private final SiteProductController siteProductController = new SiteProductController();
    private ObservableList<ChosenSite> chosenSites = FXCollections.observableArrayList();



    @FXML
    void initialize() {
        ArrayList<SiteProduct> siteProducts = siteProductController.getSiteproductsByProduct(order.getProductId());
        ArrayList<Site> sites = siteProductController.getSitesFromSiteProduct(order.getProductId());
        Product product = productController.getProductById(order.getProductId());

        for (SiteProduct sp : siteProducts) {
            TextField tf = new TextField();
            tf.getStyleClass().add("number-input");
            tf.setId("tfInput");

            Site site = siteController.getSiteById(sp.getSiteId());
            chosenSites.add(new ChosenSite(order, product, site, sp, tf));
        }

        // Set breadcrumbs
        setBreadcrumb(4, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Table
        number = 9;
        startTable(table, chosenSites);

        // Preview card
        productName.setText(productController.getProductById(order.getProductId()).getName());
        makeAppearPreviewCard(table);
    }

    @Override
    public void setDataToTrans(ChosenSite chosenSite) {

    }

    public static void setOrder(Order order) {
        MOOrderController.order = order;
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

    @Override
    public void insertToPreviewCard(ChosenSite chosenSite) {
        Site site = chosenSite.getSite();
        Product product = chosenSite.getProduct();
        SiteProduct siteProduct = siteProductController.getSiteproductFromProductAndSite(product.getId(), site.getId());
        siteNameCard.setText(site.getName());
        soldQuantity.setText(String.valueOf(siteProduct.getSoldQuantity()));
        orderUnit.setText(order.getUnit());
        cardNumberInput.setText(chosenSite.getAction().getText());
    }

}
