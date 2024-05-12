package fx;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class MainController {

    private static final String IMAGE_PATH = "/images/avatar.jpg";
    private static final String CONTENT_FXML_PATH = "/view/parts/sidebar/OrderPlacement.fxml";
    private boolean avatarStatus = false;


    @FXML
    private Circle avatar;

    @FXML
    private VBox sidebar;

    @FXML
    private Pane avatarBar;

    @FXML
    private Pane content;


    @FXML
    public void initialize() {

        // Load và thiết lập hình ảnh cho avatar
        try {
            URL imageUrl = getClass().getResource(IMAGE_PATH);
            if (imageUrl != null) {
                Image avatarImage = new Image(imageUrl.toExternalForm());
                avatar.setFill(new ImagePattern(avatarImage));
                avatar.setEffect(new DropShadow(25, 0, 2, Color.DARKSEAGREEN));
            } else {
                System.err.println("Image resource not found: " + IMAGE_PATH);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        // Load và chèn nội dung vào sidebar
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(CONTENT_FXML_PATH));
            VBox sb = loader.load();
            sidebar.getChildren().add(sb);
        } catch (IOException e) {
            System.err.println("Error loading content.fxml: " + e.getMessage());
            e.printStackTrace();
        }

        // Load và chèn nội dung vao content
        try {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/content/content.fxml"));
            Pane con = loader2.load();
            content.getChildren().add(con);
        } catch (IOException e) {
            System.err.println("Error loading content.fxml: " + e.getMessage());
            e.printStackTrace();
        }

        // Click avatar
        avatarBar.setTranslateX(300);

        avatar.setOnMouseClicked(event -> {
            if (!avatarStatus) {
                transitionAvatarBar(0,300);
                avatarStatus = true;
            }
            else {
                transitionAvatarBar(300, 0);
                avatarStatus = false;
            }

        });
    }

    private void transitionAvatarBar(int x, int y) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(avatarBar);
        slide.setToX(x);
        slide.play();
        avatarBar.setTranslateX(y);
    }
}
