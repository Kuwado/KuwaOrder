package fx.wh;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SuccessPopupController {

    @FXML
    private Label successLabel;

    // Thời gian trễ trước khi đóng popup (2 giây)
    private static final int DELAY_SECONDS = 2;

    @FXML
    public void initialize() {
        // Lập lịch để đóng popup sau một khoảng thời gian
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(DELAY_SECONDS), event -> closePopup()));
        timeline.setCycleCount(1);
        timeline.play();
    }

    // Phương thức để đóng cửa sổ popup
    private void closePopup() {
        Stage stage = (Stage) successLabel.getScene().getWindow();
        stage.close();
    }
}

