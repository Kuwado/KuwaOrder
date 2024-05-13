package fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import solution.Transition;

import java.io.IOException;
import java.net.URL;

public class MainController {

    public String avatarPath;
    public String sidebarPath;
    //= "/view/parts/sidebar/OrderPlacement.fxml";
    public String contentPath;
    private boolean avatarStatus = false;

    public MainController() {

    }

    public void setSidebarPath(String sidebarPath) {
        this.sidebarPath = sidebarPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    @FXML
    private Circle avatar;

    @FXML
    private Pane avatarBar;

    @FXML
    private VBox sidebar;

    @FXML
    private Pane content;

    @FXML
    private HBox breadcrumb;


    @FXML
    public void initialize() {
        loadAvatar(avatarPath);
        loadSidebar(sidebarPath);
        loadContent(contentPath);
        clickAvatar();
    }

    // Load và thiết lập hình ảnh cho avatar
    private void loadAvatar(String path) {
        try {
            URL imageUrl = getClass().getResource(path);
            if (imageUrl != null) {
                Image avatarImage = new Image(imageUrl.toExternalForm());
                avatar.setFill(new ImagePattern(avatarImage));
                avatar.setEffect(new DropShadow(25, 0, 2, Color.DARKSEAGREEN));
            } else {
                System.err.println("Image resource not found");
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Load và chèn nội dung vào sidebar
    private void loadSidebar(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            VBox sb = loader.load();
            sidebar.getChildren().add(sb);
        } catch (IOException e) {
            System.err.println("Error loading sidebar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Load và chèn nội dung vao content
    private void loadContent(String path) {
        try {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource(path));
            VBox con = loader2.load();
            content.getChildren().add(con);
        } catch (IOException e) {
            System.err.println("Error loading content.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Click avatar
    private void clickAvatar() {
        avatarBar.setTranslateX(300);
        avatar.setOnMouseClicked(event -> {
            if (!avatarStatus) {
                Transition.transitionXY(avatarBar, 0, 0, 0.4);
                avatarStatus = true;
            } else {
                Transition.transitionXY(avatarBar, 300, 0, 0.4);
                avatarStatus = false;
            }
        });
    }


}
