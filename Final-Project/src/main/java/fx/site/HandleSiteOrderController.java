package fx.site;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class HandleSiteOrderController {

    public TableView commonTable;
    public TableView detailTable;
    @FXML
    private Button cancelButton;


    public void cancelSiteOrder(ActionEvent actionEvent) {
        System.out.println("Cancel this site order");
    }
}
