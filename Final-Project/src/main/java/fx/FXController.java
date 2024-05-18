package fx;

import fx.breadcrumb.MOBreadcrumbController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import solution.Paginator;
import solution.Transition;

public abstract class FXController<T> {
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

    public int number;

    public void setBreadcrumb(int number, String path) {
        MOBreadcrumbController.number = number;
        MOBreadcrumbController moc = new MOBreadcrumbController();
        moc.loadBreadcrumb(breadcrumb, path);
    }

    public abstract void insertToTable();

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

    public abstract void insertToPreviewCard(T data);

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

}
