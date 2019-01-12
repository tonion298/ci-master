import game.Vector2D;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle(float x, float y, int width, int height) {
        this.position = new Vector2D(x, y);
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

    public boolean intersected(Rectangle other) {
        return this.top() <= other.bot()
            && this.bot() >= other.top()
            && this.right() >= other.left()
            && this.left() <= other.right();
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0, 0, 4, 4);
        Rectangle rect2 = new Rectangle(5, 5, 4, 4);
        Rectangle rect3 = new Rectangle(2, 2, 4, 4);
        System.out.println(rect1.intersected(rect2)); // false
        System.out.println(rect1.intersected(rect3)); // true
        System.out.println(rect2.intersected(rect3)); // true
    }
}
