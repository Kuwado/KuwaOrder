package fx.makeorder;

import fx.FXController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.*;
import model.tabledata.MOOrder;

import java.util.Arrays;
import java.util.List;

public class MORequestController extends FXController<MOOrder> {

    // Data Product
    Product product1 = new Product(1, "Tivi", "Tivi thì để sờ em chứ còn làm gì", "../images/products/1-tivi.jpg", "Điện máy");
    Product product2 = new Product(2, "Tủ lạnh", "Trời nóng thì vào nằm cho mát", "../images/products/2-tulanh.jpg", "Điện máy");
    Product product3 = new Product(3, "Máy giặt", "Nhân cách bẩn quá thì vào để reset", "../images/products/3-maygiat.png", "Điện máy");
    Product product4 = new Product(4, "Máy hút bụi", "Dùng nhiều không biết nhà có sạch không nhưng ít ra nó đỡ bẩn hơn không dùng", "../images/products/4-mayhutbui.jpg", "Điện máy");
    Product product5 = new Product(5, "Laptop", "Phương tiện đưa bạn lên thách đấu", "../images/products/5-laptop.jpg", "Công nghệ");
    Product product6 = new Product(6, "Iphone", "Không phải Android", "../images/products/6-iphone.png", "Công nghệ");
    Product product7 = new Product(7, "Lò nướng", "Khoai nướng siêu ngon, đảm bảo nương khoái", "../images/products/7-lonuong.jpg", "Điện máy");
    Product product8 = new Product(8, "Kẹo mút", "Mút mút mút", "../images/products/8-keomut.jpg", "Thực phẩm");
    Product product9 = new Product(9, "Nước ngọt", "Uống kèm với thuốc cho đỡ đắng", "../images/products/9-nuocngot.jpg", "Thực phẩm");
    Product product10 = new Product(10, "Tai nghe", "Đm tai không để nghe thì để làm mịa gì", "../images/products/10-tainghe.jpg", "Công nghệ");
    Product product11 = new Product(11, "Chuột mickey", "Để bắt Doraemon", "../images/products/11-chuotkhongday.jpg", "Công nghệ");
    Product product12 = new Product(12, "Cái nịt", ":)", "../images/products/12-cainit.jpg", "Vật phẩm quý hiếm");

    // Data List Product
    List<Product> products1 = Arrays.asList(product1, product2, product3, product4, product7);
    List<Product> products2 = Arrays.asList(product5, product6, product10, product11);
    List<Product> products3 = Arrays.asList(product8, product9, product12);

    // Data SiteProduct
    List<SiteProduct> siteproducts1 = Arrays.asList(
            new SiteProduct(product1, 15000000, 120, 15),
            new SiteProduct(product2, 12000000, 100, 8),
            new SiteProduct(product3, 14500000, 235, 100),
            new SiteProduct(product4, 8000000, 1358, 155),
            new SiteProduct(product7, 7500000, 201, 102)
    );
    List<SiteProduct> siteproducts2 = Arrays.asList(
            new SiteProduct(product5, 25000000, 120, 15),
            new SiteProduct(product6, 30000000, 100, 8),
            new SiteProduct(product10, 1500000, 235, 100),
            new SiteProduct(product11, 800000, 1358, 155)
    );
    List<SiteProduct> siteproducts3 = Arrays.asList(
            new SiteProduct(product8, 1000, 12000, 1523),
            new SiteProduct(product9, 10000, 12345, 812),
            new SiteProduct(product12, 999999999, 1, 0)
    );

    // Data Site
    Site site1 = new Site(1, "Site 01", 5, 3, 1000000, 2500000, siteproducts1, "Site tao bao xịn");
    Site site5 = new Site(5, "Site 05", 3, 2, 1200000, 3600000, siteproducts1, "Chất lượng là số 1, nhưng site tao không có số 1");
    Site site8 = new Site(8, "Site 08", 2, 1, 1500000, 4200000, siteproducts1, "Site tao đươc cái giá đắt nhưng mà sản phẩm cũng kém chất lượng");
    Site site10 = new Site(10, "Site 10", 6, 4, 900000, 2000000, siteproducts1, "Site sight size side sai");

    Site site2 = new Site(2, "Site 02", 4, 2, 1100000, 3200000, siteproducts2, "Site tao bao xịn" );
    Site site3 = new Site(3, "Site 03", 4, 3, 1000000, 3000000, siteproducts2, "Site tao bao xịn" );
    Site site12 = new Site(12, "Site 12", 3, 2, 1300000, 3800000, siteproducts2, "Site tao bao xịn" );
    Site site6 = new Site(6, "Site 06", 2, 1, 1600000, 4500000, siteproducts2, "Site tao bao xịn" );

    Site site4 = new Site(4, "Site 04", 5, 3, 1000000, 3500000, siteproducts3, "Site tao bao xịn" );
    Site site7 = new Site(7, "Site 07", 3, 2, 1500000, 4200000, siteproducts3, "Site tao bao xịn" );
    Site site9 = new Site(9, "Site 09", 5, 2, 1200000, 4000000, siteproducts3, "Site tao bao xịn" );
    Site site11 = new Site(11, "Site 11", 4, 1, 1400000, 5000000, siteproducts3, "Site tao bao xịn" );

    // Data Order
    Order order1 = new Order(1, product1, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua tivi");
    Order order2 = new Order(2, product2, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua tủ lạnh");
    Order order3 = new Order(3, product3, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua máy giặt");
    Order order4 = new Order(4, product4, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua máy hút bụi");
    Order order5 = new Order(5, product5, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua laptop");
    Order order6 = new Order(6, product6, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua iphone");
    Order order7 = new Order(7, product7, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua lò nướng");
    Order order8 = new Order(8, product8, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua kẹo mút");
    Order order9 = new Order(9, product9, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua nước ngọt");
    Order order10 = new Order(10, product10, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua tai nghe");
    Order order11 = new Order(11, product11, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua chuột");
    Order order12 = new Order(12, product12, 300, "Cái", "23/05/2024", "Chưa tạo", "Mua nịt");

    // Data OrderList
    List<Order> orders1 = Arrays.asList(order1, order5, order12, order3);
    List<Order> orders2 = Arrays.asList(order4, order6, order7, order10);
    List<Order> orders3 = Arrays.asList(order2, order8, order9, order11);

    // Data Request
    Request request1 = new Request(1, "Dat hang 1", "20/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request2 = new Request(2, "Dat hang 2",  "21/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request3 = new Request(3, "Dat hang 3",  "20/05/2024", "Doing", orders3, "Hau quá");
    Request request4 = new Request(4, "Dat hang 4",  "20/05/2024", "Doing", orders2, "kakaka");
    Request request5 = new Request(10, "Dat hang 10",  "12/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request6 = new Request(12, "Dat hang 12",  "11/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request7 = new Request(9, "Dat hang 9",  "10/05/2024", "Doing", orders3, "Hau quá");
    Request request8 = new Request(11, "Dat hang 11",  "12/05/2024", "Doing", orders1, "kakaka");
    Request request9 = new Request(8, "Dat hang 8", "12/05/2024", "Doing", orders1, "Mô tả công việc");
    Request request10 = new Request(7, "Dat hang 7",  "11/05/2024", "Doing", orders2, "Chọn Site xịn xịn nhé");
    Request request11 = new Request(6, "Dat hang 6",  "10/05/2024", "Doing", orders3, "Hau quá");
    Request request12 = new Request(5, "Dat hang 5",  "12/05/2024", "Doing", orders3, "kakaka");

    List<Request> requests = Arrays.asList(request1, request2, request3, request4, request5, request6, request7, request8, request9, request10, request11, request12);

    @FXML
    private TableView<MOOrder> table;

    @FXML
    private TableColumn<MOOrder, Integer> id;

    @FXML
    private TableColumn<MOOrder, String> productName;

    @FXML
    private TableColumn<MOOrder, Integer> quantity;

    @FXML
    private TableColumn<MOOrder, String> unit;

    @FXML
    private TableColumn<MOOrder, String> expired_date;

    @FXML
    private TableColumn<MOOrder, String> status;

    @FXML
    private TableColumn<MOOrder, HBox> action;

    @FXML
    private Label requestName;

    @FXML
    private Label orderName;

    @FXML
    private TextArea orderNote;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Label orderExpiredDate;

    @FXML
    private Button quickMakeOrderBtn;

    @FXML
    void viewAll(ActionEvent event) {
        viewAllTable(table, moOrders);
    }

    private static Request request;
    private final ObservableList<MOOrder> moOrders = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        //request = request1;
        for (Order o : request.getOrders()) {
            moOrders.add(new MOOrder(o));
        }

        // Set breadcrumbs
        setBreadcrumb(3, "/view/parts/breadcrumbs/MakeOrder.fxml");

        // Table
        number = 9;
        startTable(table, moOrders);

        // Preview card
        requestName.setText(request.getName());
        makeAppearPreviewCard(table);
    }

    public static void setRequest(Request request) {
        MORequestController.request = request;
    }

    @Override
    public void insertToTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        expired_date.setCellValueFactory(new PropertyValueFactory<>("desiredDate"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(moOrders);
    }

    @Override
    public void insertToPreviewCard(MOOrder order) {
        orderNote.setText(order.getOrder().getNote() != null ? order.getOrder().getNote() : "Không có");
        orderName.setText(order.getProductName());
        orderQuantity.setText(String.valueOf(order.getQuantity()));
        orderUnit.setText(order.getUnit());
        orderExpiredDate.setText(order.getDesiredDate());
    }

}
