public class Sand extends Element {

    Sand(int rowPos, int colPos, Grid g) {
        super(rowPos, colPos, g);
        
    }

    @Override
    public void moveSim(Grid grid) {
        Element[] proximityArr = grid.getRadialProximity(this.rowPos, this.colPos);
        if(proximityArr[4] == null){
           grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos);
        }
    }
    
    
}