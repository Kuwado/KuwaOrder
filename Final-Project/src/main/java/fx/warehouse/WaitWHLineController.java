package fx.warehouse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.tabledata.LamTestOrder;

public class WaitWHLineController {

    @FXML
    private VBox breadcrumb;

    @FXML
    private Label labelMaDonHang;

    @FXML
    private Label labelSite;

    @FXML
    private Label labelNgayNhanHang;

    @FXML
    private Label labelTrangThai;

    private LamTestOrder lamTestOrder;

    // Constructor để truyền dữ liệu LamTestOrder vào controller


    @FXML
    void initialize() {
        // Hiển thị thông tin của đơn hàng trên giao diện
        labelMaDonHang.setText(lamTestOrder.getMaDonHang());
        labelSite.setText(lamTestOrder.getSite());
        labelNgayNhanHang.setText(lamTestOrder.getNgayNhanHang());
        labelTrangThai.setText(lamTestOrder.getTrangThai());
    }

}
