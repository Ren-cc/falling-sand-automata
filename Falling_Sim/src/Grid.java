public class Grid {
    int gridCols;
    int gridRows;
    private Element[][] cells;


    public Grid(int width, int height, int cellSize) {
        this.gridCols = width/cellSize;
        this.gridRows = height/cellSize;
        this.cells = new Element[gridRows][gridCols];
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

    // if(row < 0 || row > gridRows || col < 0 || col > gridCols || cells[row][col] != null){
    //     proximityArray[0] = false;
    // }

    public boolean[] getRadialProximity(int row, int col){
        boolean[] proximityArray = new boolean[7];
            //North = 0
            if(row - 1 < 0 || cells[row][col] != null){
                proximityArray[0] = false;
            }else{
                proximityArray[0] = true;
            }
            // North East = 1
            if(row-1 < 0 || col+1 > gridCols || cells[row][col] != null){
                proximityArray[1] = false;
            }else{
                proximityArray[1] = true;
            }
            //East = 2
            if(col + 1 > gridCols || cells[row][col] != null){
                proximityArray[2] = false;
            }else{
                proximityArray[2] = true;
            }
            //South East = 3
            if(row +1 > gridRows || col+1 > gridCols || cells[row][col] != null){
                proximityArray[3] = false;
            }else{
                proximityArray[3] = true;
            }
            //South = 4
            if(row + 1 > gridRows || cells[row][col] != null){
                proximityArray[4] = false;
            }else{
                proximityArray[4] = true;
            }
            //South West = 5
            if(row +1 > gridRows || col-1 < 0 || cells[row][col] != null){
                proximityArray[5] = false;
            }else{
                proximityArray[5] = true;
            }
            //West = 6
            if(col - 1 < 0 || cells[row][col] != null){
                proximityArray[6] = false;
            }else{
                proximityArray[6] = true;
            }
            //North West = 7
            if(row-1 < 0 || col-1 < 0 || cells[row][col] != null){
                proximityArray[7] = false;
            }else{
                proximityArray[7] = true;
            }

        return proximityArray;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < gridRows && col >= 0 && col < gridCols;
    }
}




