import java.awt.*;
import java.awt.event.*;
import java .util.ArrayList;
import java.util.Random;
import javax.swing.*;



public class SandSim extends JPanel implements ActionListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 30;
    Grid grid;

    Timer gameLoop;

    SandSim(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        grid = new Grid((this.boardWidth/tileSize), (this.boardHeight/tileSize));

        //game timer
		gameLoop = new Timer(100, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);


    }

    public void draw(Graphics g){



        for(int i = 0; i < grid.numRows; i++){
            for(int j = 0; j < grid.numCols; j++){
                if(grid.isTileActive(j, i) == false){
                    g.setColor(Color.green);
                    g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);

                }
                else{
                    g.setColor(Color.red);
                    g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
                }
            }
        }
    }

    int temp = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        temp += 1;
        grid.setTile(2 + temp,2, "sand");

        grid.unsetTile(2 + temp-1, 2);
       //if (gameOver) {
        //    gameLoop.stop();
        //}
    }

}
