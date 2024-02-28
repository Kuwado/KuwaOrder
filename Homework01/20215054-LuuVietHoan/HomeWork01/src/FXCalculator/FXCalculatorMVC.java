package FXCalculator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXCalculatorMVC extends Application {

	@Override
    public void start(Stage primaryStage) throws Exception{
		FXCalculatorModel model = new FXCalculatorModel();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXCalculator/caculator.fxml"));
			FXCalculatorController controller = new FXCalculatorController(model);
			fxmlLoader.setController(controller);
			Parent root;
			root = fxmlLoader.load();
			primaryStage.setTitle("Calculator");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        launch(args);
    }
}
