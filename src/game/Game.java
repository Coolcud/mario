package game;

import game.GameDisplay.GameUpdateThread;
import mario.MarioSoundRegistry;

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
    private final GameSoundManager soundManager;
    private final Color backgroundColor = new Color(92, 148, 252);
    private int scroll;

    public Game(String gameTitle) {
        this.title = gameTitle;
        this.display = new GameDisplay(this);
        this.window = new GameWindow(this);
        this.timer = new GameTimer();
        this.keyboardInput = new GameKeyboardInput(this);
        this.soundManager = new GameSoundManager();
    }

    /**
     * Starts the game.
     */
    public void start() {
        this.window.setupWindow();
        this.keyboardInput.setupInput();
        loadSounds();
        GameUpdateThread updateThread = new GameUpdateThread(this);
        updateThread.start(); // Starts the updater which will cause the game to periodically update.
    }

    private void loadSounds() {
        this.soundManager.loadSound(MarioSoundRegistry.COLLECT_1UP);
        this.soundManager.loadSound(MarioSoundRegistry.BEEP);
        this.soundManager.loadSound(MarioSoundRegistry.BIG_JUMP);
        this.soundManager.loadSound(MarioSoundRegistry.BOWSER_DIE);
        this.soundManager.loadSound(MarioSoundRegistry.BRICK_BREAK);
        this.soundManager.loadSound(MarioSoundRegistry.BUMP);
        this.soundManager.loadSound(MarioSoundRegistry.COIN);
        this.soundManager.loadSound(MarioSoundRegistry.DEATH_JINGLE);
        this.soundManager.loadSound(MarioSoundRegistry.ENEMY_FIRE);
        this.soundManager.loadSound(MarioSoundRegistry.THROW_FIREBALL);
        this.soundManager.loadSound(MarioSoundRegistry.FLAG_POLE);
        this.soundManager.loadSound(MarioSoundRegistry.GAME_OVER_JINGLE);
        this.soundManager.loadSound(MarioSoundRegistry.SMALL_JUMP);
        this.soundManager.loadSound(MarioSoundRegistry.KICK);
        this.soundManager.loadSound(MarioSoundRegistry.LEVEL_CLEAR_JINGLE);
        this.soundManager.loadSound(MarioSoundRegistry.LOW_TIME_JINGLE);
        this.soundManager.loadSound(MarioSoundRegistry.PAUSE);
        this.soundManager.loadSound(MarioSoundRegistry.POWERUP);
        this.soundManager.loadSound(MarioSoundRegistry.MARIO_SLIDE);
        this.soundManager.loadSound(MarioSoundRegistry.SQUISH);
        this.soundManager.loadSound(MarioSoundRegistry.THWOMP);
        this.soundManager.loadSound(MarioSoundRegistry.VINE_EMERGE);
        this.soundManager.loadSound(MarioSoundRegistry.ENTER_PIPE);
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

        // TODO: This is where you can write code to draw things. (Or, call functions to draw things.)

        GameTexture[][] tiles = {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, TextureRegistry.DECORATION_CLOUD_TOP_LEFT, TextureRegistry.DECORATION_CLOUD_TOP_MIDDLE, TextureRegistry.DECORATION_CLOUD_TOP_RIGHT, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, TextureRegistry.DECORATION_CLOUD_TOP_LEFT, TextureRegistry.DECORATION_CLOUD_TOP_MIDDLE, TextureRegistry.DECORATION_CLOUD_TOP_RIGHT, null, null, null, null, null, null, null, null, TextureRegistry.DECORATION_CLOUD_BOTTOM_LEFT, TextureRegistry.DECORATION_CLOUD_BOTTOM_MIDDLE, TextureRegistry.DECORATION_CLOUD_BOTTOM_RIGHT, null, null, null, null, TextureRegistry.DECORATION_CLOUD_TOP_LEFT, TextureRegistry.DECORATION_CLOUD_TOP_MIDDLE, TextureRegistry.DECORATION_CLOUD_TOP_MIDDLE, TextureRegistry.DECORATION_CLOUD_TOP_MIDDLE},
                {null, null, null, null, null, null, null, null, null, TextureRegistry.DECORATION_CLOUD_BOTTOM_LEFT, TextureRegistry.DECORATION_CLOUD_BOTTOM_MIDDLE, TextureRegistry.DECORATION_CLOUD_BOTTOM_RIGHT, null, null, null, null, null, null, null, null, null, null, TextureRegistry.QUESTION_BLOCK_1, null, null, null, null, TextureRegistry.DECORATION_CLOUD_BOTTOM_LEFT, TextureRegistry.DECORATION_CLOUD_BOTTOM_MIDDLE, TextureRegistry.DECORATION_CLOUD_BOTTOM_MIDDLE, TextureRegistry.DECORATION_CLOUD_BOTTOM_MIDDLE},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, TextureRegistry.SUPER_MUSHROOM, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, TextureRegistry.QUESTION_BLOCK_1, null, null, null, TextureRegistry.BREAKABLE_BRICK_1, TextureRegistry.QUESTION_BLOCK_1, TextureRegistry.BREAKABLE_BRICK_1, TextureRegistry.QUESTION_BLOCK_1, TextureRegistry.BREAKABLE_BRICK_1, null, null, null, null, null, null},
                {null, null, TextureRegistry.DECORATION_HILL_TOP, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, TextureRegistry.DECORATION_HILL_MIDDLE_LEFT, TextureRegistry.DECORATION_HILL_BOTTOM_LEFT, TextureRegistry.DECORATION_HILL_MIDDLE_RIGHT, null, null, null, null, null, null, null, null, null, null, null, null, null, TextureRegistry.DECORATION_HILL_TOP, null, null, null, null, null, null, null, null, null, null, TextureRegistry.UPRIGHT_PIPE_ENTRANCE_LEFT, TextureRegistry.UPRIGHT_PIPE_ENTRANCE_RIGHT, null},
                {TextureRegistry.DECORATION_HILL_BOTTOM_LEFTMOST, TextureRegistry.DECORATION_HILL_BOTTOM_LEFT, TextureRegistry.DECORATION_HILL_BOTTOM_MIDDLE, TextureRegistry.DECORATION_HILL_BOTTOM_RIGHT, TextureRegistry.DECORATION_HILL_BOTTOM_RIGHTMOST, null, null, null, null, null, null, TextureRegistry.DECORATION_BUSH_LEFT, TextureRegistry.DECORATION_BUSH_MIDDLE, TextureRegistry.DECORATION_BUSH_MIDDLE, TextureRegistry.DECORATION_BUSH_MIDDLE, TextureRegistry.DECORATION_BUSH_RIGHT, TextureRegistry.DECORATION_HILL_MIDDLE_LEFT, TextureRegistry.DECORATION_HILL_BOTTOM_LEFT, TextureRegistry.DECORATION_HILL_MIDDLE_RIGHT, null, null, null, TextureRegistry.GOOMBA_1, TextureRegistry.DECORATION_BUSH_LEFT, TextureRegistry.DECORATION_BUSH_MIDDLE, TextureRegistry.DECORATION_BUSH_RIGHT, null, null, TextureRegistry.UPRIGHT_PIPE_BODY_LEFT, TextureRegistry.UPRIGHT_PIPE_BODY_RIGHT, null},
                {TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK},
                {TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK, TextureRegistry.GROUND_BRICK},
        };

        int tileWidthHeight = 16; // Number of pixels in a tile's width and height. TODO: Make this a constant.

        // Draw tilemap.
        scroll++;
        for (int y = 0; y < (GameWindow.GAME_SCREEN_HEIGHT / tileWidthHeight); y++) {
            for (int x = 0; x < 31; x++) {
                GameTexture checkTile = tiles[y][x];
                if (checkTile != null) {
                    g.drawImage(checkTile.getImage(), x * tileWidthHeight - (scroll % 496), y * tileWidthHeight, null);
                }
            }
        }
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
     * Gets the game's sound manager.
     */
    public GameSoundManager getSoundManager() {
        return this.soundManager;
    }

    /**
     * Gets the game timer.
     */
    public GameTimer getTimer() {
        return this.timer;
    }
}
