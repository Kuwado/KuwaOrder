package solution;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import model.LamTest;

import java.util.List;

public class PaginatorLamTest {
    public static void setPagination(TableView table, Pagination pagination, ObservableList<LamTest> lamT, int number) {
        int totalPages = (lamT.size() + number - 1) / number;
        pagination.setPageCount(totalPages);
        pagination.setPageFactory(pageIndex -> {
            int fromIndex = pageIndex * number;
            int toIndex = Math.min(fromIndex + number, lamT.size());
            List<LamTest> subList = lamT.subList(fromIndex, toIndex);
            ObservableList<LamTest> currentPageLamTest = FXCollections.observableArrayList(subList);
            //table.getItems().clear();
            table.setItems(currentPageLamTest);
            return table;
        });
    }
}
