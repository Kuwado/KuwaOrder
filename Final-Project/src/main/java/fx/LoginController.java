package fx;

import controller.UserController;
import fx.sidebar.OrderPlacementController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField userInput;

    public static String sidebarPath;
    public String contentPath;
    public static String imagePath;
    private User user;
    private final UserController userController = new UserController();

    @FXML
    public void initialize() {

    }

    @FXML
    private void login() {
        String email = userInput.getText();
        String password = passwordInput.getText();
        user = userController.getUserByEmailAndPassword(email, password);
         if (user != null) {
             imagePath = user.getImage();
             switch (user.getType()) {
                 case "op":
                     sidebarPath = "/view/parts/sidebar/OrderPlacement.fxml";
                     contentPath = "/view/content/makeorder/MORequestList.fxml";
                     break;
                 case "wh":
                     sidebarPath = "/view/parts/sidebar/WarehouseManage.fxml";
                     contentPath = "/view/content/wh/WHList.fxml";

                     break;
                 // Thêm các trường hợp case khác nếu cần thiết
                 default:
                     // Thực hiện các lệnh nếu không có trường hợp nào khớp với giá trị của biểu thức
             }
             OrderPlacementController.activeIndex = 3;
             login(sidebarPath, contentPath, imagePath);

         }
    }

    private void login(String sb, String ct, String img) {
        try {
            MainController mc = new MainController();
            mc.setSidebarPath(sb);
            mc.setContentPath(ct);
            mc.setAvatarPath(img);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            fxmlLoader.setController(mc);
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/lam.css")).toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
            Stage stage2 = (Stage) userInput.getScene().getWindow();
            stage2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
