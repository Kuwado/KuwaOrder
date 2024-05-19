package fx.makeorder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.tabledata.ConfirmSite;

public class MOConfirmSiteController  extends MOController<ConfirmSite>  {

    @FXML
    private Button backBtn;

    @FXML
    private TableView<?> chosenSiteTable;

    @FXML
    private Button confirmBtn;

    @FXML
    private TableColumn<?, ?> delivery;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableColumn<?, ?> siteName;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TableColumn<?, ?> takeDate;

    @FXML
    void initialize() {

    }

    @Override
    public void insertToTable() {

    }

    @Override
    public void setDataToTrans(ConfirmSite confirmSite) {

    }

    @Override
    public void insertToPreviewCard(ConfirmSite confirmSite) {
    }


}
