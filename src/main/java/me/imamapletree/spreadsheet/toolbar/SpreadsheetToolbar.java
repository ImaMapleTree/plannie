package me.imamapletree.spreadsheet.toolbar;

import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.imamapletree.events.ToggleButtonClickEvent;
import me.imamapletree.tools.ToggleButtonPlus;
import me.imamapletree.tools.Utils;

public class SpreadsheetToolbar extends HBox {
    public ImageView undo;
    public ImageView redo;
    public ImageView bold;
    public ImageView italics;
    public ImageView strike;
    public ImageView color;
    public ImageView fill;
    public ImageView border;
    public ImageView merge;
    public ImageView horizontalAlign;
    private ImageView _alignLeft;
    private ImageView _alignCenter;
    private ImageView _alignRight;
    public ImageView verticalAlign;
    private ImageView _alignBottom;
    private ImageView _alignMiddle;
    private ImageView _alignTop;
    public ToggleButtonPlus barToggle;
    private ImageView arrowDown;
    private ImageView arrowUp;

    /*
    Padding:
        V1 = Top
        V2 = Right
        V3 = Bottom
        V4 = Left
     */

    public SpreadsheetToolbar() {
        loadIcons();
        createBarToggle();
        this.setSpacing(10);

        TextField field = new TextField();
        field.setText("12");
        field.setFont(Font.font("Roboto", FontWeight.BOLD, 11));
        field.maxWidthProperty().setValue(50);
        field.maxHeightProperty().setValue(5);

        Separator sep1 = new Separator();
        sep1.setOrientation(Orientation.VERTICAL);

        Separator sep2 = new Separator();
        sep2.setOrientation(Orientation.VERTICAL);

        Separator sep3 = new Separator();
        sep3.setOrientation(Orientation.VERTICAL);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(undo, redo, sep1, field, sep2, bold, italics, strike, color, sep3, fill, border, horizontalAlign, verticalAlign, spacer, barToggle);
        italics.getStyleClass().add("spreadsheet-button");
        this.getChildren().forEach(node -> {
            node.getStyleClass().add("spreadsheet-button");
        });
    }

    public void loadIcons() {
        undo = Utils.ImageFromResource("icons/opaque/undo.png");
        redo = Utils.ImageFromResource("icons/opaque/redo.png");
        bold = Utils.ImageFromResource("icons/opaque/bold.jpg");
        italics = Utils.ImageFromResource("icons/opaque/italics.png");
        strike = Utils.ImageFromResource("icons/opaque/strikethrough.png");
        color = Utils.ImageFromResource("icons/opaque/textColor.png");
        fill = Utils.ImageFromResource("icons/opaque/fill.png");
        border = Utils.ImageFromResource("icons/opaque/borders.png");
        merge = Utils.ImageFromResource("icons/opaque/merge.png");
        horizontalAlign = Utils.ImageFromResource("icons/opaque/alignLeft.png");
        verticalAlign = Utils.ImageFromResource("icons/opaque/alignBottom.png");
    }

    private void createBarToggle() {
        Image arrowUp = new Image(Utils.loadResource("icons/opaque/arrowUp.png"));
        Image arrowDown = new Image(Utils.loadResource("icons/opaque/arrowDown.png"));

        barToggle = new ToggleButtonPlus(arrowUp, arrowDown);
        barToggle.setOnToggle(new ToggleButtonClickEvent());
    }


}
