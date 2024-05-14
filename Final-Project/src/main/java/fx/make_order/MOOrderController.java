package fx.make_order;

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
import javafx.scene.layout.HBox;
import model.ChosenSite;
import model.Order;
import model.Site;
import model.SiteProduct;

import java.util.ArrayList;
import java.util.List;

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
    private TableColumn<ChosenSite, HBox> numberInput;

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
        viewAllTable(table, sites);
    }

    SiteProduct siteProduct1 = new SiteProduct(1, "Tivi", 100, 35);
    SiteProduct siteProduct2 = new SiteProduct(2, "Tủ lạnh", 400, 174);
    SiteProduct siteProduct3 = new SiteProduct(3, "Điện thoại Oppo", 1234, 350);
    SiteProduct siteProduct4 = new SiteProduct(4, "Dép", 12000, 3999);
    SiteProduct siteProduct5 = new SiteProduct(5, "Áo Jack", 5000000, 0);

    List<SiteProduct> siteProducts1 = new ArrayList<>();
    List<SiteProduct> siteProducts2 = new ArrayList<>();
    List<SiteProduct> siteProducts3 = new ArrayList<>();
    List<SiteProduct> siteProducts4 = new ArrayList<>();
    List<SiteProduct> siteProducts5 = new ArrayList<>();

    Order order = new Order(6, 6, 30, "chiếc", "12/05/2024", "Chưa tạo", "Áo Jack", "Day la not cua order");

    ObservableList<ChosenSite> sites = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        siteProducts1.add(siteProduct1);
        siteProducts1.add(siteProduct2);
        siteProducts1.add(siteProduct3);

        siteProducts2.add(siteProduct2);
        siteProducts2.add(siteProduct5);

        siteProducts3.add(siteProduct3);
        siteProducts3.add(siteProduct4);
        siteProducts3.add(siteProduct5);

        siteProducts4.add(siteProduct4);
        siteProducts4.add(siteProduct2);

        siteProducts5.add(siteProduct5);

        ObservableList<Site> oldSites = FXCollections.observableArrayList(
                new Site(1, "Site mot", 5, 2, siteProducts1),
                new Site(2, "Site hai", 7, 4, siteProducts2),
                new Site(3, "Site ba", 5, 1, siteProducts3),
                new Site(4, "Site bon", 9, 1, siteProducts4),
                new Site(5, "Site nam", 5, 2, siteProducts5),
                new Site(6, "Site sau", 12, 2, siteProducts2),
                new Site(7, "Site bay", 5, 2, siteProducts5),
                new Site(8, "Site tam", 6, 2, siteProducts3),
                new Site(9, "Site chin", 5, 2, siteProducts1),
                new Site(10, "Site muoi", 3, 2, siteProducts4),
                new Site(11, "Site muoi mot", 5, 2, siteProducts2),
                new Site(12, "Site muoi hai", 4, 2, siteProducts5)
        );

        int i = 1;
        for (Site site : oldSites) {
            for (SiteProduct siteProduct : site.getProducts()) {
                if (siteProduct.getProduct_name().equals(order.getProduct_name())){
                    ChosenSite chosensite = new ChosenSite(i, site.getName(), siteProduct.getQuantity(), order.getUnit(), site.getShip_date(), site.getAir_date(), siteProduct.getSold_quantity());
                    sites.add(chosensite);
                    break;
                }
            }
        }

        // Set breadcrumbs
        setBreadcrumb(3);

        // Table
        startTable(table, sites);

        // Preview card
        productName.setText(order.getProduct_name());
        makeAppearPreviewCard(table);
    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        siteName.setCellValueFactory(new PropertyValueFactory<>("name"));
        siteQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        shipDate.setCellValueFactory(new PropertyValueFactory<>("ship_date"));
        airDate.setCellValueFactory(new PropertyValueFactory<>("air_date"));
        numberInput.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(sites);
    }

    @Override
    public void insertToPreviewCard(ChosenSite site) {
       siteNameCard.setText(site.getName());
       soldQuantity.setText(String.valueOf(site.getSold_quantity()));
       orderUnit.setText(order.getUnit());
       cardNumberInput.setText("10");
    }

}
