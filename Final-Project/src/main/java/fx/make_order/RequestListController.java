package fx.make_order;

import fx.BreadcrumbController;
import fx.MainController;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class RequestListController {

    @FXML
    private HBox breadcrumb;

    @FXML
    void initialize() {
        MOBreadcrumbController.number = 4;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, "/view/parts/breadcrumbs/MakeOrder.fxml");
    }

}
