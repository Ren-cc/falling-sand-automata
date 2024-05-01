public abstract class Element {
     private int rowPos;
     private int colPos;


     Element(int rowPos, int colPos, Grid g){
        this.rowPos = rowPos;
        this.colPos = colPos;


        g.setCell(rowPos, colPos,this);
        
    }

    Element(int rowPos, int colPos, String elementName, String color, Grid g){
        this.rowPos = rowPos;
        this.colPos = colPos;


        g.setCell(rowPos, colPos, this);
        
    }
    //basic movement 
    public abstract void move(Grid grid);


}