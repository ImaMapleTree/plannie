package me.imamapletree.events;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;

public class ToggleEvent extends Event {
    public boolean state;
    public static EventType<ToggleEvent> TOGGLE = new EventType<>();

    public ToggleEvent(boolean state) {
        super(TOGGLE);
        this.state = state;
    }
}
