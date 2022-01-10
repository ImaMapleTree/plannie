package me.imamapletree.plannie;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import me.imamapletree.events.LPButtonClickEvent;
import me.imamapletree.plannie.panels.HeaderBar;
import me.imamapletree.plannie.panels.NoteBar;
import me.imamapletree.spreadsheet.SpreadsheetViewPlus;
import me.imamapletree.spreadsheet.toolbar.SpreadsheetToolbar;
import me.imamapletree.tools.Utils;

public class Application extends javafx.application.Application {

    private SpreadsheetViewPlus table = new SpreadsheetViewPlus(50, 26);
    public static Scene scene;
    public static boolean NoteButtonHover = false;
    public static Region pageContent;
    public static HeaderBar header;
    public static HBox toolbar;
    public static VBox vbox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        scene = new Scene(new Group());
        stage.setTitle("Plannie");
        stage.setWidth(800);
        stage.setHeight(500);

        table.setEditable(true);
        table.setMinHeight(380);
        table.setMaxHeight(380);

        HBox pageBox = new HBox();
        NoteBar noteBar = new NoteBar(175);
        pageContent = table;

        stage.heightProperty().addListener((observableValue, oldValue, newValue) -> {
            pageContent.setMinHeight((Double) newValue-120);
            pageContent.setMaxHeight((Double) newValue-120);
        });

        pageContent.setMaxWidth(760);

        stage.widthProperty().addListener((observableValue, oldValue, newValue) -> {
            pageContent.setMinWidth((Double)newValue-40);
            pageContent.setMaxWidth((Double)newValue-40);
        });


        vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        header = new HeaderBar();

        header.leftPanelToggle.setOnToggle(new LPButtonClickEvent(vbox, noteBar));
        toolbar = new SpreadsheetToolbar();
        vbox.getChildren().addAll(header, new Separator(), toolbar, table);

        pageBox.getChildren().add(noteBar);
        pageBox.getChildren().add(vbox);
        ((Group) scene.getRoot()).getChildren().addAll(pageBox);

        vbox.applyCss();
        vbox.layout();
        pageBox.applyCss();
        pageBox.layout();


        vbox.setTranslateX(-1*noteBar.getMaxWidth());
        vbox.setStyle("-fx-background-color: white;");

        scene.getStylesheets().add(Application.class.getResource("spreadsheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}