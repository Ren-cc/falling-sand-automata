import java.awt.*;
import java.awt.event.*;
import java .util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.util.List;


public class SandSim extends JPanel implements ActionListener, MouseListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 30;


    Timer gameLoop;
    Grid grid;
    
    ArrayList<Element> elementArray;


    SandSim(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        


        // Add mouse listener to the panel
        addMouseListener(this);

        //game timer
		gameLoop = new Timer(100, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();


        grid = new Grid(boardWidth, boardHeight, 30);

        elementArray = new ArrayList<>();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);


    }

    public void draw(Graphics g){
        for(int i = 0; i < grid.gridRows; i++){
            for(int j = 0; j < grid.gridCols; j++){
                
                if(grid.getCell(j, i) instanceof Sand){
                    g.setColor(Color.WHITE);
                    g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
                }
                else if (grid.getCell(j, i) == null){
                    g.setColor(Color.BLACK);
                    g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);
                }

                    
            }
        }
    }
        


    @Override
    public void actionPerformed(ActionEvent e) {
        // Move all sand particles
        for(int i = 0; i < elementArray.size(); i++){
            elementArray.get(i).moveSim(grid);
        }
        
        repaint();
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                // Get the clicked position
                int clickedX = e.getX() / tileSize;
                int clickedY = e.getY() / tileSize;
        
                // Create a new sand element at the clicked position
                elementArray.add(new Sand(clickedY, clickedX, grid));

                
                grid.getRadialProximity(elementArray.get(0).rowPos, elementArray.get(0).colPos);
                if(elementArray.size() > 1){
                    //grid.getRadialProximity(elementArray.get(1).rowPos, elementArray.get(1).colPos);
                }
        
                
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
