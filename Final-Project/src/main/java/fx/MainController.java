package fx;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;

public class MainController {

    private static final String avatarPath = "/images/avatar.jpg";
    public String sidebarPath;
    //= "/view/parts/sidebar/OrderPlacement.fxml";
    public String contentPath;
    public ArrayList<String> breadcrumbs;
    private boolean avatarStatus = false;

    public MainController() {

    }

    public void setBreadcrumbs(ArrayList<String> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
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
        createBreadcrumb(breadcrumbs);
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
            AnchorPane con = loader2.load();
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

    // Tạo hình cho breadcrumb
    private void createCircleToBreadcrumb(String name) {
        Circle circle = new Circle(30);
        circle.setStroke(Color.WHITE);
        circle.setStrokeWidth(5);
        circle.setFill(null);

        Label label = new Label(name);
        label.setPrefHeight(48);
        label.setPrefWidth(48);
        label.setTextFill(Color.BLACK);
        StackPane.setAlignment(label, Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(circle, label);
        breadcrumb.getChildren().add(stackPane);
    }

    private void createLineToBreadcrumb() {
        Line line = new Line(0, 0, 80, 0);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(5);
        breadcrumb.getChildren().add(line);
    }

    private void highlightCircle(String name) {
        Circle circleLast = new Circle(30);
        circleLast.setStroke(Color.web("#3c1aad"));
        circleLast.setStrokeWidth(5);
        circleLast.setFill(Color.rgb(27, 27, 50));

        Label label = new Label(name);
        label.setPrefHeight(48);
        label.setPrefWidth(48);
        label.setTextFill(Color.WHITE);
        StackPane.setAlignment(label, Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(circleLast, label);
        breadcrumb.getChildren().add(stackPane);
    }

    private void createBreadcrumb(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                createLineToBreadcrumb();
                highlightCircle(list.get(i));
            } else if (i == 0) {
                createCircleToBreadcrumb(list.get(i));
            } else {
                createLineToBreadcrumb();
                createCircleToBreadcrumb(list.get(i));
            }
        }

    }


}
