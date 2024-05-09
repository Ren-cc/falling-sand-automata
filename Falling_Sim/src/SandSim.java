import java.awt.*;
import java.awt.event.*;
import java .util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.util.List;


public class SandSim extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 1;


    Timer gameLoop;
    static int delay = 10;
    static int refreshPS = 1000/ delay;
    
    Grid grid;
    boolean mousePressed;
    boolean mousePressedRight;
    
    ArrayList<Element> elementArray;

    Random random;

    SandSim(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        //setBackground(new Color(0xE5E4E2));

        


        // Add mouse listener to the panel
        addMouseListener(this);
        addMouseMotionListener(this);

        //game timer
		gameLoop = new Timer(delay, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();


        grid = new Grid(boardWidth, boardHeight, tileSize);

        elementArray = new ArrayList<>();

        random = new Random();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);


    }

    public void draw(Graphics g){
        for(int i = 0; i < grid.gridRows; i++){
            for(int j = 0; j < grid.gridCols; j++){
                
                if(grid.getCell(j, i) != null){


                    g.setColor(new Color(grid.getCell(j, i).color));

                    g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
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



        if (e.getButton() == MouseEvent.BUTTON1) {
            // Left mouse button clicked

            for(int i = -5; i < 5; i+=2){
                for(int j = -5; j < 5; j+=2){
                    if(grid.getCell(clickedY + i, clickedX + j) instanceof Sand == false){
                        elementArray.add(new Sand(clickedY + i, clickedX + j, grid));

                    }  
                }
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            // Right mouse button clicked

            for(int i = -5; i < 5; i+=2){
                for(int j = -5; j < 5; j+=2){
                    if(grid.getCell(clickedY + i, clickedX + j) instanceof Water == false){
                        elementArray.add(new Water(clickedY + i, clickedX + j, grid));
                        repaint();
                    } 
                }
            }
        }

        repaint();
        
                
    }

    @Override
    public void mousePressed(MouseEvent e) {
        

        if (e.getButton() == MouseEvent.BUTTON1) {
            mousePressed = true;
            
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mousePressedRight = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
        mousePressedRight = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mousePressed || mousePressedRight) {
            // Get the clicked position
            int clickedX = e.getX() / tileSize;
            int clickedY = e.getY() / tileSize;

            // Create a new sand element at the clicked position
            if (mousePressed) {
                // Left mouse button clicked

                for(int i = -5; i < 5; i+=2){
                    for(int j = -5; j < 5; j+=2){
                        if(grid.getCell(clickedY + i, clickedX + j) instanceof Sand == false){
                            elementArray.add(new Sand(clickedY + i, clickedX + j, grid));
                            repaint();
                        }  
                    }
                }
            } else if (mousePressedRight) {
                // Right mouse button clicked
                for(int i = -5; i < 5; i+=2){
                    for(int j = -5; j < 5; j+=2){
                        if(grid.getCell(clickedY + i, clickedX + j) instanceof Water == false){
                            elementArray.add(new Water(clickedY + i, clickedX + j, grid));
                            repaint();
                        } 
                    }
                }
            }
            repaint();
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
