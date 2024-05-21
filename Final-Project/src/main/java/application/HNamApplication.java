package application;

import fx.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HNamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainController mc = new MainController();
        mc.setAvatarPath("/images/whUserAvartar.jpg");
        mc.setSidebarPath("/view/parts/sidebar/siteOrderList.fxml");
        mc.setContentPath("/view/content/order/siteOrder.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        fxmlLoader.setController(mc);
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/siteOrder.css")).toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
