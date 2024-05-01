import java.awt.*;
import java.awt.event.*;
import java .util.ArrayList;
import java.util.Random;
import javax.swing.*;



public class SandSim extends JPanel implements ActionListener, MouseListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 30;


    Timer gameLoop;



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





    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);


    }

    public void draw(Graphics g){

        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Move all sand particles

        
        repaint();
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                // Get the clicked position
                int clickedX = e.getX() / tileSize;
                int clickedY = e.getY() / tileSize;
        
                // Create a new sand element at the clicked position

        
                
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
