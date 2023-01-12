package enemy;

import utils.BaseHelper;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.AnimationPlayerConstants.IDLE;
import static utils.AnimationPlayerConstants.RUN;
import static utils.Constants.PLAYER_IDLE;
import static utils.Constants.PLAYER_RUN;

public class Player extends Entity {

    private boolean up;
    private boolean left;
    private boolean down;
    private boolean right;
    private boolean moving = false;

    private int playerAction = IDLE.getValue();
    private float playerSpeed = 1.5f;
    private BufferedImage[] animationsIdle;
    private BufferedImage[] animationsRun;
    private int aniTick, aniIndex, aniSpeed = 25;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        loadAnimation();
        initHitbox(x, y, width, height);
    }

    public void render(Graphics graphics) {
        //render to factory class and create in enum two params
        BufferedImage [] currentAnimations = null;
        switch (playerAction) {
            case 1:
                currentAnimations = animationsRun;
            case 0:
            default:
                currentAnimations = animationsIdle;
        }


        //update x,y?
        graphics.drawImage(currentAnimations[aniIndex],
                (int) (x + hitbox.x),
                (int) (y + hitbox.y),
                (int) hitbox.width,
                (int) hitbox.height,
                null);
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
            if (aniIndex >= 4) {
                aniIndex = 0;
            }
        }
    }

    public void update() {
        updatePosition();
        updateAnimation();
        setAnimation();
    }

    private void setAnimation() {
        int startAni = playerAction;
        if (moving) {
            playerAction = RUN.getValue();
        } else {
            playerAction = IDLE.getValue();
        }

        if (startAni != playerAction)
            resetAniTick();
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void loadAnimation() {
        loadIdleAni();
        loadRunAni();
    }

    private void loadIdleAni() {
        BufferedImage img = BaseHelper.GetSpriteAtlas(PLAYER_IDLE);
        animationsIdle = new BufferedImage[4];
        for (int i = 0; i < animationsIdle.length; i++)
            animationsIdle[i] = img.getSubimage(i * 200, 0, 200, 200);
    }

    private void loadRunAni() {
        BufferedImage img = BaseHelper.GetSpriteAtlas(PLAYER_RUN);
        animationsRun = new BufferedImage[8];
        for (int i = 0; i < animationsRun.length; i++)
            animationsRun[i] = img.getSubimage(i * 200, 0, 200, 200);
    }

    private void updatePosition() {
        moving = false;
        float xSpeed = 0;
        float ySpeed = 0;
        if (!right && !left && !up && !down) {
            return;
        }

        if (left && !right) {
            xSpeed -= playerSpeed;
            moving = true;
        } else if (right && !left) {
            xSpeed += playerSpeed;
            moving = true;
        }

        if (down && !up) {
            ySpeed += playerSpeed;
        } else if (!down && up) {
            ySpeed -= playerSpeed;
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
