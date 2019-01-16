package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image
                , (int)(master.position.x - master.anchor.x * this.image.getWidth())
                , (int)(master.position.y - master.anchor.y *this.image.getHeight())
                , null);
    }
}
