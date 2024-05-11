import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Đọc file fxml và vẽ giao diện.
            Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));

            primaryStage.setTitle("My Application");

            // Tạo Scene với root và đặt full screen
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true); // Đặt cửa sổ vào chế độ full screen
            primaryStage.setFullScreenExitHint(""); // Xóa thông báo chế độ full screen khi thoát

            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
