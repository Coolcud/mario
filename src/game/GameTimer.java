package game;

/**
 * Manages the game so it runs at a uniform rate.
 * Created by Kneesnap on 3/4/2021.
 */
public class GameTimer {
    private int pendingUpdateCount;
    private int updateCount;
    private double currentTime;
    private double previousTime;
    private double unprocessedTime;

    private static final int FRAMES_PER_SECOND = 60;
    private static final double LOGIC_DELTA_TIME = 1D / FRAMES_PER_SECOND;

    /**
     * Gets the number of times the game update function has been executed.
     */
    public int getUpdateCount() {
        return this.updateCount;
    }

    /**
     * Starts the timer.
     */
    public void start() {
        if (this.currentTime != 0)
            throw new IllegalStateException("The timer has already been started, it cannot be started again.");

        this.currentTime = System.nanoTime() * 0.000000001;
        this.previousTime = (this.currentTime - LOGIC_DELTA_TIME);
    }

    /**
     * Updates the timer.
     */
    public void update() {
        this.currentTime = System.nanoTime() * 0.000000001;
        this.unprocessedTime += (this.currentTime - this.previousTime);
        while (this.unprocessedTime >= LOGIC_DELTA_TIME) {
            this.unprocessedTime -= LOGIC_DELTA_TIME;
            this.pendingUpdateCount++;
            this.updateCount++;
        }
        this.previousTime = this.currentTime;
    }

    /**
     * Check if it is time to perform an update.
     */
    public boolean needsUpdate() {
        if (this.pendingUpdateCount > 0) {
            this.pendingUpdateCount--;
            return true;
        }
        return false;
    }
}
