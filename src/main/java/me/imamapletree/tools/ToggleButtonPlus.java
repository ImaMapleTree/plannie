package me.imamapletree.tools;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.imamapletree.events.ToggleEvent;


public class ToggleButtonPlus extends ToggleButton {
    private Image unselected;
    private Image selected;
    public boolean state = false;

    public ToggleButtonPlus(Image unselected, Image selected) {
        this.unselected = unselected;
        this.selected = selected;
        this.bind();
        this.setOnAction(actionEvent -> {
            this.fireEvent(new ToggleEvent(this.state));
            this.state = !this.state;
        });
    }

    public void setOnToggle(EventHandler<ToggleEvent> eventHandler) {
        this.addEventFilter(ToggleEvent.TOGGLE, eventHandler);
    }

    private void bind() {
        ImageView graphic = new ImageView();

        this.setGraphic(graphic);
        this.setStyle("-fx-background-color: transparent;");
        graphic.imageProperty().bind(Bindings.when(this.selectedProperty()).then(selected).otherwise(unselected));
    }
}
