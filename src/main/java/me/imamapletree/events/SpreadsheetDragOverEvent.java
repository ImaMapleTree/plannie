package me.imamapletree.events;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class SpreadsheetDragOverEvent implements EventHandler<DragEvent> {

    @Override
    public void handle(DragEvent event) {
        if (event.getDragboard().hasUrl()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
}
