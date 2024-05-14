package solution;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Pagination;

import model.Request;

import java.util.List;

public class Paginator {
    public static void setPagination(TableView table, Pagination pagination, ObservableList<Request> requests, int number) {
        int totalPages = (requests.size() + number - 1) / number;
        pagination.setPageCount(totalPages);
        pagination.setPageFactory(pageIndex -> {
            int fromIndex = pageIndex * number;
            int toIndex = Math.min(fromIndex + number, requests.size());
            List<Request> subList = requests.subList(fromIndex, toIndex);
            ObservableList<Request> currentPageRequests = FXCollections.observableArrayList(subList);
            //table.getItems().clear();
            table.setItems(currentPageRequests);
            return table;
        });
    }
}
