package fx.wh;
import fx.LoginController;
import fx.MainController;
import fx.breadcrumb.MOBreadcrumbController;
import fx.warehouse.WHBreadcrumbController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import solution.Paginator;
import solution.Transition;

import java.io.IOException;
import java.util.Objects;

public abstract class whController<T> {
    @FXML
    public HBox breadcrumb;

    @FXML
    public Pagination pagination;

    public int number = 9;

    public abstract void insertToTable();
    public abstract void setDataToTrans(T data);

    public void setBreadcrumb(int number, String path) {
        WHBreadcrumbController.number = number;
        WHBreadcrumbController moc = new WHBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, path);
    }

    public void startTable(TableView<T> table, ObservableList<T> items) {
        insertToTable();
        Paginator.setPagination(table, pagination, items, number);
    }

    public Button makeButton(TableView<T> table,  int index, String path) {
        Button button = new Button();
        button.getStyleClass().add("table-view-btn");
        button.setOnAction(event -> {
            T data = table.getItems().get(index);
            viewRequestDetail(data, event, path);
        });
        return button;
    }
    public void viewRequestDetail(T data, ActionEvent event, String path) {
        try {
            setDataToTrans(data);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            MainController mc = new MainController();
            mc.setContentPath(path);
            mc.setSidebarPath(LoginController.sidebarPath);
            mc.setAvatarPath(LoginController.imagePath);
            fxmlLoader.setController(mc);
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/makeOrder.css")).toExternalForm());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
