package base;

import enemy.Player;

import java.awt.*;

public class Game implements Runnable {

    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Player player;
    private Thread gameThread;

    public Game(){
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        player = new Player(100,100,50,50);
        startGameLoop();
    }

    public Player getPlayer() {
        return player;
    }

    public void render(Graphics graphics) {
        player.render(graphics);
    }


    private void update() {
        player.update();
    }


    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        while (true) {
            update();
        }

    }


}
