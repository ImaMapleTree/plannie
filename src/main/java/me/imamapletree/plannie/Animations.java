package me.imamapletree.plannie;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animations {
    public static void moveNodeX(Node node, int x, double duration) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(duration));
        transition.setToX(x);
        transition.setNode(node);
        transition.play();
    }

    public static void moveNodeX(Node node, int x) {
        moveNodeX(node, x, 1);
    }

    public static void moveNodeY(Node node, int y, double duration) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(duration));
        transition.setToY(y);
        transition.setNode(node);
        transition.play();
    }
}
