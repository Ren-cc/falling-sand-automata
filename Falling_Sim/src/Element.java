public abstract class Element {
     protected int rowPos;
     protected int colPos;
     public int color;
     public int density;
     public int accelerationX;
     public int accelerationY;
     public final int GRAVIT_CONST = 1;


     Element(int rowPos, int colPos, Grid g){
        this.rowPos = rowPos;
        this.colPos = colPos;


        g.setCell(rowPos, colPos,this);

        accelerationX = 0;
        accelerationY = 0;
        
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

    //moves the elements 
    public abstract void moveSim(Grid grid);

    //checks next available block 
    public abstract int[] xyNextPosition(Grid grid);

    @Override
    public String toString() {
        
        return rowPos + " " + colPos + " ";
    }


}