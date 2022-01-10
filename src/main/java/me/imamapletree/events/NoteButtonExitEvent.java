package me.imamapletree.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import me.imamapletree.plannie.Application;

public class NoteButtonExitEvent implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {
        Application.NoteButtonHover = false;
    }
}
