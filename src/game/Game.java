package game;

import game.GameDisplay.GameUpdateThread;

import java.awt.*;

/**
 * Represents an instance of the running game.
 * Created by Kneesnap on 3/4/2021.
 */
public class Game {
    private final String title;
    private final GameDisplay display;
    private final GameWindow window;
    private final GameTimer timer;
    private final GameKeyboardInput keyboardInput;
    private final Color backgroundColor = new Color(92, 148, 252);

    public Game(String gameTitle) {
        this.title = gameTitle;
        this.display = new GameDisplay(this);
        this.window = new GameWindow(this);
        this.timer = new GameTimer();
        this.keyboardInput = new GameKeyboardInput(this);
    }

    /**
     * Starts the game.
     */
    public void start() {
        this.window.setupWindow();
        this.keyboardInput.setupInput();
        GameUpdateThread updateThread = new GameUpdateThread(this);
        updateThread.start(); // Starts the updater which will cause the game to periodically update.
    }

    /**
     * Called to update the game.
     */
    public void onUpdate() {
        // TODO: This is where you can put game logic. (Or rather, call game logic.)
    }

    /**
     * Called every game 'frame'. Used to draw the game scene.
     * @param g The graphics object which you can draw to.
     */
    public void onRender(Graphics2D g) {
        // Clears the background.
        g.setBackground(this.backgroundColor);
        g.clearRect(0, 0, GameWindow.GAME_SCREEN_WIDTH, GameWindow.GAME_SCREEN_HEIGHT);

        // An example image
        g.drawImage(TextureRegistry.MUSHROOM_EXTRA_LIFE.getImage(), 0, 0, null);
        // TODO: This is where you can write code to draw things. (Or, call functions to draw things.)
    }

    /**
     * Gets the title of the game.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the game's display used for drawing the game.
     */
    public GameDisplay getDisplay() {
        return this.display;
    }

    /**
     * Gets the game's window.
     */
    public GameWindow getWindow() {
        return this.window;
    }

    /**
     * Gets the game's keyboard input manager.
     */
    public GameKeyboardInput getKeyboardInput() {
        return this.keyboardInput;
    }

    /**
     * Gets the game timer.
     */
    public GameTimer getTimer() {
        return this.timer;
    }
}
