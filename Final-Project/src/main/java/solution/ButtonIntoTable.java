package fx.other;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;

public class ButtonIntoTable {
    HBox action = createAction("delete");

    public static HBox createAction(String type) {
        HBox hbox = new HBox();
        hbox.setPrefWidth(100);
        hbox.setAlignment(Pos.CENTER);

        // Load image from resources
        Image image = new Image(Objects.requireNonNull(ButtonIntoTable.class.getResourceAsStream("/images/icons/file-view.png")));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);

        // Add ImageView to HBox
        hbox.getChildren().add(imageView);
        return hbox;
    }

    public static void actionView(HBox hb) {
        try {
            FXMLLoader loader = new FXMLLoader(ButtonIntoTable.class.getResource("/view/parts/button_into_table/view.fxml"));
            hb = loader.load();
        } catch (IOException e) {
            System.err.println("Error loading sidebar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
