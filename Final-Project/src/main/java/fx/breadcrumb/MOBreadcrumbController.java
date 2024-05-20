package fx.breadcrumb;

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
import java.util.Objects;

public class MOBreadcrumbController extends BreadcrumbController {
    public static int number;

    public MOBreadcrumbController() {
    }
    
    @FXML
    private Button order;

    @FXML
    private Button request;

    @FXML
    private Button requestList;

    @FXML
    void initialize() {
        updateBreadcrumb(number);
    }

    @FXML
    void order(ActionEvent event) {
        changeScene(event,"/view/content/makeorder/MOOrder.fxml");
    }

    @FXML
    void request(ActionEvent event) {
        changeScene(event,"/view/content/makeorder/MORequest.fxml");
    }

    @FXML
    void requestList(ActionEvent event) {
        changeScene(event,"/view/content/makeorder/MORequestList.fxml");
    }

    private void changeScene(ActionEvent event, String path) {
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
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/makeOrder.css")).toExternalForm());
            stage.setTitle("KuwaOrder");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
