package fx.product;

import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Product;

import java.util.Objects;

public class ProductCardController {
    private Product product;

    @FXML
    private VBox productCard;

    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;

    public ProductCardController() {
        // No-argument constructor required by FXML
    }

    public void setProduct(Product product) {
        this.product = product;
        if (productName != null && productImage != null) {
            productName.setText(product.getName());
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(product.getImage())));
            productImage.setImage(image);
            shadowPreviewCard();
        }
    }

    @FXML
    void initialize() {
        shadowPreviewCard();
    }

    private void shadowPreviewCard() {
        // Apply a shadow effect to the VBox
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setColor(Color.GRAY);

        // Apply the DropShadow effect to VBox
        productCard.setEffect(dropShadow);

        // Ensure ImageView has a clip to avoid shadow affecting it separately
        Rectangle clip = new Rectangle(productImage.getFitWidth(), productImage.getFitHeight());
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        productImage.setClip(clip);

        // Take a snapshot of the ImageView with the clip applied
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = productImage.snapshot(parameters, null);

        // Remove the clip and set the snapshot as the image of the ImageView
        productImage.setClip(null);
        productImage.setImage(image);
    }

}
