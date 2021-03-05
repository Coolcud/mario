package game;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the window the game is displayed in.
 * Created by Kneesnap on 3/4/2021.
 */
public class GameWindow extends JFrame {
    public static final int GAME_SCREEN_WIDTH = 256; // Size of the NES / actual Super Mario Bros.
    public static final int GAME_SCREEN_HEIGHT = 224;
    private final Game game;

    public GameWindow(Game game) {
        this.game = game;
    }

    /**
     * Gets the width (in pixels) of the area where content can be displayed. (Ie: Window width minus the size of the title bar.)
     */
    public int getContentWidth() {
        return this.getContentPane().getWidth();
    }

    /**
     * Gets the height (in pixels) of the area where content can be displayed. (Ie: Window height minus the size of the title bar.)
     */
    public int getContentHeight() {
        return this.getContentPane().getHeight();
    }

    /**
     * Sets up the window for drawing.
     */
    public void setupWindow() {
        this.add(this.game.getDisplay()); // Adds the game display which will draw the game.

        // Do this first to allow determining the size of the borders via getContentPane().
        this.setPreferredSize(new Dimension(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT)); // Sets the size of the window.
        this.pack();

        // Resize the window according to the size of its border, so the content area is exactly the size we need.
        this.setSize(GAME_SCREEN_WIDTH + (GAME_SCREEN_WIDTH - getContentPane().getWidth()), GAME_SCREEN_HEIGHT + (GAME_SCREEN_HEIGHT - getContentPane().getHeight()));
        this.getContentPane().setSize(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT);

        // Setup window.
        this.setIconImage(TextureRegistry.MARIO_SMALL_STAND.getImage());
        this.setTitle(this.game.getTitle()); // Sets the window title.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the game when the red 'close' button is clicked.
        this.setLocationRelativeTo(null); // Centers the window.
        this.setVisible(true); // Makes the window visible.
    }

}
