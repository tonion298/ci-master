package game.enemy;

import game.FrameCounter;
import physics.BoxColider;
import physics.Physics;
import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter fireCounter;
    FrameCounter enemyCounter;

    public Enemy() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images);
        this.boxColider = new BoxColider(this, 30, 30);
        fireCounter = new FrameCounter(20);
        enemyCounter = new FrameCounter(60);
        this.velocity.set(1,0);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
        this.autoMove();
        this.enemySummoner();
    }

    private void autoMove() {
        if (this.position.x  == 384 - 10)
        {
            this.velocity.set(-1,0);
        }
        if (this.position.x == 10)
        {
            this.velocity.set(1,0);
        }
    }

    private void enemySummoner()
    {
        if (enemyCounter.run())
        {
            Enemy enemy = GameObject.recycle(Enemy.class);
            enemy.position.set(this.position.x + 2, this.position.y);
            enemyCounter.reset();
        }
    }

    private void fire() {
        if (fireCounter.run()) {
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            fireCounter.reset();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
