package me.imamapletree.tools;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import me.imamapletree.plannie.Application;

import java.io.*;
import java.net.URL;
import java.util.Timer;

public class Utils {
    public enum SpacerType {
        Horizontal,
        Vertical
    }

    public static Timer timer = new Timer();

    public static InputStream StreamFromPath(String path) {
        InputStream is = null;
        if (path.startsWith("file:/")) {
            path = path.replace("file:/", "");
        }

        if (path.startsWith("http")) {
            try {
                is = new URL(path).openStream();
            } catch (IOException e) { }
        } else {
            try {
                is = new BufferedInputStream(new FileInputStream(path));
            } catch (FileNotFoundException e) { }
        }
        return is;
    }

    public static InputStream loadResource(String path) {
        return Application.class.getResourceAsStream(path);
    }

    public static ImageView ImageFromResource(String path) {
        return new ImageView(new Image(loadResource(path)));
    }

    public static Region createSpacer(SpacerType type, int size) {
        Region spacer = new Region();
        if (type == SpacerType.Horizontal) {
            HBox.setHgrow(spacer, Priority.ALWAYS);
            if (size >= 0) spacer.setMaxWidth(size);
        } else {
            VBox.setVgrow(spacer, Priority.ALWAYS);
            if (size >= 0) spacer.setMaxHeight(size);
        }
        return spacer;
    }

    public static Region createSpacer(SpacerType type) {
        return createSpacer(type, -1);
    }
}
