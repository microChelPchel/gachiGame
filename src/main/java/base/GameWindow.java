package base;

import javax.swing.*;

import static utils.Constants.FILE_PATH;

public class GameWindow {


    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setIconImage(new ImageIcon(FILE_PATH).getImage());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }


}
