package base;

import utils.BaseHelper;

import javax.swing.*;

import static utils.Constants.ICON_GAME;

public class GameWindow {

    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setIconImage(new ImageIcon(BaseHelper.GetSpriteAtlas(ICON_GAME)).getImage());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }


}
