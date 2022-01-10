package me.imamapletree.events;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import me.imamapletree.spreadsheet.SpreadsheetViewPlus;
import me.imamapletree.tools.Utils;

import java.io.*;

public class CellDragDropEvent implements EventHandler<DragEvent> {

    SpreadsheetViewPlus parent;

    public CellDragDropEvent(SpreadsheetViewPlus parent) {
        this.parent = parent;
    }

    @Override
    public void handle(DragEvent event) {
        String url = event.getDragboard().getUrl();

        System.out.println(parent.focused);

        InputStream is = Utils.StreamFromPath(url);

        if (is != null) {
            parent.focused.setGraphic(new ImageView(new Image(is)));
        }

    }
}