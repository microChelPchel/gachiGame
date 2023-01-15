package base;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

import static utils.Constants.HEIGHT_WINDOW;
import static utils.Constants.WIDTH_WINDOW;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        setInputs();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW);
        setPreferredSize(size);
    }

    private void setInputs() {
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        game.render(graphics);
    }

    public Game getGame() {
        return game;
    }

}
