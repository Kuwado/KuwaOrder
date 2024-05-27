package fx.sidebar;

import fx.LoginController;
import fx.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class siteOrderListSidebarController {
    @FXML
    void siteOrderPressed(ActionEvent event) {
        changeUC(event, "/view/content/order/VOsiteOrder.fxml");

    }

    @FXML
    void siteProductPressed(ActionEvent event) {
        changeUC(event, "/view/content/site/ViewSiteProduct.fxml");
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
