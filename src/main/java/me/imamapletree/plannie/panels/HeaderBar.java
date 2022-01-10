package me.imamapletree.plannie.panels;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import me.imamapletree.events.CreateNoteEvent;
import me.imamapletree.events.NoteButtonEnterEvent;
import me.imamapletree.events.NoteButtonExitEvent;
import me.imamapletree.tools.ToggleButtonPlus;
import me.imamapletree.tools.Utils;
import org.w3c.dom.events.Event;

public class HeaderBar extends HBox {

    public ToggleButtonPlus leftPanelToggle;
    public ImageView gear;
    public NoteButton noteButton;

    public HeaderBar() {
        final Label label = new Label("Spreadsheet");
        label.setFont(new Font("Arial", 20));

        createPanelToggle();
        createNoteButton();
        createGear();

        Region spacer = new Region();
        this.setSpacing(10);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(leftPanelToggle, label, spacer, noteButton, gear);
    }

    private void createPanelToggle() {
        Image arrowLeft = new Image(Utils.loadResource("icons/arrowLeftLarge.png"));
        Image arrowRight = new Image(Utils.loadResource("icons/arrowRightLarge.png"));

        leftPanelToggle = new ToggleButtonPlus(arrowRight, arrowLeft);
        leftPanelToggle.getStyleClass().add("spreadsheet-button");
    }

    private void createGear() {
        gear = Utils.ImageFromResource("icons/gear.png");
        gear.setPreserveRatio(true);
        gear.setFitHeight(15);
        gear.setTranslateY(5);
        gear.getStyleClass().add("spreadsheet-button");
    }

    private void createNoteButton() {
        noteButton = new NoteButton();
        noteButton.getStyleClass().add("note-button");
        noteButton.addEventFilter(MouseEvent.MOUSE_ENTERED, new NoteButtonEnterEvent(noteButton));
        noteButton.addEventFilter(MouseEvent.MOUSE_EXITED, new NoteButtonExitEvent());
        noteButton.setOnAction(new CreateNoteEvent());
    }
}
