package game;

import game.player.Player;
import game.enemy.EnemySummoner;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(EnemySummoner.class);
//        new Background();
//        new player();
//        Enemy enemy = new Enemy();
//       enemy.position.set(100, 200);
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
