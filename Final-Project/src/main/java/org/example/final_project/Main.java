package org.example.final_project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load file Home.fxml
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Main.fxml")));

        // Set up the primary stage
        primaryStage.setTitle("FXML Example");
        primaryStage.setScene(new Scene(root, 1540, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
