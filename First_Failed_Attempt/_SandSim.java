// import java.awt.*;
// import java.awt.event.*;
// import java .util.ArrayList;
// import java.util.Random;
// import javax.swing.*;



// public class SandSim extends JPanel implements ActionListener, MouseListener {
//     int boardWidth;
//     int boardHeight;
//     int tileSize = 30;
//     Grid grid;

//     Timer gameLoop;



//     SandSim(int boardWidth, int boardHeight){
//         this.boardWidth = boardWidth;
//         this.boardHeight = boardHeight;
//         setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
//         setBackground(Color.black);

//         grid = new Grid((this.boardWidth/tileSize), (this.boardHeight/tileSize));


//         // Add mouse listener to the panel
//         addMouseListener(this);

//         //game timer
// 		gameLoop = new Timer(100, this); //how long it takes to start timer, milliseconds gone between frames 
//         gameLoop.start();





//     }

//     public void paintComponent(Graphics g){
//         super.paintComponent(g);
//         draw(g);


//     }

//     public void draw(Graphics g){

         

//         for(int i = 0; i < grid.numRows; i++){
//             for(int j = 0; j < grid.numCols; j++){
//                 if(grid.isTileActive(j, i) == false){
//                     g.setColor(Color.green);
//                     g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
//                     g.setColor(Color.BLACK);
//                     g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);
                    
//                     Element element = grid.getTileElement(i, j);
                    
//                 if (element instanceof Sand) {
//                        g.setColor(Color.BLUE);
//                        g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
//                     }
//                 }
//                 else{
//                     g.setColor(Color.red);
//                     g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
//                 }
//             }
//         }
//     }


//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // Move all sand particles
//         boolean moved = false;
        
//             for (int row = 0; row < grid.numRows; row++) {
//                 for (int col = 0; col < grid.numCols; col++) {
//                     Element element = grid.getTileElement(row, col);
//                     if (element instanceof Sand) {
//                         element.move(grid);
//                         moved = true;
//                         repaint();
//                         break;
//                     }
//                     if(moved){
//                         repaint();
//                         break;
//                     }
                
//             }
           
        
//         repaint();
//     }

//        //if (gameOver) {
//         //    gameLoop.stop();
//         //}
//     }

//     @Override
//     public void mouseClicked(MouseEvent e) {
//                 // Get the clicked position
//                 int clickedX = e.getX() / tileSize;
//                 int clickedY = e.getY() / tileSize;
        
//                 // Create a new sand element at the clicked position
//                 grid.setTile(clickedY, clickedX, new Sand(clickedY, clickedX, grid));
//                 repaint();
        
                
//     }

//     @Override
//     public void mousePressed(MouseEvent e) {

//     }

//     @Override
//     public void mouseReleased(MouseEvent e) {

//     }

//     @Override
//     public void mouseEntered(MouseEvent e) {

//     }

//     @Override
//     public void mouseExited(MouseEvent e) {

//     }

// }
