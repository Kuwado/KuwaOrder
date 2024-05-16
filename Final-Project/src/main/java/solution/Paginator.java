package solution;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import model.TableData;

import java.util.List;

public class Paginator {

    public static <T extends TableData> void setPagination(TableView<T> table, Pagination pagination, ObservableList<T> items, int number) {
        int totalPages = (items.size() + number - 1) / number;
        pagination.setPageCount(totalPages);
        pagination.setPageFactory(pageIndex -> {
            int fromIndex = pageIndex * number;
            int toIndex = Math.min(fromIndex + number, items.size());
            List<T> subList = items.subList(fromIndex, toIndex);
            ObservableList<T> currentPageItems = FXCollections.observableArrayList(subList);
            table.setItems(currentPageItems);
            return table;
        });
    }
}
