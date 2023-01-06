package enemy;

import java.awt.geom.Rectangle2D;

public class Entity {

    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected Rectangle2D.Float hitbox;

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

}
