package fx;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class MainController {

    private static final String avatarPath = "/images/avatar.jpg";
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
                transitionAvatarBar(0, 300);
                avatarStatus = true;
            } else {
                transitionAvatarBar(300, 0);
                avatarStatus = false;
            }
        });
    }

    // Dịch chuyển thanh avatarbar
    private void transitionAvatarBar(int x, int y) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(avatarBar);
        slide.setToX(x);
        slide.play();
        avatarBar.setTranslateX(y);
    }

}
