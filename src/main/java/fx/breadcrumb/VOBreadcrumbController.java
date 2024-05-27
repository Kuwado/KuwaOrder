package fx.breadcrumb;

import fx.breadcrumb.BreadcrumbController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VOBreadcrumbController extends BreadcrumbController {
    public static int number;

    public VOBreadcrumbController() {
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
