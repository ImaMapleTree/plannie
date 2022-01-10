package me.imamapletree.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import me.imamapletree.plannie.Animations;
import me.imamapletree.plannie.Application;
import me.imamapletree.tools.Utils;

import java.util.TimerTask;


public class ToggleButtonClickEvent implements EventHandler<ToggleEvent> {

    public ToggleButtonClickEvent() {
    }

    @Override
    public void handle(ToggleEvent event) {
        if (!event.state) {
            Animations.moveNodeY(Application.vbox, (int) ((Application.header.getHeight() * -1) - 10), 0.4);
            Application.pageContent.setMinHeight(Application.pageContent.getMaxHeight() + Application.header.getHeight() + 10);
            Application.pageContent.setMaxHeight(Application.pageContent.getMaxHeight() + Application.header.getHeight() + 10);
        } else {
            Animations.moveNodeY(Application.vbox, 0, 0.4);
            Utils.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Application.pageContent.setMinHeight(Application.pageContent.getMaxHeight() - Application.header.getHeight() - 10);
                    Application.pageContent.setMaxHeight(Application.pageContent.getMaxHeight() - Application.header.getHeight() - 10);
                }
            }, 400);
        }
    }
}
