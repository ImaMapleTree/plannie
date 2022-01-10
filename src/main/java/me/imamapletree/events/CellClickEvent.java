package me.imamapletree.events;


import javafx.event.Event;
import javafx.event.EventHandler;
import me.imamapletree.spreadsheet.SpreadsheetViewPlus;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;

public class CellClickEvent implements EventHandler {

    SpreadsheetViewPlus parent;

    public CellClickEvent(SpreadsheetViewPlus parent) {
        this.parent = parent;
    }

    @Override
    public void handle(Event event) {
        SpreadsheetCell cell = parent.getCell(parent.getSelectionModel().getFocusedCell());
        parent.focused = cell;
    }
}
