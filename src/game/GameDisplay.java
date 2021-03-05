package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents the game "screen".
 * Used for drawing things to the game screen.
 * Created by Kneesnap on 3/4/2021.
 */
public class GameDisplay extends JPanel {
    private final Game game;
    private final BufferedImage buffer; // Used so the game view can be scaled with the window itself. Might also be more performant? Not sure.
    private final Graphics2D graphics;
    private int currentFrame;

    public GameDisplay(Game game) {
        this.game = game;
        this.buffer = new BufferedImage(GameWindow.GAME_SCREEN_WIDTH, GameWindow.GAME_SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB); // Don't need alpha for NES.
        this.graphics = this.buffer.createGraphics();
        // Hint: addKeyListener();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Renders graphics to the buffer.
        this.game.onRender(this.graphics);

        GameWindow window = this.game.getWindow();
        g.drawImage(this.buffer, 0, 0, window.getWidth(), window.getHeight(), null);
    }

    /**
     * Advances to the next frame.
     */
    public void nextFrame() {
        this.currentFrame++;
        this.repaint();
    }

    /**
     * Gets the frame number (which is increased every time the scene is redrawn.)
     */
    public int getCurrentFrame() {
        return this.currentFrame;
    }

    public static class GameUpdateThread extends Thread {
        private final Game game;

        public GameUpdateThread(Game game) {
            this.game = game;
        }

        @Override
        @SuppressWarnings("BusyWait")
        public void run() {
            GameTimer timer = this.game.getTimer();

            timer.start();
            while (true) {
                timer.update();
                while (timer.needsUpdate())
                    this.game.onUpdate();
                this.game.getDisplay().nextFrame();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ie) {
                    System.out.println("Exiting due to thread interruption.");
                    return;
                }
            }
        }
    }
}
