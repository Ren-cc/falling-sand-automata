
import java.util.Random;

public class Sand extends Element {
    Random random = new Random();
    int accelerationDelay = 2;


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


    //all particles should move like this. add to abstract and only have xyNextPos be in child classes
    
    @Override
    public void moveSim(Grid grid) {
        

            int[] nextPos = xyNextPosition(grid);
            for(int i = 0; i <= Math.max(accelerationX, super.accelerationY); i++){
                grid.swapCells(this.rowPos, this.colPos, this.rowPos + nextPos[1], this.colPos + nextPos[0]);
             
                if(super.accelerationX == 0 && super.accelerationY == 0){
                    break;
                }
       
            
            }


    
}

    int secondDelayCount;
    @Override
    public int[] xyNextPosition(Grid grid) {
        int randomNum = random.nextInt(2);
        int[] posArray = {0,0};

        Element[] proximityArr = grid.getRadialProximity(this.rowPos, this.colPos);
        if(proximityArr[4] == null){
            // <0,1>
            if(secondDelayCount == accelerationDelay){
                accelerationY += super.GRAVIT_CONST;
            }else{
                secondDelayCount++;
            }
            posArray[1]++;
            return posArray;
        }else{
            if(proximityArr[5] == null && (proximityArr[3] != null || randomNum == 0 )){
                // <-1,1>
                if(secondDelayCount == accelerationDelay){
                    accelerationX += super.GRAVIT_CONST;
                    accelerationY += super.GRAVIT_CONST;
                }else{
                    secondDelayCount++;
                }
                posArray[1]++;
                posArray[0] = -1;
                return posArray;
            
            }
            if(proximityArr[5] != null && proximityArr[5].density < this.density){
                // <-1,1>
                // accelerationX += super.GRAVIT_CONST;
                // accelerationY += super.GRAVIT_CONST;
                posArray[1]++;
                posArray[0] = -1;
                return posArray;
            }
            if(proximityArr[3] == null && (proximityArr[5] != null || randomNum == 1 )){
                // <1,1>
                if(secondDelayCount == accelerationDelay){
                    accelerationX += super.GRAVIT_CONST;
                    accelerationY += super.GRAVIT_CONST;
                }else{
                    secondDelayCount++;
                }
                posArray[1]++;
                posArray[0]++;
                return posArray;
            }
            if(proximityArr[3] != null && proximityArr[3].density < this.density ){
                // <1,1>
                // accelerationX += super.GRAVIT_CONST;
                // accelerationY += super.GRAVIT_CONST;
                posArray[1]++;
                posArray[0]++;
                return posArray;
            }
        }
        if(proximityArr[4] != null && proximityArr[4].density < this.density){
            // <0,1>
            if(secondDelayCount == accelerationDelay){
                accelerationY += super.GRAVIT_CONST;
            }else{
                secondDelayCount++;
            }
            posArray[1]++;
            return posArray;
            
        }
        super.accelerationX = 0;
        super.accelerationY = 0;
        return posArray;
    }
    
}