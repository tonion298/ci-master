package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, Setting.SCREEN_HEIGHT - image.getHeight());
        this.velocity.set(0, 1);
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        super.run();
        // TODO: gioi han di chuyen cho Background
        this.limitPositon();
    }

    private void limitPositon() {
        if (this.position.y > 0) {
            this.position.set(0, 0);
            this.velocity.set(0, 0);
        }
    }
}
