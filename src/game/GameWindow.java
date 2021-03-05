package game;

import javax.swing.*;

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
     * Sets up the window for drawing.
     */
    public void setupWindow() {
        this.add(this.game.getDisplay()); // Adds the game display which will draw the game.
        this.setSize(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT); // Sets the size of the window.
        this.setTitle(this.game.getTitle()); // Sets the window title.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the game when the red 'close' button is clicked.
        this.setLocationRelativeTo(null); // Centers the window.
        this.setVisible(true); // Makes the window visible.
    }

}
