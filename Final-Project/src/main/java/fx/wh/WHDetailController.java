package fx.wh;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import model.subsytem.SiteOrderSystem;
import model.subsytem.StorageSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class WHDetailController {

    @FXML private Button cancelBtn;
    @FXML private Button changeQuantity;
    @FXML private Label deBy;
    @FXML private Button makeOrderBtn;
    @FXML private Label note;
    @FXML private Label orderId;
    @FXML private Label orderQuantity;
    @FXML private Label orderUnit;
    @FXML private Label price;
    @FXML private Label productName;
    @FXML private Label requestId;
    @FXML private Label status;

    private int productId;
    private int quantity;
    private int siteOrderId;
    private WHListController whListController;

    public void setWHListController(WHListController whListController) {
        this.whListController = whListController;
    }

    private WHListController getWHListController() {
        return whListController;
    }

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
        StorageSystem storageSystem = new StorageSystem();
        storageSystem.updateQuantity(productId, quantity);

        // Cập nhật trạng thái của SiteOrder
        SiteOrderSystem siteOrderSystem = new SiteOrderSystem();
        siteOrderSystem.updateStatus(siteOrderId, "Đã nhập kho");

        // Sau đó đóng cửa sổ popup
        Stage stage = (Stage) makeOrderBtn.getScene().getWindow();
        stage.close();

        // Làm mới bảng
        refreshTableInListController();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                showSuccessPopup();
                timer.cancel(); // Hủy lịch trình sau khi hoàn thành
            }
        }, 2000);
    }

    // Thêm phương thức để làm mới bảng trong WHListController
    private void refreshTableInListController() {
        // Giả sử bạn có tham chiếu tới WHListController từ WHDetailController
        WHListController whListController = getWHListController();
        if (whListController != null) {
            whListController.refreshTable();
        }
    }

    private void showSuccessPopup() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/popUp/successPopup.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Phương thức để thiết lập dữ liệu cho các Label từ bên ngoài controller
    public void setData(String requestId, String status, String productName, int orderQuantity, String orderUnit,
                        String orderId, String deBy, String price, String note, int productId, int siteOrderId) {
        this.requestId.setText(requestId);
        this.status.setText(status);
        this.productName.setText(productName);
        this.orderQuantity.setText(String.valueOf(orderQuantity));
        this.orderUnit.setText(orderUnit);
        this.orderId.setText(orderId);
        this.deBy.setText(deBy);
        this.price.setText(price);
        this.note.setText(note);
        this.productId = productId;
        this.quantity = orderQuantity;
        this.siteOrderId = siteOrderId; // Lưu id của SiteOrder để sử dụng khi cập nhật trạng thái
    }
}
