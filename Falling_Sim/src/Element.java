public abstract class Element {
     protected int rowPos;
     protected int colPos;
     public int color;
     public int density;


     Element(int rowPos, int colPos, Grid g){
        this.rowPos = rowPos;
        this.colPos = colPos;


        g.setCell(rowPos, colPos,this);
        
    }

    Element(int rowPos, int colPos, String color, Grid g){
        this.rowPos = rowPos;
        this.colPos = colPos;


        g.setCell(rowPos, colPos, this);
        
    }

    public void updateCoords(int newRow, int newCol){
        rowPos = newRow;
        colPos = newCol;
    }
    //basic movement 
    public abstract void moveSim(Grid grid);

    @Override
    public String toString() {
        
        return rowPos + " " + colPos + " ";
    }


}