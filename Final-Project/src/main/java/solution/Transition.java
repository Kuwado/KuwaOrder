package solution;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Transition {

    public static void transitionXY(Pane s, int x, int y, double time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(time));
        slide.setNode(s);
        slide.setToX(x);
        slide.setToY(y);
        slide.play();
    }

    public static void transitionXY(AnchorPane s, int x, int y, double time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(time));
        slide.setNode(s);
        slide.setToX(x);
        slide.setToY(y);
        slide.play();
    }

    public static void transitionXY(HBox s, int x, int y, double time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(time));
        slide.setNode(s);
        slide.setToX(x);
        slide.setToY(y);
        slide.play();
    }

    public static void transitionXY(VBox s, int x, int y, double time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(time));
        slide.setNode(s);
        slide.setToX(x);
        slide.setToY(y);
        slide.play();
    }







}
