package robofight;

public class Arena {    
    
    private Field[][] board;
    private int sizeRow;
    private int sizeColumn;

    public Arena() {
    }
    
    public Arena(int sizeRow, int sizeColumn) {
        this.sizeRow = sizeRow;
        this.sizeColumn = sizeColumn;
        board = new Field[sizeRow][sizeColumn];
        for (int row = 0; row < sizeRow; row++) {
            for (int column = 0; column < sizeColumn; column++) {
                board[row][column] = new Field(sizeRow, sizeColumn, ".");
            }
        }
    }
    
    public void setField(int row, int column, String s){
        board[row][column].setCoordinateRow(row);
        board[row][column].setCoordinateColumn(column);
        board[row][column].setState(s);
    }
    
    public Field getField(int row, int column){
        return board[row][column];
    }      
  
    public void draw(){
        for (int i = 0; i <= sizeColumn+1; i++) {
            System.out.print("#");
        }        
        System.out.println("");        
        for (int i = 0; i < sizeRow; i++) {
            System.out.print("#");
            for (int j = 0; j < sizeColumn; j++) {
                System.out.print(board[i][j].getState());
                }
            System.out.println("#");
        }        
        for (int i = 0; i <= sizeColumn+1; i++) {
            System.out.print("#");
        } 
        System.out.println("");
    }

    public Field[][] getBoard() {
        return board;
    }

    public void setBoard(Field[][] board) {
        this.board = board;
    }

    public int getSizeRow() {
        return sizeRow;
    }

    public void setSizeRow(int sizeRow) {
        this.sizeRow = sizeRow;
    }

    public int getSizeColumn() {
        return sizeColumn;
    }

    public void setSizeColumn(int sizeColumn) {
        this.sizeColumn = sizeColumn;
    }
            
}
