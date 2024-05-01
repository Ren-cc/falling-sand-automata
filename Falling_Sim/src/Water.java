import java.util.Random;

public class Water extends Element {
    Random random = new Random();

    Water(int rowPos, int colPos, Grid g) {
        super(rowPos, colPos, g);

        int randomColor = random.nextInt(3);
        switch(randomColor){
            case 0:
                super.color = 0x2389da;
                break;
            case 1:
                super.color = 0x1ca3ec;
                break;
            case 2:
            super.color = 0x74ccf4;
                break;
        }

        super.density = 997;

        
        
    }

    @Override
    public void moveSim(Grid grid) {
        int randomNum = random.nextInt(2);

        Element[] proximityArr = grid.getRadialProximity(this.rowPos, this.colPos);
        //if down is free go down
        if(proximityArr[4] == null){
           grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos);
        }else{
            //water specific movement refactor this shit plz future me 
            //check west
            if((proximityArr[6] == null)){
               // while((grid.isValidCell(this.rowPos,this.colPos-1))){    
                    grid.swapCells(this.rowPos, this.colPos, this.rowPos, this.colPos-1);
                //}
            }
            //check density
            if(proximityArr[6] != null && proximityArr[6].density < this.density){
               // while((grid.isValidCell(this.rowPos,this.colPos -1)))    
                    grid.swapCells(this.rowPos, this.colPos, this.rowPos, this.colPos -1);
                //}
            }
            //check east
            if((proximityArr[2] == null )){
                //while((grid.isValidCell(this.rowPos,this.colPos + 1))){
                    grid.swapCells(this.rowPos, this.colPos, this.rowPos, this.colPos + 1);
                //}
            }
            //check density
            if(proximityArr[2] != null && proximityArr[2].density < this.density){
               // while((grid.isValidCell(this.rowPos,this.colPos + 1))){
                    grid.swapCells(this.rowPos, this.colPos, this.rowPos, this.colPos + 1);
                //}
            }


            //downward movement

            //if not then check south west
            if((proximityArr[5] == null && (proximityArr[3] != null || randomNum == 0))){
                grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos-1);
            
            }
            //compare density if other element there
            if(proximityArr[5] != null && proximityArr[5].density < this.density){
                grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos-1);
            }
            //if not then check south east
            if((proximityArr[3] == null && (proximityArr[5] != null || randomNum == 1))){
                grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos+1);
            }
            //compare density if other element there
            if(proximityArr[3] != null && proximityArr[3].density < this.density ){
                grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos+1);
            }






        }
        if(proximityArr[4] != null && proximityArr[4].density < this.density){
            grid.swapCells(this.rowPos, this.colPos, this.rowPos + 1, this.colPos);
        }
    }
    
    
}