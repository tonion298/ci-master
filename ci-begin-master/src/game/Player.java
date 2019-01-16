package game;

import game.enemy.EnemyBullet;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    Sphere sphereLeft;
    Sphere sphereRight;
    BoxColider boxColider;
    FrameCounter fireCounter;
    boolean immune;
    int hp;
    public Player() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new Animation(images);
        this.position.set(200, 400);
        this.sphereLeft = new Sphere();
        this.sphereRight = new Sphere();
        this.updateSpherePosition();
        this.boxColider = new BoxColider(this, 32, 48);
        this.fireCounter = new FrameCounter(20);
        this.hp = 3;
        this.immune = false;
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.limitPosition();
        this.fire();
        this.updateSpherePosition();
        this.checkImmune();
    }


    int immuneCount; //TODO: thay bang frameCounter
    private void checkImmune() {
        if (this.immune)
        {
            this.immuneCount++;
            if (this.immuneCount > 60)
            {
                this.immune = false;
                this.immuneCount = 0;
            }
        }
    }


    private void updateSpherePosition() {
        this.sphereLeft.position.set(this.position)
                    .add(-30, 15);
        this.sphereRight.position.set(this.position)
                    .add(30, 15);
    }

    private void fire() {
        if(fireCounter.run()) {
            if(GameWindow.isFirePress) {
                float startAngle =  -(float)Math.PI / 4;
                float endAngle = -3 * (float)Math.PI / 4;
                float offset = (endAngle - startAngle) / 4;
                for (int i = 0; i < 5; i++) {
                    PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                    bullet.position.set(this.position.x - 15, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.fireCounter.reset();
                }
            }
        }
    }

    private void limitPosition() {
        if (this.position.y < 25) {
            this.position.set(this.position.x, 25);
        }
        if (this.position.y > 600 - 36) {
            this.position.set(this.position.x, 600 - 36);
        }
        if (this.position.x < 36) {
            this.position.set(36, this.position.y);
        }
        if (this.position.x > 384 - 38) {
            this.position.set(384 - 38, this.position.y);
        }
    }

    private void move() {
        float vX = 0;
        float vY = 0;
        if (GameWindow.isUpPress) {
            vY = -5;
        }
        if (GameWindow.isDownPress) {
            vY = 5;
        }
        if (GameWindow.isLeftPress) {
            vX = -5;
        }
        if (GameWindow.isRightPress) {
            vX = 5;
        }
        this.velocity.set(vX, vY).setLength(5);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

    public void takeDamage(int damage) {
        if(this.immune)
        {
            return;
        }
        this.hp -= damage;
        if (this.hp <= 0 )
        {
            this.hp = 0;
            this.deactive();
            this.sphereRight.deactive();
            this.sphereLeft.deactive();
        }
        else
        {
            this.immune = true;
        }
    }

    int count; // thay bang frameCounter
    @Override
    public void render(Graphics g) {
        if (this.immune)
        {
            this.count++;
            if (this.count > 2)
            {
                super.render(g);
                this.count = 0;
            }
        }
        else
        {
            super.render(g);
        }
    }
}
