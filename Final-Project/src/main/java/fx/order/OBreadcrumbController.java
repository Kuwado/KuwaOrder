package fx.order;

import fx.BreadcrumbController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OBreadcrumbController extends BreadcrumbController {
    public static int number;

    public OBreadcrumbController() {
    }

    @FXML
    private Button waitList;

    @FXML
    private Button orderLine;

    @FXML
    void initialize() {
        updateBreadcrumb(number);
    }
}
