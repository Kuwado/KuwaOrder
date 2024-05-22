package fx.makeorder;

import fx.LoginController;
import fx.MainController;
import fx.breadcrumb.MOBreadcrumbController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.tabledata.MOOrder;
import model.tabledata.MORequest;
import solution.Paginator;
import solution.Transition;

import java.io.IOException;
import java.util.Objects;

public abstract class MOController<T> {
    @FXML
    public HBox breadcrumb;

    @FXML
    public Button viewAll;

    @FXML
    public Pagination pagination;

    @FXML
    public Pane hidePagination;

    @FXML
    public AnchorPane previewCard;

    @FXML
    private TextField searchInput;

    @FXML
    public TableColumn<T, String> name;

    public void getName(TableColumn<T, String> name) {
        this.name = name;
    }

    public int number = 9;
    public boolean viewAllStt = false;
    public boolean previewStt = false;
    public T selectedDate;

    public abstract void insertToTable(ObservableList<T> datas);
    public abstract void insertToPreviewCard(T data);
    public abstract boolean setDataToTrans(T data);

    public void setBreadcrumb(int number, String path) {
        MOBreadcrumbController.number = number;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, path);
    }

    public void startTable(TableView<T> table, ObservableList<T> items) {
        hidePagination.setVisible(false);
        ObservableList<T> filters = FXCollections.observableArrayList(); // Tạo một danh sách mới để lưu trữ các mục lọc
        searchInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filters.clear();
            if (!newValue.isEmpty()) {
                for (T t : items) {
                    String nameValue = name.getCellData(t);
                    if (nameValue != null && nameValue.toLowerCase().contains(newValue.toLowerCase())) {
                        filters.add(t);
                    }
                }
            } else {
                filters.setAll(items);
            }
            insertToTable(filters);
            Paginator.setPagination(table, pagination, filters, number);
        });

        insertToTable(items);
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

    public void viewRequestDetail(T data, ActionEvent event, String path) {
        if (setDataToTrans(data)) {
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
                stage.setTitle("KuwaOrder");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Không có nội dung để hiển thị");
            alert.setHeaderText(null);
            if (data instanceof MORequest) {
                alert.setContentText("Request này không có Order nào cả, chờ đợi bộ phận bán hàng cập nhật sau nhé !!!");
            } else if (data instanceof MOOrder) {
                alert.setContentText("Không có Site nào đáp ứng điều kiện về đơn đặt hàng này (thời gian giao hàng không đủ)");
            }
            alert.showAndWait();
        }

    }


}
