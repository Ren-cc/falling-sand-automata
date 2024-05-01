// public class Grid {
//     private Tile[][] tiles;
//     public int numRows;
//     public int numCols;

//     public Grid(int rows, int cols){
//         this.numRows = rows;
//         this.numCols = cols;
//         //sets up grid
//         tiles = new Tile[rows][cols];
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 tiles[i][j] = new Tile(); 
//             }
//         }
//     }

//     //sets a tile to active and gives a type
//     public void setTile(int row, int col, Element element){
//         tiles[row][col].setElement(element);
//         tiles[row][col].setActive(true);
//     }
//     //removes tile at location
//     public void unsetTile(int row, int col){
//         tiles[row][col].setElement(null);
//         tiles[row][col].setActive(false);
//     }

//     public boolean isTileActive(int row, int col){
//         return  tiles[row][col].isActive();
//     }

//     public Element getTileElement(int row, int col){
//         return  tiles[row][col].getElement();
//     }

//     public Tile[][] getTilesArray(){
//         return tiles;
//     }

//     //directional checkers

    


//     //tile class
//     private class Tile{
//         private Element element;
//         private boolean active;
        
//         Tile() {
//             element = null;
//             this.active = false;
//         }

//         //getters and setters for tyle 
//         public Element getElement() {
//             return element;
//         }
//         public void setElement(Element element) {

//             this.element = element;
//         }

//         public boolean isActive() {
//             return active;
//         }
//         public void setActive(boolean active) {
//             this.active = active;
//         }

//     }
// }
