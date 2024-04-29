public class Sand extends Element {

    Sand(int rowPos, int colPos, Grid g) {
        super(rowPos, colPos, "Sand", "White", g);
        
    }

    @Override
    public void move(Grid grid) {
          int currentRow = super.getRowPos();
         int currentCol = super.getColPos();
        
         // Check if the tile below is within the grid bounds and empty
          if (currentRow + 1 < grid.numRows && !grid.isTileActive(currentRow + 1, currentCol)) {
              // Move the sand to the tile below
              super.setRowPos(currentRow + 1);
              grid.setTile(currentRow + 1, currentCol, this);
              grid.unsetTile(currentRow, currentCol);
         }
    }
    
    
}
