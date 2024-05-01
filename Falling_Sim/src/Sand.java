
import java.util.Random;

public class Sand extends Element {
    Random random = new Random();

    Sand(int rowPos, int colPos, Grid g) {
        super(rowPos, colPos, g);

        int randomColor = random.nextInt(3);
        switch(randomColor){
            case 0:
                super.color = 0xf6d7b0;
                break;
            case 1:
                super.color = 0xeccca2;
                break;
            case 2:
            super.color = 0xe1bf92;
                break;
        }

        super.density = 1602;


        
        
    }

    @Override
    public void moveSim(Grid grid) {
    int randomNum = random.nextInt(2);

    Element[] proximityArr = grid.getRadialProximity(this.rowPos, this.colPos);
    if(proximityArr[4] == null){
       grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos);
    }else{
        if((proximityArr[5] == null && (proximityArr[3] != null || randomNum == 0))){
            grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos-1);
        
        }
        if(proximityArr[5] != null && proximityArr[5].density < this.density){
            grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos-1);
        }
        if((proximityArr[3] == null && (proximityArr[5] != null || randomNum == 1))){
            grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos+1);
        }
        if(proximityArr[3] != null && proximityArr[3].density < this.density ){
            grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos+1);
        }
    }
    if(proximityArr[4] != null && proximityArr[4].density < this.density){
        grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos);
    }
}
    
}