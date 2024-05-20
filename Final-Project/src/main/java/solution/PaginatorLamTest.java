package solution;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import model.tabledata.LamTestOrder;

public class PaginatorLamTest {

    public static void setPagination(TableView<LamTestOrder> table, Pagination pagination, ObservableList<LamTestOrder> data, int rowsPerPage) {
        int pageCount = (int) Math.ceil((double) data.size() / rowsPerPage);
        pagination.setPageCount(pageCount);

        pagination.setPageFactory((pageIndex) -> {
            int fromIndex = pageIndex * rowsPerPage;
            int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
            table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
            return table;
        });

        if (pageCount > 0) {
            pagination.setCurrentPageIndex(0);
            int fromIndex = 0;
            int toIndex = Math.min(rowsPerPage, data.size());
            table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        } else {
            table.setItems(FXCollections.observableArrayList());
        }
    }
}
