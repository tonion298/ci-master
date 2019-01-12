package physics;

import game.Vector2D;

public class BoxColider {
    Vector2D position;
    int width;
    int height;

    public BoxColider(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x;
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
