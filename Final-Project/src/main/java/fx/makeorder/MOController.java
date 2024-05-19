package fx.makeorder;

import fx.LoginController;
import fx.MainController;
import fx.breadcrumb.MOBreadcrumbController;
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

public abstract class MOController<T> {
    @FXML
    public HBox breadcrumb;
    public boolean viewAllStt = false;
    public boolean previewStt = false;

    @FXML
    public Button viewAll;

    @FXML
    public Pagination pagination;

    @FXML
    public Pane hidePagination;

    @FXML
    public AnchorPane previewCard;

    public int number = 9;

    public abstract void insertToTable();
    public abstract void insertToPreviewCard(T data);
    public abstract void setDataToTrans(T data);

    public void setBreadcrumb(int number, String path) {
        MOBreadcrumbController.number = number;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, path);
    }

    public void startTable(TableView<T> table, ObservableList<T> items) {
        hidePagination.setVisible(false);
        insertToTable();
        Paginator.setPagination(table, pagination, items, number);
    }

    public void viewAllTable(TableView<T> table, ObservableList<T> items) {
        if (viewAllStt) {
            viewAll.setText("Xem tất cả");
            hidePagination.setVisible(false);
            Paginator.setPagination(table, pagination, items, number);
        } else {
            viewAll.setText("Phân trang");
            hidePagination.setVisible(true);
            table.setItems(items);
        }
        viewAllStt = !viewAllStt;
    }

    public void makeAppearPreviewCard(TableView<T> table) {
        previewCard.setTranslateY(800);
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                if (!previewStt) {
                    Transition.transitionXY(previewCard, 0, 0, 0.7);
                    previewStt = true;
                }
                T item = table.getSelectionModel().getSelectedItem();
                if (item != null) {
                    insertToPreviewCard(item);
                }
            }
        });
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
