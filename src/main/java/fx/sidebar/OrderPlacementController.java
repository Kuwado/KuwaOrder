package fx.sidebar;

import fx.LoginController;
import fx.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderPlacementController {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    private List<Button> btns;
    public static int activeIndex = 0;

    @FXML
    void initialize(){
        btns = List.of(btn1, btn2, btn3, btn4, btn5);
        btns.get(activeIndex).getStyleClass().add("sidebar-active");
    }

    @FXML
    void backHome(ActionEvent event) {
        activeIndex = 0;
        changeUC(event, "/view/parts/sidebar/OrderPlacementHome.fxml");
    }

    @FXML
    void viewSiteOrder(ActionEvent event) {
        activeIndex = 2;
        changeUC(event, "/view/content/order/VOorderList.fxml");
    }

    @FXML
    void makeOder(ActionEvent event) {
        activeIndex = 3;
        changeUC(event, "/view/content/makeorder/MORequestList.fxml");
    }


    @FXML
    void cancelOrder(ActionEvent event) {
        activeIndex = 4;
        changeUC(event, "/view/content/sale/HandleCancelSiteOrder.fxml");
    }

    private void changeUC(ActionEvent event, String path) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            MainController mc = new MainController();
            mc.setContentPath(path);
            mc.setSidebarPath(LoginController.sidebarPath);
            mc.setAvatarPath(LoginController.imagePath);
            fxmlLoader.setController(mc);
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
            stage.setTitle("KuwaOrder");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
