package me.imamapletree.plannie.panels;

import javafx.scene.layout.VBox;

public class NoteBar extends VBox {
    public NoteBar(int width) {
        this.setMaxWidth(width);
        this.setMinWidth(width);
        this.getStyleClass().add("notebar");
    }


}
