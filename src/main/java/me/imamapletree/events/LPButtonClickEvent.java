package me.imamapletree.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import me.imamapletree.plannie.Animations;
import me.imamapletree.plannie.Application;
import me.imamapletree.plannie.panels.NoteBar;
import me.imamapletree.tools.Utils;

import java.util.TimerTask;

public class LPButtonClickEvent implements EventHandler<ToggleEvent> {

    public VBox content;
    public NoteBar bar;

    public LPButtonClickEvent(VBox content, NoteBar bar) {
        this.content = content;
        this.bar = bar;
    }

    @Override
    public void handle(ToggleEvent event) {
        System.out.println(event.state);
        if (event.state) {
            Animations.moveNodeX(content, (int) (-1*bar.getMaxWidth()), 0.4);
            Application.pageContent.setMaxWidth(Application.pageContent.getMaxWidth()+bar.getMaxWidth());
        } else {
            Animations.moveNodeX(content, 0, 0.4);
            Utils.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Application.pageContent.setMaxWidth(Application.pageContent.getMaxWidth()-bar.getMaxWidth());
                }
            },400);
        }
    }
}
