package fx.sidebar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

public class OrderPlacementController {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    private List<Button> btns;
    public static int activeIndex = 0;

    @FXML
    void initialize(){
        btns = List.of(btn1, btn2, btn3, btn4, btn5);
        btns.get(activeIndex).getStyleClass().add("sidebar-active");
    }


}
