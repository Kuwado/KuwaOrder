package fx;

import fx.sidebar.OrderPlacementController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    private List<User> users;

    @FXML
    public void initialize() {

    }

    @FXML
    private void login() {


//        if (checkUser(userInput.getText(), passwordInput.getText()).equals("bophandathang")){
            sidebarPath = "/view/parts/sidebar/OrderPlacement.fxml";
            contentPath = "/view/content/makeorder/MORequestList.fxml";
            imagePath= "/images/avatar.jpg";
//        }
        OrderPlacementController.activeIndex = 3;
        login(sidebarPath, contentPath, imagePath);
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
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/makeOrder.css")).toExternalForm());
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

    private String checkUser(String name, String pass) {
        for (User user : users) {
            if(user.getName().equals(name) && user.getPassword().equals(pass)) {
                if(user.getType().equals("1")){
                    return "bophandathang";
                }
                break;
            }
        }
        return "bophandathang";
    }

}
