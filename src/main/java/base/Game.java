package base;

import enemy.Player;

import java.awt.*;

public class Game implements Runnable {

    private final int FPS_SET = 120;
    private final int UPS_SET =200;

    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Player player;
    private Thread gameThread;

    public Game(){
        player = new Player(100,100,50,50);
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
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

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }


}
