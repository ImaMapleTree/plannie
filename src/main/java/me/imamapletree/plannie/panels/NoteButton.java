package me.imamapletree.plannie.panels;

import javafx.scene.control.Button;

public class NoteButton extends Button {
    public NoteButton() {
        super("New Note");
    }

    public void showHoverMenu() {
        System.out.println("Context menu");
        this.setMinHeight(300);
        this.toFront();
    }

}
