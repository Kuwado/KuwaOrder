package fx.warehouse;

import fx.breadcrumb.BreadcrumbController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WHBreadcrumbController extends BreadcrumbController {
    public static int number;

    public WHBreadcrumbController() {
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
