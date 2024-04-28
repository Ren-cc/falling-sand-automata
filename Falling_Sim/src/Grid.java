public class Grid {
    private Tile[][] tiles;
    public int numRows;
    public int numCols;

    public Grid(int rows, int cols){
        this.numRows = rows;
        this.numCols = cols;
        //sets up grid
        tiles = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = new Tile(); 
            }
        }
    }

    //sets a tile to active and gives a type
    public void setTile(int row, int col, String type){
        tiles[row][col].setType(type);
        tiles[row][col].setActive(true);
    }
    //removes tile at location
    public void unsetTile(int row, int col){
        tiles[row][col].setType("");
        tiles[row][col].setActive(false);
    }

    public boolean isTileActive(int row, int col){
        return  tiles[row][col].isActive();
    }


    //tile class
    private class Tile{
        private String type;
        private boolean active;
        
        Tile() {
            this.type = "";
            this.active = false;
        }

        //getters and setters for tyle 
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }

        public boolean isActive() {
            return active;
        }
        public void setActive(boolean active) {
            this.active = active;
        }

    }
}
