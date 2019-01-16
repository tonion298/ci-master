package physics;

import game.GameObject;
import game.Vector2D;

public class BoxColider {
    Vector2D position;
    int width;
    int height;
    Vector2D anchor;

    public BoxColider(GameObject master, int width, int height) {
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    public boolean intersected(BoxColider other) {
        return this.top() <= other.bot()
                && this.bot() >= other.top()
                && this.right() >= other.left()
                && this.left() <= other.right();
    }

}
