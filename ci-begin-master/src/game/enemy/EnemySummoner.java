package game.enemy;

import game.FrameCounter;
import game.GameObject;

public class EnemySummoner extends GameObject {
    FrameCounter summonCounter;

    public EnemySummoner() {
        this.summonCounter = new FrameCounter(60);
    }

    @Override
    public void run() {
        super.run();
        this.summonEnemy();
    }

    private void summonEnemy() {
        if (this.summonCounter.run()) {
            Enemy enemy = GameObject.recycle(Enemy.class);
            enemy.position.set(30, -30);
            this.summonCounter.reset();
        }

    }
}
