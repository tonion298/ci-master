package game.enemy;

import game.GameObject;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject implements Physics {
    BoxColider boxColider;
    int damage;

    public EnemyBullet() {
        super();
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        this.velocity.set(0, 4);
        boxColider = new BoxColider(this, 20, 20);
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersected(Player.class, this.boxColider);
        if (player != null) {
            this.deactive();
            player.takeDamage(this.damage);
        }
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.y > 900) {
            this.deactive();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
