package fx.insertitems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewController {

    @FXML
    private ImageView view;

    private static ActionEvent e;

    @FXML
    void click(MouseEvent event) {
    }

    public static void setE(ActionEvent e) {
        ViewController.e = e;
    }
}
