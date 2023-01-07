package enemy;

import utils.BaseHelper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private boolean up;
    private boolean left;
    private boolean down;
    private boolean right;
    private float playerSpeed = 1.5f;
    private BufferedImage[] animationsIdle;
    private int aniTick, aniIndex, aniSpeed = 25;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        loadAnimation();
        initHitbox(x, y, width, height);
    }

    public void render(Graphics graphics) {
        //update x,y?
        graphics.drawRect((int) (x + hitbox.x), (int) (y + hitbox.y), (int) hitbox.width, (int) hitbox.height);
        graphics.drawImage(animationsIdle[aniIndex],300,300,null);
    }

    private void updateAnimation() {
        //need add run and change animation
        updateAnimationTick();
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex>=4) {
                aniIndex=0;
            }
        }

    }

    private void loadAnimation() {
        loadIdleAni();
    }

    private void loadIdleAni() {
        BufferedImage img = BaseHelper.GetSpriteAtlas(BaseHelper.PLAYER_IDLE);
        animationsIdle = new BufferedImage[4];
        for (int i = 0; i < animationsIdle.length; i++)
            animationsIdle[i] = img.getSubimage(i * 200, 0, 200, 200);
    }

    public void update() {
        updatePosition();
        updateAnimation();
    }

    private void updatePosition() {
        float xSpeed = 0;
        float ySpeed = 0;
        if (!right && !left && !up && !down) {
            return;
        }

        if (left && !right) {
            xSpeed -= playerSpeed;
        } else if (right && !left) {
            xSpeed += playerSpeed;
        }

        if (down && !up) {
            ySpeed -= playerSpeed;
        } else if (!down && up) {
            ySpeed += playerSpeed;
        }

        //Should check collision
        hitbox.x += xSpeed;
        hitbox.y += ySpeed;

    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
