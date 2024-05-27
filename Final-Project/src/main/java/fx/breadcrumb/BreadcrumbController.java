package fx.breadcrumb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public abstract class BreadcrumbController {
    @FXML
    public HBox bc_container;

    public void updateBreadcrumb(int n) {
        int numChildren = bc_container.getChildren().size();
        for (int i = numChildren - 1; i >= n; i--) {
            bc_container.getChildren().get(i).setVisible(false);
        }
        bc_container.getChildren().get(n-1).getStyleClass().add("breadcrumb-active") ;
    }

    public void loadBreadcrumb(HBox hb, String path) {
        try {
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource(path));
            HBox bc = loader3.load();
            hb.getChildren().add(bc);
        } catch (IOException e) {
            System.err.println("Error loading content.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
