package me.imamapletree.events;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import me.imamapletree.plannie.Application;
import me.imamapletree.plannie.panels.NoteButton;
import me.imamapletree.tools.Utils;

import java.util.TimerTask;

public class NoteButtonEnterEvent implements EventHandler<MouseEvent> {

    private NoteButton noteButton;
    public NoteButtonEnterEvent(NoteButton button) {
        this.noteButton = button;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        Application.NoteButtonHover = true;
        Utils.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (Application.NoteButtonHover) {
                    noteButton.showHoverMenu();
                }
            }
        }, 500);
    }
}
