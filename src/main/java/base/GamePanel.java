package base;

import javax.swing.*;
import java.awt.*;

import static utils.Constants.HEIGHT_WINDOW;
import static utils.Constants.WIDTH_WINDOW;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW);
        setPreferredSize(size);
    }

}
