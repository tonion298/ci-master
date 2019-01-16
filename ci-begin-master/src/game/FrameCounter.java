package game;

public class FrameCounter {
    int count;
    int countMax;

    public FrameCounter(int countMax) {
        this.countMax = countMax;
        this.count = 0;
    }

    public boolean run() {
        if (this.count >= this.countMax) {
            return true;
        }
        count++;
        return false;
    }

    public void reset() {
        this.count = 0;
    }
}
