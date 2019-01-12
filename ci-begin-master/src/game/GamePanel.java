package game;

import game.enemy.Enemy;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    public GamePanel() {
        new Background();
        new Player();
        Enemy enemy = new Enemy();
        enemy.position.set(100, 200);
    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastLoop > delay) {
                this.runAll(); // ~logic
                this.renderAll(); // ~render / hien thi
                lastLoop = currentTime;
            }
        }
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint(); // ~ paint()
    }

    @Override
    public void paint(Graphics g) {
        GameObject.renderAll(g);
    }
}
