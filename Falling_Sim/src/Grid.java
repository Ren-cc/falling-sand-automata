import java.util.Arrays;

public class Grid {
    int gridCols;
    int gridRows;
    private Element[][] cells;


    //direction variables
    int N = 0;
    int NE = 1;
    int E = 2;
    int SE = 3;
    int S = 4;
    int SW = 5;
    int W = 6;
    int NW = 7;


    public Grid(int width, int height, int cellSize) {
        this.gridCols = width/cellSize;
        this.gridRows = height/cellSize;
        this.cells = new Element[gridRows][gridCols];
    }

    boolean isValidCell(int row, int col) {
        return row >= 0 && row < gridRows && col >= 0 && col < gridCols;
    }

    public void setCell(int row, int col, Element value) {
        if (isValidCell(row, col)) {
            cells[row][col] = value;
        }
    }

    public Element getCell(int row, int col) {
        if (isValidCell(row, col)) {
            return cells[row][col];
        }
        return null; // Default value for out-of-bounds cells
    }

    //returns boolean array if if particle can move in the 8 positions around it 
public Element[] getRadialProximity(int row, int col) {
    Element[] proximityArray = new Element[8];


    // North = 0
    if (row == 0 || cells[row - 1][col] == null) {
        proximityArray[N] = null;
    } else {
        proximityArray[N] = cells[row - 1][col];
    }
    // North East = 1
    if (row == 0 ||  col == gridCols-1 || cells[row - 1][col + 1] == null) {
        proximityArray[NE] = null;
    } else {
        proximityArray[NE] = cells[row - 1][col + 1];
    }
    // East = 2
    if (col == gridCols-1 || cells[row][col + 1] == null) {
        proximityArray[E] = null;
    } else {
        proximityArray[E] = cells[row][col + 1];
    }

    //South East = 3
    if (row == gridRows-1 || col == gridCols-1 || cells[row + 1][col + 1] == null) {
        proximityArray[SE] = null;
    } else {
     proximityArray[SE] = cells[row + 1][col + 1];
    }
    // South = 4
    if (row == gridRows-1 || cells[row + 1][col] == null) {
        proximityArray[S] = null;
    } else {
        proximityArray[S] = cells[row + 1][col];
    }
    // South West = 5
    if (row == gridRows-1  || col == 0 || cells[row + 1][col - 1] == null) {
        proximityArray[SW] = null;
    } else {
     proximityArray[SW] = cells[row + 1][col - 1];
    }
    // West = 6
    if (col == 0 || cells[row][col - 1] == null) {
       proximityArray[W] = null;
    } else {
       proximityArray[W] = cells[row][col - 1];
    }
    // North West = 7
    if (row == 0 || col == 0 || cells[row - 1][col - 1] == null) {
        proximityArray[NW] = null;
    } else {
     proximityArray[NW] = cells[row - 1][col - 1];
    }

    return proximityArray;
}
    



    //movement
    
    //swap 2 cells
    public void swapCells(int initialRow, int initialCol, int newRow, int newCol){
        if(isValidCell(newRow,newCol) == true){
            Element temp = getCell(newRow, newCol);
            
            cells[newRow][newCol] = cells[initialRow][initialCol];
            if(cells[initialRow][initialCol] != null){    
                cells[newRow][newCol].updateCoords(newRow, newCol);
            }
            cells[initialRow][initialCol] = temp;
            if(cells[initialRow][initialCol] != null){
                cells[initialRow][initialCol].updateCoords(initialRow, initialCol);
            }
        }
    }




}




