package fx.breadcrumb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MOBreadcrumbController extends BreadcrumbController {
    public static int number;

    public MOBreadcrumbController() {
    }
    
    @FXML
    private Button order;

    @FXML
    private Button request;

    @FXML
    private Button requestList;

    @FXML
    private Button site;

    @FXML
    void initialize() {
        updateBreadcrumb(number);
    }







}
