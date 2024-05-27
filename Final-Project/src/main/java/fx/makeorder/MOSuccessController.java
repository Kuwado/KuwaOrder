package fx.makeorder;

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



public class MOSuccessController {

    private static Stage stageOrder;

    public static void setStageOrder(Stage stageOrder) {
        MOSuccessController.stageOrder = stageOrder;
    }

    @FXML
    void confirm(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            MainController mc = new MainController();
            mc.setContentPath("/view/content/makeorder/MORequest.fxml");
            mc.setSidebarPath(LoginController.sidebarPath);
            mc.setAvatarPath(LoginController.imagePath);
            fxmlLoader.setController(mc);
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
            stageOrder.setTitle("KuwaOrder");
            stageOrder.setScene(scene);
            stageOrder.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
