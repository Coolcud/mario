package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Tracks keyboard input.
 * Created by Kneesnap on 3/6/2021.
 */
public class GameKeyboardInput {
    private final Game game;
    private final boolean[] keysPressed = new boolean[256];
    private final boolean[] keysChecked = new boolean[256];

    public GameKeyboardInput(Game game) {
        this.game = game;
    }

    /**
     * Sets up the input handler.
     */
    public void setupInput() {
        this.game.getDisplay().addKeyListener(new GameKeyboardListener());
    }

    /**
     * Test if a key is currently being pressed.
     * @param keyCode the key code to test.
     * @return isKeyDown
     */
    public boolean isKeyDown(int keyCode) {
        if (keyCode < 0 || keyCode >= this.keysPressed.length)
            throw new ArrayIndexOutOfBoundsException("Invalid key code: " + keyCode + ".");
        return this.keysPressed[keyCode];
    }

    /**
     * Test if a key has been pressed. After returning true, it will return false Will not return false until after it is released and pressed again.
     * @param keyCode The key code to test.
     * @return isKeyPressed
     */
    public boolean isKeyPressed(int keyCode) {
        if (!this.keysChecked[keyCode] && isKeyDown(keyCode)) {
            this.keysChecked[keyCode] = true;
            return true;
        }
        return false;
    }

    public class GameKeyboardListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Do nothing.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode >= 0 && keyCode < keysPressed.length)
                keysPressed[keyCode] = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode >= 0 && keyCode < keysPressed.length) {
                keysPressed[keyCode] = false;
                keysChecked[keyCode] = false;
            }
        }
    }

}
