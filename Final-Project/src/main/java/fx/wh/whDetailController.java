package fx.wh;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class whDetailController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button changeQuantity;

    @FXML
    private Label deBy;

    @FXML
    private Button makeOrderBtn;

    @FXML
    private Label note;

    @FXML
    private Label orderId;

    @FXML
    private Label orderQuantity;

    @FXML
    private Label orderUnit;

    @FXML
    private Label price;

    @FXML
    private Label productName;

    @FXML
    private Label requestId;

    @FXML
    private Label status;



    @FXML
    public void initialize() {


        // Thêm sự kiện cho các nút
        cancelBtn.setOnAction(event -> handleCancel());
        makeOrderBtn.setOnAction(event -> handleMakeOrder());
    }

    private void handleCancel() {
        // Xử lý sự kiện khi nhấn nút "Quay Lại"
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    private void handleMakeOrder() {
        // Xử lý sự kiện khi nhấn nút "Nhập Kho"
        System.out.println("Nhập kho thành công!");
        // Thực hiện các hành động khác liên quan đến nhập kho
        // Sau đó đóng cửa sổ popup
        Stage stage = (Stage) makeOrderBtn.getScene().getWindow();
        stage.close();
    }

    // Phương thức để thiết lập dữ liệu cho các Label từ bên ngoài controller
    public void setData(String requestId, String status, String productName, int orderQuantity, String orderUnit,
                        String orderId, String deBy, String price, String note) {
        this.requestId.setText(requestId);
        this.status.setText(status);
        this.productName.setText(productName);
        this.orderQuantity.setText(String.valueOf(orderQuantity));
        this.orderUnit.setText(orderUnit);
        this.orderId.setText(orderId);
        this.deBy.setText(deBy);
        this.price.setText(price);
        this.note.setText(note);
    }
}
