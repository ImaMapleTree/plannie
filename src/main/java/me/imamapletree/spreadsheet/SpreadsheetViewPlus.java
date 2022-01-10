package me.imamapletree.spreadsheet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TablePosition;
import javafx.scene.input.MouseEvent;
import me.imamapletree.events.CellClickEvent;
import me.imamapletree.events.CellDragDropEvent;
import me.imamapletree.events.SpreadsheetDragOverEvent;
import org.controlsfx.control.spreadsheet.*;


public class SpreadsheetViewPlus extends SpreadsheetView {

    public int rowCount;
    public int columnCount;
    private ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();

    public SpreadsheetCell[] cellStorage = new SpreadsheetCell[2];
    public SpreadsheetCell focused;

    public SpreadsheetViewPlus(int rows, int columns) {
        rowCount = rows;
        columnCount = columns;

        GridBase grid = new GridBase(rowCount, columnCount);

        buildGrid(grid);
        setGrid(grid);

        this.setOnMouseDragged(mouseEvent -> mouseEvent.setDragDetect(true));
        this.setOnDragOver(new SpreadsheetDragOverEvent());
        this.setOnDragDropped(new CellDragDropEvent(this));

        this.getChildren().forEach(child -> child.addEventFilter(MouseEvent.MOUSE_CLICKED, new CellClickEvent(this)));

    }

    private void buildGrid(GridBase grid) {
        for (int r = 0; r < rowCount; r++) {
            ObservableList<SpreadsheetCell> column = FXCollections.observableArrayList();

            for (int c = 0; c < columnCount; c++) {
                SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(r, c, 1, 1, "");

                column.add(cell);

            }
            rows.add(column);
        }

        grid.setRows(rows);

    }

    public SpreadsheetCell getCell(int row, int column) {
        return this.rows.get(row).get(column);
    }

    public SpreadsheetCell getCell(TablePosition position) {
        return getCell(position.getRow(), position.getColumn());
    }

    public void setCell(int row, int column, SpreadsheetCell cell) {
        this.rows.get(row).set(column, cell);
    }
}
