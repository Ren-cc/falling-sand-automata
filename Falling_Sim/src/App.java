import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 900;
        int boardHeight = 900;

        JFrame frame = new JFrame("frame");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SandSim sandSim = new SandSim(boardWidth, boardHeight);
        frame.add(sandSim);
        frame.pack();
    }
    
}
