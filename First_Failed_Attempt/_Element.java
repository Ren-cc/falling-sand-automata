// public abstract class Element {
//     private int rowPos;
//     private int colPos;
//     private String elementName;
//     private String color;


//     Element(int rowPos, int colPos, Grid g){
//         this.rowPos = rowPos;
//         this.colPos = colPos;
//         this.elementName = "";
//         this.color = "black";

//         g.setTile(rowPos, colPos, this);
        
//     }

//     Element(int rowPos, int colPos, String elementName, String color, Grid g){
//         this.rowPos = rowPos;
//         this.colPos = colPos;
//         this.elementName = elementName;
//         this.color = color;

//         g.setTile(rowPos, colPos, this);
        
//     }
//     //basic movement 
//     public abstract void move(Grid grid);


//     //getters and setters
//     public int getRowPos() {
//         return rowPos;
//     }

//     public void setRowPos(int rowPos) {
//         this.rowPos = rowPos;
//     }
//     public int getColPos() {
//         return colPos;
//     }

//     public void setColPos(int colPos) {
//         this.colPos = colPos;
//     }
//     public String getElementName() {
//         return elementName;
//     }

//     public void setElementName(String elementName) {
//         this.elementName = elementName;
//     }
//     public String getColor() {
//         return color;
//     }
//     public void setColor(String color) {
//         this.color = color;
//     }

    
// }
