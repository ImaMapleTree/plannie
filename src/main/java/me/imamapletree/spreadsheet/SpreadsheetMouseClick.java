package me.imamapletree.spreadsheet;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

public class SpreadsheetMouseClick implements EventHandler<MouseEvent> {

    public SpreadsheetViewPlus spreadsheet;

    public SpreadsheetMouseClick(SpreadsheetViewPlus spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getEventType());
        this.spreadsheet.cellStorage[1] = this.spreadsheet.cellStorage[0];
        //this.spreadsheet.cellStorage[0] = this.spreadsheet.rows.get(spreadsheet.getEditingCell().getRow()).get(spreadsheet.getEditingCell().getColumn());


        System.out.println("Click!");
        System.out.println(this.spreadsheet.cellStorage[0]);

    }
}
