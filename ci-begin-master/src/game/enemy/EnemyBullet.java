package game.enemy;

import game.GameObject;
import game.Player;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxColider boxColider;
    public EnemyBullet() {
        super();
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        this.velocity.set(0,2);
        boxColider = new BoxColider(this.position, 20, 20);
    }

    @Override
    public void run() {
        super.run();
//        Player player = GameObject.findIntersected(Player.class, this.boxColider);
//        if (player != null) {
//            player.deactive();
//        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
