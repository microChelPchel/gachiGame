package base;

public class Game {

    private GamePanel gamePanel;
    private GameWindow gameWindow;

    public Game(){
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }

}
