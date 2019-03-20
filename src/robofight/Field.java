package robofight;

public class Field {

    private int coordinateRow;
    private int coordinateColumn;
    private String state;

    public Field() {
    }

    public Field(int coordinateRow, int coordinateColumn, String state) {
        this.coordinateRow = coordinateRow;
        this.coordinateColumn = coordinateColumn;
        this.state = state;
    }

    public Field(int coordinateRow, int coordinateColumn) {
        this.coordinateRow = coordinateRow;
        this.coordinateColumn = coordinateColumn;       
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCoordinateColumn() {
        return coordinateColumn;
    }

    public void setCoordinateColumn(int coordinateColumn) {
        this.coordinateColumn = coordinateColumn;
    }

    public int getCoordinateRow() {
        return coordinateRow;
    }

    public void setCoordinateRow(int coordinateRow) {
        this.coordinateRow = coordinateRow;
    }
}
