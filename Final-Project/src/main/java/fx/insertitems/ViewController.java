package fx.insertitems;

import fx.MyListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewController {

    @FXML
    private ImageView view;

    private MyListener myListener;
    private static ActionEvent e;

    @FXML
    void click(MouseEvent event) {
        myListener.onClickListener(e);
    }

    public static void setE(ActionEvent e) {
        ViewController.e = e;
    }
}
