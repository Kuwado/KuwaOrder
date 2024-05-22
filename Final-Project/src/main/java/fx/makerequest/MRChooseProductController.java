package fx.makerequest;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Product;

import java.io.IOException;

public class MRChooseProductController {

    @FXML
    private Label name;

    @FXML
    private Button actionBtn;

    @FXML
    private DatePicker date;

    @FXML
    private TextArea noteInput;

    @FXML
    private VBox previewContent;

    @FXML
    private ImageView image;

    @FXML
    private ImageView productImage;

    @FXML
    private ImageView productImage1;

    @FXML
    private ImageView productImage2;

    @FXML
    private ImageView productImage3;

    @FXML
    private ImageView productImage4;

    @FXML
    private ImageView productImage5;

    @FXML
    private ImageView productImage6;

    @FXML
    private ImageView productImage7;

    @FXML
    private GridPane productList;

    @FXML
    private TextField quantityInput;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchInput;


    private Product product;
    private MRMyListener MRMyListener;

    @FXML
    private void chooseProd(MouseEvent mouseEvent) throws IOException {
        if (MRMyListener != null) {
            MRMyListener.onClickListener(product);
        }
    }

//    private void setProduct(Product product) {
//        name.setText(product.getName());
//        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
//        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
//        fruitImg.setImage(image);
//        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
//                "    -fx-background-radius: 30;");
//    }

    public void setData(Product product, MRMyListener MRMyListener){
        this.product = product;
        this.MRMyListener = MRMyListener;
        name.setText(product.getName());
        Image image = new Image(getClass().getResourceAsStream(product.getImage()));

    }
}

